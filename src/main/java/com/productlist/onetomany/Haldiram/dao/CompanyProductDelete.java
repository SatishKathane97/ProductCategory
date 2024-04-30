package com.productlist.onetomany.Haldiram.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.productlist.onetomany.Haldiram.dto.CompanyDTO;
import com.productlist.onetomany.Haldiram.dto.ProductDTO;

public class CompanyProductDelete {
	 private static EntityManagerFactory entityManagerFactory;
	  private static EntityManager entityManager;
	  private static EntityTransaction entityTransaction;
	  
	  public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
//		CompanyDTO comapny = entityManager.find(CompanyDTO.class, 1);
//		entityManager.remove(comapny);
//		entityTransaction.commit();
		
		ProductDTO product=entityManager.find(ProductDTO.class, 1);
		entityManager.remove(product);
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
