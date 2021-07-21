package com.Project;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Studentsevice {
	
	@Autowired
	private StudentdataCRUD sdc;
	
	@Autowired
	private StudentinfoCRUD sic;
	
	public Studentinfo getStudentinfo(String matricule) {
		
		return sic.findByMatricule(matricule);
	}
	
	public Studentdata getStudentdata(String matricule) {
		
		return sdc.findByMatricule(matricule);
	}
	
	public void StudentdataUpdate(Studentdata sd) {
		
		sdc.save(sd);
	}
	
	public void StudentinfoUpdate(Studentinfo si) {
		
		sic.save(si);
	}
	
	public void CreateStudent( String matricule , String fname , String lname , String email , String cycle , String major , 
			
			String grade , String sexe , String date , String photo  , String copy_cin  , String copy_bac  , String certificate_success
			 
			, String folder_path ) {
		Date date_sql =   Date.valueOf(date);
		Studentinfo si = new Studentinfo();
			si.setMatricule(matricule);
			si.setCycle(cycle);
			si.setDate(date_sql);
			si.setEmail(email);
			si.setGrade(grade);
			si.setLname(lname);
			si.setFname(fname);
			si.setMajor(major);
			si.setSexe(sexe);
		Studentdata sd = new Studentdata();
			sd.setMatricule(matricule);
			sd.setCertificate_success(certificate_success);
			sd.setCopy_bac(copy_bac);
			sd.setPhoto(photo);
			sd.setCopy_cin(copy_cin);
			sd.setFolder_path(folder_path);
			
		sdc.save(sd);
		sic.save(si);

		

	}
	
	public String emailgen(String matricule) {
		String em = matricule.toLowerCase()+"@insea.ac.ma";
		return em;
	}
	
	public void DeleteStudent(String matricule) {
		
		Studentinfo si = this.getStudentinfo(matricule);
		Studentdata sd = this.getStudentdata(matricule);
		
		sic.delete(si);
		sdc.delete(sd);
		
	}
	

}
