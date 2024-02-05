package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.demo.persistance.bean.Employee;
import com.demo.persistance.bean.Skill;
import com.demo.persistance.reposirory.DemoRepo;


@SpringBootApplication
@ComponentScan("com.demo")
@EntityScan("com.demo.persistance.bean")
public class DemoApplication implements CommandLineRunner {
		
	@Autowired
	DemoRepo repository;
		
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
    @Override
    @Transactional
    public void run(String... args) throws Exception{
    	/*
    	List<Employee> empList1 = repository.findAllEmp();
    	
    	System.out.println("First Time Calling "+ empList1.size());
    	
        List<Employee> empList2 = repository.findAllEmp();
    	
    	System.out.print("Second Time Calling "+ empList2.size());
    	*/
    	
		Skill skill = new Skill();
		skill.setName("Sw Development");
		
	//	Employee emp = repository.findEmpLst(12L);
		
		Employee emp = new Employee();
		emp.setDept("Biotech");
		emp.setName("Dock");
		emp.setManagerId(101L);
				
		repository.insertSkillWithEmp(emp,skill);

		System.out.println("Hi");
		System.out.print("Koushik");
    }
		
		/*Employee emp = repository.findEmpLst(12L);
		List<Skill> skills = new ArrayList<>();
		skills.add(repository.getSkill(15L));
		skills.add(repository.getSkill(16L));
		skills.add(repository.getSkill(20L));
				
		
		repository.createManyToManyRelation(emp,skills);
		*/
    	
    	
		/*Skill skill = repository.getSkill(14L);
		
		Employee emp = new Employee();
		emp.setDept("Infra");
		emp.setName("Willium");
		emp.setManagerId(101L);
				
		repository.insertEmpWithSkill(emp,skill);*/
    	
    	/*FullTimeWorker fworker = new FullTimeWorker("Arjun",1000L);
		repository.persistWorkar(fworker);
		
		PartTimeWorker pworker = new PartTimeWorker("Abunash",1000L);
		repository.persistWorkar(pworker);*/
    	
    	//repository.jpqlQuery();
   // }
    
   


}
