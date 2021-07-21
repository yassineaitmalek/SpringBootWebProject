package com.Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@org.springframework.stereotype.Controller

@RequestMapping(path="/") 
public class Controller{
	
	@Autowired
	Fileuploader up;
	
	@Autowired 
	private Studentsevice ss;
	

	
	@Autowired 
	private Error_html err;
	

	
	@Autowired 
	private Userservice us;
	
	public String getMatricule() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String matricule = null;
		if (principal instanceof Userdetail) {
		   matricule = ((Userdetail)principal).getMatricule();
		 
		} else {
		   matricule = "";
		  
		}
		return matricule;
	}
	
	@RequestMapping(value = "/")
	public  String hi() {
		
		String matricule = this.getMatricule();
		
		if(	!matricule.equals("")  ){
			return "redirect:/dashboard";
		}
		
		return "index";
	}
	
	@RequestMapping(value = "/about")
	public  String about(Model model) {
		String matricule = this.getMatricule();
		if (!matricule.equals("")) {
			model.addAttribute("connected",true);
		}
		
		return "about";
	}
	
	@RequestMapping(value = "/contact")
	public  String contact(Model model) {
		String matricule = this.getMatricule();
		if (!matricule.equals("")) {
			model.addAttribute("connected",true);
		}
		return "contact";
	}
	
	
	@GetMapping(value = "/signup")
	public  String signup(@RequestParam(required = false) String error,Model model) {
		String matricule = this.getMatricule();
		if (!matricule.equals("")) {
			return "redirect:/dashboard";
		}
		
		try {
			Integer er = Integer.parseInt(error) ;
			model.addAttribute("error",err.error(er));
			return "signup";
		}
		catch (Exception e){
			return "signup";
		}
	}
	
	@RequestMapping(value = "/thanku" , method =  RequestMethod.GET)
	public  String thanku(@RequestParam String name,Model model) {
		model.addAttribute("name",name);
		return "thanku";
	}
	
	@RequestMapping(value = "/up" , method =  RequestMethod.POST)
	public  String upload(
			@RequestParam String matricule,@RequestParam String pass,@RequestParam String cpass,
			@RequestParam String fname,@RequestParam String lname,@RequestParam String date,@RequestParam String sexe,
			@RequestParam String cycle,@RequestParam String grade,@RequestParam String major,@RequestParam("copy_cin") MultipartFile copy_cin,
			@RequestParam("photo") MultipartFile photo,@RequestParam("copy_bac") MultipartFile copy_bac,
			@RequestParam("certificate_success") MultipartFile certificate_success,HttpSession session,
			Model model	, RedirectAttributes redirectAttributes) throws IllegalStateException, IOException {
		
		
		boolean found = false;
		
		try{
			found = ss.getStudentinfo(matricule.toLowerCase()).getMatricule().equalsIgnoreCase(matricule.toLowerCase());
		}
		catch(Exception e) { }
		
		if (! found){
			
			if (pass.equals(cpass)) {
				String folder_path =session.getServletContext().getRealPath("/")+"WEB-INF\\up\\"+matricule.toLowerCase()+"\\";
				String em = ss.emailgen(matricule);
				String [] file_name = {"photo", "copy_cin", "copy_bac", "certificate_success"};
				MultipartFile [] file = {photo, copy_cin, copy_bac, certificate_success};
				boolean folder = up.createfolder(folder_path);
				boolean error_upload = false;
				for( int i = 0; i<4 ; i++) {
					file_name[i] =  (String) up.uploadfile(file[i], folder_path, file_name[i]);
					
					if (file_name[i].equals("")) {
						error_upload = true;
						break;
						
					}
				}

				
				if ( error_upload) {
					// upload error
					boolean a = up.deletefolder(folder_path);
					redirectAttributes.addAttribute("error", "3");
					return "redirect:/signup";
				}
				
				
				ss.CreateStudent(matricule.toLowerCase(), fname.toLowerCase(), lname.toUpperCase(), em, cycle, major, grade, sexe, date, file_name[0], file_name[1], file_name[2], file_name[3],folder_path);
				String full_name = fname.toLowerCase() + " " + lname.toUpperCase();
				us.CreateUser(em, pass, matricule.toLowerCase());
		
				redirectAttributes.addAttribute("name", full_name);
				return "redirect:/thanku";
				
			}
			else {
				//pass do not match cpass
				redirectAttributes.addAttribute("error", "2");
				return "redirect:/signup";
			}
			
		}
		else {
			// user matricule already exists in db 
			redirectAttributes.addAttribute("error", "1");
			return "redirect:/signup";
		}
		
		
	}
	
	
	@RequestMapping(value = "/signin")
	public  String signin() {
		
		String matricule = this.getMatricule();
		
		if(	!matricule.equals("")  ){
			return "redirect:/dashboard";
		}
		
		return "signin";
	}
	
	@RequestMapping(value = "/dashboard")
	public  String dashboard( HttpSession session , Model model) {
		
		String matricule = this.getMatricule();
		
		
		Studentinfo si = ss.getStudentinfo(matricule);
		Studentdata sd = ss.getStudentdata(matricule);
		String full_name = si.getFname() + " " + si.getLname();
		model.addAttribute("si",si);
	
		model.addAttribute("sd",sd);
		
		model.addAttribute("name",full_name);
		
		return "dashboard";
	}
	
	
	@GetMapping(value = "/dashboard/show/{matricule}/{filename}")
    public ResponseEntity<InputStreamResource> Showfile(@PathVariable String matricule,@PathVariable String filename,HttpSession session) throws FileNotFoundException {
		
		String folder_path =session.getServletContext().getRealPath("/")+"WEB-INF\\up\\"+matricule+"\\";
        
         String ext = up.getExtention(filename);
 	
        File file = new File(folder_path+filename);
        HttpHeaders headers = new HttpHeaders();      
        headers.add("content-disposition", "inline; filename=" + filename);
        
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/"+ext))
                .body(resource);
    }
	
	

	@GetMapping(value = "/dashboard/changepass")
    public String changepass(@RequestParam(required = false) String error,Model model)  {
		
		try {
			Integer er = Integer.parseInt(error) ;
			model.addAttribute("error",err.error(er));
			return "changepass";
		}
		catch (Exception e){
			return "changepass";
		}
		
    }
	@PostMapping(value = "/dashboard/changepass/process/")
	public String changepassprocess( @RequestParam String op ,@RequestParam String np ,
			@RequestParam String cnp , RedirectAttributes redirectAttributes)  {
		
		String matricule = this.getMatricule();
		User u = us.getUser(matricule);

		if (us.Matchpass(op, u.getPass()) ){
			
			if(np.equals(cnp)) {
				us.UpdatePasswordUser(u, np);
				return "redirect:/logout";
			}
			else {
				redirectAttributes.addAttribute("error", "5");
				return "redirect:/dashboard/changepass";
			}
		}
		else {
			redirectAttributes.addAttribute("error", "4");
			return "redirect:/dashboard/changepass";
		}
		
		
		
		
    }
	
	
	@RequestMapping(value = "/dashboard/delaccount")
		public  String del() {
			
			return "delaccount";
		}
	
	@RequestMapping(value = "/dashboard/delaccount/process")
	public  String delprocess(HttpSession session) {
		
		String matricule = this.getMatricule();
		
		String folder_path =session.getServletContext().getRealPath("/")+"WEB-INF\\up\\"+matricule+"\\";
		
		up.deletefolder(folder_path);
		ss.DeleteStudent(matricule);
		us.DeleteUser(matricule);
		
		
		return "redirect:/logout";
	}
	
	@RequestMapping(value = "/dashboard/reup")
	public  String reup(@RequestParam(required = false) String error,Model model) {
		
		try {
			Integer er = Integer.parseInt(error) ;
			model.addAttribute("error",err.error(er));
			return "reup";
		}
		catch (Exception e){
			return "reup";
		}
	}
	
	
	@PostMapping(value = "/dashboard/reup/process")
	public  String reupprocess(@RequestParam String  file_name,@RequestParam("file_to_upload") MultipartFile file_to_upload,RedirectAttributes redirectAttributes) throws IllegalStateException, IOException {
		
		String matricule = this.getMatricule();
		
		Studentdata s = ss.getStudentdata(matricule);
		
		String uploaded = up.uploadfile(file_to_upload, s.getFolder_path(), file_name+"_test");
		String old_filename = null;
		String new_filename = null;
	
	
		
		if ( uploaded.equals("")) {
			// upload error
			redirectAttributes.addAttribute("error", "3");
			return "redirect:/dashboard/reup";
		}
		else {
			if ( up.getFileNameWithoutExtension(s.getCopy_bac()).equals(file_name)) {
				up.deletefolder(s.getFolder_path()+s.getCopy_bac());
				old_filename = uploaded;
				new_filename = uploaded.replaceFirst("_test","");
				boolean a = up.renamefile(s.getFolder_path(), old_filename, new_filename);
				s.setCopy_bac(new_filename);
				
				
			}
			
			else if ( up.getFileNameWithoutExtension(s.getCertificate_success()).equals(file_name)) {
				
				up.deletefolder(s.getFolder_path()+s.getCertificate_success());
				old_filename = uploaded;
				new_filename = uploaded.replaceFirst("_test","");
				boolean a = up.renamefile(s.getFolder_path(), old_filename, new_filename);
				s.setCertificate_success(new_filename);
			}
			else if ( up.getFileNameWithoutExtension(s.getCopy_cin()).equals(file_name)) {
				up.deletefolder(s.getFolder_path()+s.getCopy_cin());
				old_filename = uploaded;
				new_filename = uploaded.replaceFirst("_test","");
				boolean a = up.renamefile(s.getFolder_path(), old_filename, new_filename);
				s.setCopy_cin(new_filename);
			}
			else if ( up.getFileNameWithoutExtension(s.getPhoto()).equals(file_name)) {
				up.deletefolder(s.getFolder_path()+s.getPhoto());
				old_filename = uploaded;
				new_filename = uploaded.replaceFirst("_test","");
				boolean a = up.renamefile(s.getFolder_path(), old_filename, new_filename);
				s.setPhoto(new_filename);
			}
			
			
			ss.StudentdataUpdate(s);
			
			return  "redirect:/dashboard";
			
		}
		
	}
	
	
}
