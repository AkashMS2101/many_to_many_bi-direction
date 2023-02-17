package many_to_many_bi1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_many_bi1.dto.Course;
import many_to_many_bi1.dto.Student;

public class SaveStudent {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setS_id(1);
		s1.setS_name("Raju");
		s1.setPhone(9854623);
		
		Student s2 = new Student();
		s2.setS_id(2);
		s2.setS_name("Rajesh");
		s2.setPhone(85324623);
		
		Student s3 = new Student();
		s3.setS_id(3);
		s3.setS_name("Ramu");
		s3.setPhone(6354623);
		
		Course c1 = new Course();
		c1.setC_id(101);
		c1.setC_name("JAVA");
		c1.setDuration("2 month");
		
		Course c2 = new Course();
		c2.setC_id(102);
		c2.setC_name("ADV-JAVA");
		c2.setDuration("1.5 month");
		
		Course c3 = new Course();
		c3.setC_id(103);
		c3.setC_name("SQL");
		c3.setDuration("1 month");
		
		List<Course> CourseList1 = new ArrayList<Course>();
		CourseList1.add(c1);
		CourseList1.add(c2);
		
		List<Course> CourseList2 = new ArrayList<Course>();
		CourseList2.add(c1);
		CourseList2.add(c2);
		CourseList2.add(c3);
		
		List<Student> S_list = new ArrayList<Student>();
		S_list.add(s1);
		S_list.add(s2);
		
		List<Student> S_list2 = new ArrayList<Student>();
		S_list2.add(s3);
		
		c1.setList(S_list);
		c2.setList(S_list);
		c3.setList(S_list2);
		
		s1.setList(CourseList1);
		s2.setList(CourseList1);
		s3.setList(CourseList2);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);
		
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);
		
		entityTransaction.commit();
		
	}
}



















