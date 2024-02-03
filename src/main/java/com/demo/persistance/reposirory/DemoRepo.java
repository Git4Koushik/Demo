package com.demo.persistance.reposirory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.persistance.bean.Author;
import com.demo.persistance.bean.Book;
import com.demo.persistance.bean.Employee;
import com.demo.persistance.bean.FullTimeWorker;
import com.demo.persistance.bean.OrderDetails;
import com.demo.persistance.bean.Passport;
import com.demo.persistance.bean.Skill;
import com.demo.persistance.bean.Student;
import com.demo.persistance.bean.Worker;

@Repository
@Transactional
public class DemoRepo {
	@Autowired
	EntityManager em;
	
	public void saveEmp(Employee emp){
				
		em.persist(emp);
		emp.setName("Koushik1");
		
		emp.setName("montu");
		em.refresh(emp);
		//em.close();
	}

	
	public List<Employee> findAllEmp(){
		
		TypedQuery<Employee> allEmp = em.createQuery("select e from Employee e",Employee.class);
		return allEmp.getResultList();
	}
	
	public Employee findEmpLst(Long id) {
		
		
	//	TypedQuery<Employee>  query =em.createNativeQuery("Select e from Employee e",Employee.class);		
		Query query  = em.createNativeQuery("Select * from Employee where id = :id",Employee.class);
		query.setParameter("id", id);
		 List<Employee> resultLst =  query.getResultList();
		 
		 return resultLst.get(0);
		 
		/* for(Employee emp : resultLst) {
			 
			System.out.println(emp.getName());
			 System.out.println(eachEmp[1]);
		 }*/
		 
 		
	}

	  public void updateEmpLst() {
		   
		  Query query  = em.createNativeQuery("update Employee set name= :name where id = :id");
		  query.setParameter("name", "montu");
		  query.setParameter("id", 12);
		  int nosRowsUpdates = query.executeUpdate();
		  
		  System.out.print(nosRowsUpdates);
	   }		 

	  
	  public void savePassport(Passport pass) {
		  
		  em.persist(pass);
	  }
	  
		public void saveNewPassportWithPreExistingStudent(Long id){
			
			Passport passport = new Passport("S34576");
			em.persist(passport);
		  
			Student stud = em.find(Student.class, id);
			stud.setPassport(passport);
			
			em.persist(stud);
			
		}
	 
	  
	public void saveStudent(Student stud) {
		
		em.persist(stud);
	}

	public void removeStudent(Student stud) {
		
		em.remove(stud);
	}
	
	public void removePassport(){
		
		try {
		//Student stud = em.find(Student.class, 2L);
		//stud.setPassport(null);
		
		Passport pass = em.find(Passport.class, 4L);
	//	pass.setNumber("DFF457");
		pass.getStud().setPassport(null);
	//	em.persist(pass);
		em.remove(pass);
		}catch(Exception ex) {
			
			System.out.print(ex);
		}
	}
	
	  public Student findStudById(Long studId) {
		  
		 Student stud = em.find(Student.class, studId);
		 
		 return stud;
	  } 
	  
	  
	  public void findAllStudentWithBook() {
		  
		//  EntityGraph<Student> entityGraph = em.createEntityGraph(Student.class);
		 // Subgraph<Object> subGr = entityGraph.addSubgraph("books");
		  
		 TypedQuery<Student> query = em.createQuery("Select s from Student s JOIN FETCH s.books b",Student.class);	 
		 List<Student> studs = query.getResultList();
		 
		 for(Student stud : studs) {
			 System.out.println(stud.getName()+"-->"+stud.getBooks().get(1));
			 
		 }
	  }  
	  
	  
	  public Passport findPassportById(Long studId) {
		  
		 return em.find(Passport.class, studId);
	  } 
	  
	  
	  
	  public void saveBook(Long studentId,Book book){
		  
		  Student stud = em.find(Student.class, studentId);
		//  stud.addBook(book);
		  book.setStud(stud);
		  em.persist(book);
		  
	  }
	  
	  public void saveAuthor(Author auth) {
		  
		  em.persist(auth);
	  }
	  
	  public void saveStudentWithPreeExistingBook() {
		  
		  Student stud = new Student("Shiba1");
		  em.persist(stud);
		  Book book = em.find(Book.class,4L);
		  em.persist(book);
	      //book.setStud(stud);
     	  //stud.addBook(book);
		  //em.persist(book);
		  //em.persist(stud);
		  
		  
	  }
	  
	  public Student retiveStudentWithBook(Long studId) {
		  
		  return em.find(Student.class,studId);
	  }
	
	  
	  
	  public Book retiveBookWithStudent(Long bookId) {
		  
		  return em.find(Book.class,bookId);
	  }
	  
	  
	  
	  public Skill getSkill(Long skillId) {
		  
		  Skill skill = em.find(Skill.class,skillId);
		  return skill;
	  }
	  
      
	  public void insertSkillWithEmp(Employee emp , Skill skill) {

		//  em.persist(emp);
		  
		
		  
		  
		  emp.addSkill(skill);
		  em.persist(skill);
			  
		  em.persist(emp);
			  
		  System.out.print("Pa");
	  }
	  
	  public void insertSkillWithEmp() {
		  
			Skill skill = new Skill();
			skill.setName("Jenkins");
		    em.persist(skill);
		    
		    Employee emp = em.find(Employee.class,12L);
		    emp.addSkill(skill);
		    em.persist(emp);
	  }
	  
	  public void insertEmpWithSkill() {
		  
			Employee emp = new Employee("Venice","Logistic",3L);	
		    em.persist(emp);
		    
		    Skill skill = em.find(Skill.class,15L);
		    emp.addSkill(skill);
		    em.persist(skill);
	  }
      
      
	  public void insertEmpWithSkill(Employee emp , Skill skill) {

		//  em.persist(emp);
		  
		  
		  emp.addSkill(skill);
		//  em.persist(skill);
			  
		  em.persist(emp);
			  
		  System.out.print("Pa");
	  }
	  
	  public void insertEmpWithAdd(Employee emp) {
		  
		  em.persist(emp);
	  }
	  
	  public  void findEmpById(Long id) {
		  
		  Employee emp = em.find(Employee.class, id);
		  System.out.print(emp.getAddress().getStreetName());
	  }
	 
	  
	  public void createManyToManyRelation(Employee emp,List<Skill> skills) {
		 for(Skill skill: skills) {
			 
			 emp.addSkill(skill);
		 } 
		// emp.addSkill(skill);
		 
		 em.persist(emp);
		  
	  }
	  
	  
	  public Employee findSkillsForAnEmp(Long id){
		  
		  Employee emp = em.find(Employee.class, id);
		  return emp;
	  }
	  
	  
	  public Skill findEmpsForAnSkill(Long id){
		  
		  Skill skill = em.find(Skill.class, id);
		  return skill;
	  }
	  
	  
	  public void persistWorkar(Worker worker) {
	    	try {
	    	em.persist(worker);
	    	}
	    	catch(Exception exp) {
				
				exp.printStackTrace();
			}
	    }
	  
	  
	  
	  public void persistFullTimeWorkar(FullTimeWorker fworker) {
	    	try {
	    	em.persist(fworker);
	    	}
	    	catch(Exception exp) {
				
				exp.printStackTrace();
			}
	    }
	  
	  
	  public Worker fetchWorkar(Long id) {
		  
		 return em.find(Worker.class, id);
	  }
	  
	  
	  public void persistAuthor() {
		  
		  try {
		  Author auth = new Author();
		  auth.setName("Vidyasagar");
		  em.persist(auth);
		  
		  Book book = new Book();
		  book.setName("Bengali-1");
		  book.setAuth(auth);
		  
		  em.persist(book);
		  
		//  auth.addBook(book.getName(), book);
		  
		
		  
		  }catch(Exception ex) {
			  
			  ex.printStackTrace();
		  }
	  }
	  
	  
	  public void insertOrder(OrderDetails order) {
		  
		  em.persist(order);
	  }
	  
	  public void jpqlQuery() {
		  
	/*Query  query = em.createQuery("delete from Book");
		query.executeUpdate();*/
	
	//	  TypedQuery<Employee> noSkillEmps = em.createQuery("select e from Employee e  where e.skills is empty",Employee.class);
	//	  TypedQuery<Employee> noSkillEmps = em.createQuery("select e from Employee e where e.name like '%.k%' order by e.name ",Employee.class);  
	//	  List<Employee> empLst = noSkillEmps.getResultList();
		  
		  
		  
		 /* for(Employee emp : empLst) {
			  
			  System.out.println(emp.getName());
			  
		  }*/
		  
		//  TypedQuery<Student> noPassStud = em.createQuery("select s from Student s where s.passport is null ",Student.class); 
		 // List<Student> studLst = noPassStud.getResultList();
		  
		  Query query = em.createQuery("select e,s from Employee e left join e.skills s");
		  List<Object[]> empSkill = query.getResultList();
		  
		  for (Object[] eachEmpSkill: empSkill) {
			  System.out.println("Employee : "+eachEmpSkill[0]+"--> Skill :" +eachEmpSkill[1]);
			  
		  }
		  
		  
	  }
	
}
