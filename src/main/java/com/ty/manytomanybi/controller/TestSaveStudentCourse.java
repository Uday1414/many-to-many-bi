package com.ty.manytomanybi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomanybi.dto.Course;
import com.ty.manytomanybi.dto.Student;

public class TestSaveStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = new Student();
		student1.setName("abhi");
		student1.setAge(25);

		Student student2 = new Student();
		student2.setName("uday");
		student2.setAge(23);

		Student student3 = new Student();
		student3.setName("balaji");
		student3.setAge(25);

		List<Student> students1 = new ArrayList<Student>();
		List<Student> students2 = new ArrayList<Student>();
		List<Student> students3 = new ArrayList<Student>();
		students1.add(student1);
		students1.add(student2);
		students1.add(student3);
		students2.add(student1);
		students2.add(student2);
		students3.add(student1);
		students3.add(student3);

		List<Course> courses1 = new ArrayList<Course>();
		List<Course> courses2 = new ArrayList<Course>();
		List<Course> courses3 = new ArrayList<Course>();
		Course course1 = new Course();
		course1.setName("java");
		course1.setDuration("6 months");

		Course course2 = new Course();
		course2.setName("HTML");
		course2.setDuration("15 days");

		Course course3 = new Course();
		course3.setName("CSS");
		course3.setDuration("10 days");
		courses1.add(course1);
		courses1.add(course2);
		courses1.add(course3);
		courses2.add(course1);
		courses2.add(course2);
		courses3.add(course1);
		courses3.add(course3);

		student1.setCourses(courses1);
		student2.setCourses(courses2);
		student3.setCourses(courses3);

		course1.setStudents(students1);
		course2.setStudents(students2);
		course3.setStudents(students3);

		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
//		entityManager.persist(course1);
//		entityManager.persist(course2);
//		entityManager.persist(course3);
		entityTransaction.commit();

	}
}
