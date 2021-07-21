package com.Project;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface StudentinfoCRUD extends CrudRepository<Studentinfo, Long> {

	@Query("from Studentinfo s where s.matricule=:matricule ")
    public Studentinfo findByMatricule(String matricule);

}
