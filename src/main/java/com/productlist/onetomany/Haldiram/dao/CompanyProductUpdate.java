package com.productlist.onetomany.Haldiram.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.productlist.onetomany.Haldiram.dto.CompanyDTO;

public class CompanyProductUpdate {
	 private static EntityManagerFactory entityManagerFactory;
	  private static EntityManager entityManager;
	  private static EntityTransaction entityTransaction;
	  
	  public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		CompanyDTO company=entityManager.find(CompanyDTO.class, 2);
		company.setLocation("Mumbai");
		entityTransaction.commit();
		closeConnection();
	}
	  private static void openConnection() {
		  entityManagerFactory =Persistence.createEntityManagerFactory("company");
		  entityManager =entityManagerFactory.createEntityManager();
		  entityTransaction=entityManager.getTransaction();
	  }
	  private static void closeConnection() {
		  if(entityManagerFactory !=null) {
			  entityManagerFactory.close();
		  }
		 if(entityManager !=null) {
			 entityManager.close();
		 }
		 if(entityTransaction !=null) {
			if(entityTransaction.isActive()) {
				 entityTransaction.rollback();
			}
		 }
	  }
}
