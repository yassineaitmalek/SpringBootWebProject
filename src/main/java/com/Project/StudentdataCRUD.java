package com.Project;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentdataCRUD extends CrudRepository<Studentdata, Long> {
	@Query("from Studentdata s where s.matricule=:matricule ")
    public Studentdata findByMatricule(String matricule);

}
