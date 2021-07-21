package com.Project;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Aspect 
@Component
public class WebServiceAspect {
	//CREATE STUDENT
	
	@Before( "execution(* Studentsevice.CreateStudent(..)) and args(matricule , fname , lname , email , cycle , major , grade , sexe , date , photo  , copy_cin  , copy_bac  , certificate_success, folder_path)")
	public void beforecreationstudent(JoinPoint joinPoint, String matricule  , String fname , String lname , String email , String cycle , String major , 
			
			String grade , String sexe , String date , String photo  , String copy_cin  , String copy_bac  , String certificate_success
			 
			, String folder_path) {
		System.out.println("Before Methode :" + joinPoint.getSignature());
		System.out.println("Student Creation  : Matricule - "+matricule );
	}
	@After("execution(* Studentsevice.CreateStudent(..)) and args(matricule , fname , lname , email , cycle , major , grade , sexe , date , photo  , copy_cin  , copy_bac  , certificate_success, folder_path)")
	public void aftercreationstudent(JoinPoint joinPoint, String matricule , String fname , String lname , String email , String cycle , String major , 
			
			String grade , String sexe , String date , String photo  , String copy_cin  , String copy_bac  , String certificate_success
			 
			, String folder_path) {
		System.out.println("After Methode :" + joinPoint.getSignature());
		System.out.println("Student Creation Success: Matricule - " + matricule );
	}
	
	
	//DELETE STUDENT
	
	@Before( "execution(* Studentsevice.DeleteStudent(..)) and args(matricule )")
	public void beforedeletestudent(JoinPoint joinPoint, String matricule  ) {
		System.out.println("Before Methode :" + joinPoint.getSignature());
		System.out.println("Student Removal   : Matricule - "+matricule );
	}
	@After("execution(* Studentsevice.DeleteStudent(..)) and args(matricule )")
	public void afterdeletestudent(JoinPoint joinPoint, String matricule ) {
		System.out.println("After Methode :" + joinPoint.getSignature());
		System.out.println("Student Removal Success: Matricule - " + matricule );
	}
	
	
	//CREATE FOLDER
	@Before( "execution(* Fileuploader.createfolder(..)) and args(folder_path )")
	public void beforecreatefolder(JoinPoint joinPoint, String folder_path  ) {
		System.out.println("Before Methode :" + joinPoint.getSignature());
		System.out.println("Folder Creation   : Path - "+folder_path );
	}
	@After("execution(* Fileuploader.createfolder(..)) and args(folder_path )")
	public void aftercreatefolder(JoinPoint joinPoint, String folder_path) {
		System.out.println("After Methode :" + joinPoint.getSignature());
		System.out.println("Folder Creation Success: Path - " + folder_path );
	}
	
	//DELETE FOLDER 
	@Before( "execution(* Fileuploader.deletefolder(..)) and args(folder_path )")
	public void beforedeletefolder(JoinPoint joinPoint, String folder_path  ) {
		System.out.println("Before Methode :" + joinPoint.getSignature());
		System.out.println("Folder Removal   : Path - "+folder_path );
	}
	@After("execution(* Fileuploader.deletefolder(..)) and args(folder_path )")
	public void afterdeletefolder(JoinPoint joinPoint, String folder_path) {
		System.out.println("After Methode :" + joinPoint.getSignature());
		System.out.println("Folder Removal Success: Path - " + folder_path );
	}
	
	//FILE UPLOAD
	
	@Before( "execution(* Fileuploader.uploadfile(..)) and args(file,folder_path,file_name )")
	public void beforeuploadfile(JoinPoint joinPoint, MultipartFile file,String folder_path,String file_name ) {
		System.out.println("Before Methode :" + joinPoint.getSignature());
		System.out.println("File Upload   : Destination - "+folder_path+file_name );
	}
	@After("execution(* Fileuploader.uploadfile(..)) and args(file,folder_path,file_name )")
	public void afteruploadfile(JoinPoint joinPoint, MultipartFile file,String folder_path,String file_name) {
		System.out.println("After Methode :" + joinPoint.getSignature());
		System.out.println("File Upload Success: Destination - " + folder_path+file_name );
	}
	
	// FILE CHANGE 
	
	@Before( "execution(* Fileuploader.renamefile(..)) and args(folder_path,old_filename, new_filename)")
	public void beforrenamefile(JoinPoint joinPoint,String folder_path,String old_filename,String new_filename ) {
		System.out.println("Before Methode :" + joinPoint.getSignature());
		System.out.println("File Changed   : Destination - "+folder_path+old_filename );
	}
	@After("execution(* Fileuploader.renamefile(..)) and args(folder_path,old_filename, new_filename )")
	public void afterrenamefile(JoinPoint joinPoint, String folder_path,String old_filename,String new_filename) {
		System.out.println("After Methode :" + joinPoint.getSignature());
		System.out.println("File Changed Success: Destination - " + folder_path+new_filename );
	}
	
	// UPDATE STUDENT
	@Before( "execution(* Studentsevice.StudentdataUpdate(..)) and args(sd )")
	public void beforeStudentdataUpdate(JoinPoint joinPoint, Studentdata sd  ) {
		System.out.println("Before Methode :" + joinPoint.getSignature());
		System.out.println("Student Data Update   : Matricule - "+sd.getMatricule() );
	}
	@After("execution(* Studentsevice.StudentdataUpdate(..)) and args(sd )")
	public void afterStudentdataUpdate(JoinPoint joinPoint, Studentdata sd ) {
		System.out.println("After Methode :" + joinPoint.getSignature());
		System.out.println("Student Data Update Success: Matricule - " + sd.getMatricule() );
	}
	
	// CREATE USER 
	
	@Before( "execution(* Userservice.CreateUser(..)) and args( email ,pass, matricule )")
	public void beforeCreateUser(JoinPoint joinPoint, String email,String pass,String matricule  ) {
		System.out.println("Before Methode :" + joinPoint.getSignature());
		System.out.println("User Creation  : Email - "+email );
	}
	@After("execution(* Userservice.CreateUser(..)) and args(email ,pass, matricule  )")
	public void afterCreateUsere(JoinPoint joinPoint, String email,String pass,String matricule) {
		System.out.println("After Methode :" + joinPoint.getSignature());
		System.out.println("User Creation Success: Email - " + email );
	}
	
	
	// DELETE USER
	@Before( "execution(* Userservice.DeleteUser(..)) and args( matricule )")
	public void beforeDeleteUser(JoinPoint joinPoint, String matricule  ) {
		System.out.println("Before Methode :" + joinPoint.getSignature());
		System.out.println("User Removal  : Matricule - "+matricule );
	}
	@After("execution(* Userservice.DeleteUser(..)) and args( matricule  )")
	public void afterDeleteUser(JoinPoint joinPoint, String matricule) {
		System.out.println("After Methode :" + joinPoint.getSignature());
		System.out.println("User Removal Success: Matricule - " + matricule );
	}
	
	
	// UPDATE PASS
	
	@Before( "execution(* Userservice.UpdatePasswordUser(..)) and args( user,password )")
	public void beforeUpdatePasswordUser(JoinPoint joinPoint, User user ,String password  ) {
		System.out.println("Before Methode :" + joinPoint.getSignature());
		System.out.println("User Password Update  : Email - "+user.getEmail() );
	}
	@After("execution(* Userservice.UpdatePasswordUser(..)) and args( user,password   )")
	public void afterUpdatePasswordUser(JoinPoint joinPoint, User user ,String password) {
		System.out.println("After Methode :" + joinPoint.getSignature());
		System.out.println("User Password Update Success: Email - " + user.getEmail() );
	}
	

}
