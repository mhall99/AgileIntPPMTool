package io.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.Backlog;
import io.agileintelligence.ppmtool.domain.ProjectTask;
import io.agileintelligence.ppmtool.repositories.BacklogRepository;
import io.agileintelligence.ppmtool.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {

	@Autowired
	private BacklogRepository backlogRepository;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
		
		//EXCEPTIONS: project not found 
		
		//PTs to be added to a specific project
		Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
		//project != null
		//set backlog (bl) to project task (pt)
		projectTask.setBacklog(backlog);
		
		//we want the sequence to be like
		//IDPRO-1 IDPRO-2 ... 100 101
		Integer BacklogSequence = backlog.getPTSequence();
		//update the bl sequence 
		BacklogSequence++;
		
		backlog.setPTSequence(BacklogSequence);
		
		//Add sequence to project task 
		projectTask.setProjectSequence(projectIdentifier+"-"+BacklogSequence);
		projectTask.setProjectIdentifier(projectIdentifier);	
		
		//initial priority when priority null 
		
		if(projectTask.getPriority()==null) { //in the future we need to projectTask.getPriority() == 0 to handle the form  
			projectTask.setPriority(3);
		} 
		//INITIAL status when status is null 
		if(projectTask.getStatus()==null||projectTask.getStatus()=="") {
			projectTask.setStatus("TO_DO");
		}
		
		return projectTaskRepository.save(projectTask);
	}
}
