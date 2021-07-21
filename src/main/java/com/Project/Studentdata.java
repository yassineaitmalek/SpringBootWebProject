package com.Project;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Studentdata implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String matricule;
	
	private String photo ;
	
	private String copy_cin;
	
	private String copy_bac ;
	 
	private String certificate_success;
	
	private String folder_path ;
	
	
	public String getFolder_path() {
		return folder_path;
	}

	public void setFolder_path(String folder_path) {
		this.folder_path = folder_path;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCopy_cin() {
		return copy_cin;
	}

	public void setCopy_cin(String copy_cin) {
		this.copy_cin = copy_cin;
	}

	public String getCopy_bac() {
		return copy_bac;
	}

	public void setCopy_bac(String copy_bac) {
		this.copy_bac = copy_bac;
	}

	public String getCertificate_success() {
		return certificate_success;
	}

	public void setCertificate_success(String certificate_success) {
		this.certificate_success = certificate_success;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
		
	
	

}
