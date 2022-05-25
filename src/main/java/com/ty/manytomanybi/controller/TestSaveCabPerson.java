package com.ty.manytomanybi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomanybi.dto.Cab;
import com.ty.manytomanybi.dto.Person;

public class TestSaveCabPerson {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Cab cab1=new Cab();
		cab1.setDriverName("joey");
		cab1.setCost(200);
		
		Cab cab2=new Cab();
		cab2.setDriverName("ross");
		cab2.setCost(250);
		
		Cab cab3=new Cab();
		cab3.setDriverName("chandler");
		cab3.setCost(300);
		
		List<Cab> cabs1=new ArrayList<Cab>();
		cabs1.add(cab1);
		cabs1.add(cab2);
		cabs1.add(cab3);
		List<Cab> cabs2=new ArrayList<Cab>();
		cabs2.add(cab1);
		cabs2.add(cab2);
		List<Cab> cabs3=new ArrayList<Cab>();
		cabs3.add(cab2);
		cabs3.add(cab3);
		
		Person person1=new Person();
		person1.setName("Abhi");
		person1.setAge(25);
		
		Person person2=new Person();
		person2.setName("balaji");
		person2.setAge(25);
		
		Person person3=new Person();
		person3.setName("balaji");
		person3.setAge(25);
		
		person1.setCabs(cabs1);
		person2.setCabs(cabs2);
		person3.setCabs(cabs3);
				
		entityTransaction.begin();
		entityManager.persist(cab1);
		entityManager.persist(cab2);
		entityManager.persist(cab3);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityTransaction.commit();
	}
}
