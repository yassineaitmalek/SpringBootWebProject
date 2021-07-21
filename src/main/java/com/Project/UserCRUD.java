package com.Project;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface UserCRUD extends CrudRepository<User, Long> {

	@Query("from User u where u.email=:email ")
    public User findByEmail(String email);
	
	@Query("from User u where u.matricule=:matricule ")
    public User findByMatricule(String matricule);

}
