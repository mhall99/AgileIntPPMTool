package io.agileintelligence.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.agileintelligence.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	//@Override
	//Iterable<Project> findAllById(Iterable<Long> iterable);
	Project findByProjectIdentifier(String productId);
	
	Iterable<Project> findAllByProjectLeader(String username);

	@Override
	Iterable<Project> findAll();
}
