package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.persistance.bean.Address;
import com.demo.persistance.bean.Author;
import com.demo.persistance.bean.Book;
import com.demo.persistance.bean.Employee;
import com.demo.persistance.bean.FullTimeWorker;
import com.demo.persistance.bean.OrderDetails;
import com.demo.persistance.bean.PartTimeWorker;
import com.demo.persistance.bean.Passport;
import com.demo.persistance.bean.Skill;
import com.demo.persistance.bean.Student;
import com.demo.persistance.reposirory.DemoRepo;


//@RunWith(SpringRunner.class)
@SpringBootTest     //(classes=DemoApplication.class)
public class ReposiroryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DemoRepo repository;
	
	@Test
	@Transactional
	void persistEmp() {

		Employee emp = new Employee();
		emp.setName("Koushik");
		emp.setDept("CSE");
	//	emp.setManagerId(10L);

		repository.saveEmp(emp); 		    	   	
	}
	
	@Test
	void showEmp() {


		//Object obj = 
	//	repository.findEmpLst(); 
		
		//List<Object> lstObj = obj as List<Object>;
	}
	
	@Test
	void updateEmp() {
		//repository.updateEmpLst();
		
	}
		
	
	@Test
	void saveStudentWithPassport() {
					
		Passport pass = new Passport("E109");
		repository.savePassport(pass);
		Student stud = new Student("Koushik7");
		
	  //  pass.setStud(stud);		
		stud.setPassport(pass);
		repository.saveStudent(stud);
	//	repository.savePassport(pass);
	}
	
	@Test
	public void cascadeTest() {
		
		repository.removePassport();
		
		//Student stud = repository.findStudById(1L);
		//repository.removeStudent(stud);
	}
	
	@Test
	public void saveNewPassportWithPreExistingStudent() {
		  
		  repository.saveNewPassportWithPreExistingStudent(10L);
	  }
	
@Test
public void persistAuthor() {
	
	repository.persistAuthor();
}
	
	@Test
	@Transactional
	void findStudent() {
		Student student = repository.findStudById(3L);
		System.out.println(student.getName());
		System.out.println("passport Numbrt: "+student.getPassport().getNumber());
		//Passport pp = student.getPassport();
		//System.out.print(pp.getNumber());

	}
	
	@Test
	void findAllStudentWithBook() {
		
		repository.findAllStudentWithBook();
	}
	
	@Test
	void findPassport() {
		Passport passport = repository.findPassportById(3L);
		System.out.print(passport.getNumber());
		System.out.print(passport.getStud().getName());
	}
	
	@Test
	void saveBook() {			
		Book book = new Book();
		book.setName("Eng");
		
		repository.saveBook(3L,book);
	}
	
	//@Test
	/*
	 * void saveAuthor() {
	 * 
	 * Author auth = new Author(); auth.setName("BibhutiBhuan"); List<Address>
	 * addresses = new ArrayList<>(); Address address = new Address();
	 * address.setStreetName("A.P.C Road"); address.setStrNo("45/2");
	 * address.setPin(700008L); Address address1 = new Address();
	 * address1.setStreetName("A.G.C Bose Road"); address1.setStrNo("43/5");
	 * address1.setPin(700010L);
	 * 
	 * addresses.add(address); addresses.add(address1);
	 * 
	 * auth.setAddress(addresses); repository.saveAuthor(auth); }
	 */
	
	@Test
	void saveStudentWithPreeExistingBook() {
		
		repository.saveStudentWithPreeExistingBook();
	}
	
	@Test 

	void retiveStudentWithBook(){
		
		Student stud = repository.retiveStudentWithBook(3L);
		System.out.print(stud.getName());
		//logger.info("Student info",stud.getName());
		System.out.print(stud.getBooks().get(0).getName());
		//logger.info("Book Details", stud.getBooks().get(0).getName());
		
	}
	
	
	@Test 
	//@Transactional
	void retiveBookWithStudent(){
		
		Book book = repository.retiveBookWithStudent(5L);
		//System.out.println(book.getName());
		//logger.info("Student info",stud.getName());
		//System.out.println(book.getStud().getName());
		//logger.info("Book Details", stud.getBooks().get(0).getName());
		
	}
	
	
	@Test 
	@Transactional
	void insertSkillWithEmp(){
		
		Skill skill = new Skill();
		skill.setName("DevOps");
		
		Employee emp = repository.findEmpLst(12L);
		
	/*	Employee emp = new Employee();
		emp.setDept("Biotech");
		emp.setName("Dock");
		emp.setManagerId(101L);
				*/
		repository.insertSkillWithEmp(emp,skill);
		
	}
	
	@Test
	void insertSkillWithEmp1() {
		
		repository.insertSkillWithEmp();
	}
	
	@Test
	void  insertEmpWithSkill1() {
		repository.insertEmpWithSkill();
	}
	
	@Test 
	@Transactional
	void insertEmpWithSkill(){
		Skill skill = repository.getSkill(14L);
		
		Employee emp = new Employee();
		emp.setDept("Infra");
		emp.setName("Willium");
		emp.setManagerId(101L);
				
		repository.insertEmpWithSkill(emp,skill);
		
	}
	
	
	@Test
	void insertEmpWithAddress() {
		
		Employee emp = new Employee("Anamika","TexTile",1234L);
		Address add = new Address("945","S.H.K.B.Sarani",700074L);
		emp.setAddress(add);
		repository.insertEmpWithAdd(emp);
		
		
	}
	
	@Test
	void getEmpWithAdd() {
		
		repository.findEmpById(54L);
	}
	
	
	@Test
	@Transactional
	void findSkillsForAnEmp() {
		
		Employee emp = repository.findSkillsForAnEmp(14L);
		
		System.out.println(emp.getSkills());
		System.out.println(emp.getSkills().get(0).getEmps());
	}
	
	
	
	
	@Test
	@Transactional
	void findEmpsForAnSkill() {
		
		Skill skill = repository.findEmpsForAnSkill(15L);
		
		System.out.println(skill.getEmps().size());
		//System.out.println(emp.getSkills().get(0).getEmps());
	}
	
	@Test
	void insertSingleTableInherit() {
		try {
		FullTimeWorker fworker = new FullTimeWorker("Arjun",1000L);
		repository.persistWorkar(fworker);
		
		PartTimeWorker pworker = new PartTimeWorker("Abunash",1000L);
		repository.persistWorkar(pworker);
	
		}
		catch(Exception exp) {			
			exp.printStackTrace();
		}
		
	}
	
	@Test
	void insertFTM() {

		FullTimeWorker fworker = new FullTimeWorker("Arjun1",3000L);
		repository.persistFullTimeWorkar(fworker);
	}
	
	@Test
	void retriveInheritanceData() {
		
		System.out.println(repository.fetchWorkar(20L));
	}
	
	@Test
	public void JPQLQuery() {
		repository.jpqlQuery();
	}
	
	@Test
	public void insertOrder() {
		OrderDetails order = new OrderDetails();
		Map<Long,Address> items = new HashMap<>();
		items.put(1L, new Address("12/2","S.H.K",700074L));
		items.put(2L, new Address("","A.P.C",700005L));
		//items.put("Bergar",100L);
		
		order.setItems(items);
		
		repository.insertOrder(order);
	}
	
}
