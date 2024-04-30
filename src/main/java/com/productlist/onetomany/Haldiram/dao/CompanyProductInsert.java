package com.productlist.onetomany.Haldiram.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.productlist.onetomany.Haldiram.dto.CompanyDTO;
import com.productlist.onetomany.Haldiram.dto.ProductDTO;

public class CompanyProductInsert {
  private static EntityManagerFactory entityManagerFactory;
  private static EntityManager entityManager;
  private static EntityTransaction entityTransaction;
  
    public static void main(String[] args) {
	   CompanyDTO company=new CompanyDTO();
	   company.setName("Haldiram");
	   company.setLocation("Nagpur");
	   
	   
	   ProductDTO product1=new ProductDTO();
	   product1.setCategory("snack");
	   product1.setName("Panchratan Bhujiya");
	   product1.setPrice(20);
	   
	   ProductDTO product2=new ProductDTO();
	   product1.setCategory("snack");
	   product1.setName("Aalu Bhujiya");
	   product1.setPrice(10);
	   
	   ProductDTO product3=new ProductDTO();
	   product1.setCategory("sweet");
	   product1.setName("Gulab Jamun");
	   product1.setPrice(100);
	   
	   ProductDTO product4=new ProductDTO();
	   product1.setCategory("sweet");
	   product1.setName("Soan Papadi");
	   product1.setPrice(150);
	   
	   ProductDTO product5=new ProductDTO();
	   product1.setCategory("sweet");
	   product1.setName("Kaju Katli");
	   product1.setPrice(40);
	   
	   
	   List<ProductDTO>products=new ArrayList<ProductDTO>();
	   products.add(product1);
	   products.add(product2);
	   products.add(product3);
	   products.add(product4);
	   products.add(product5);
	   
	   company.setProductes(products);
	   
	    openConnection();
	    entityTransaction.begin();
	    
	    entityManager.persist(product1);
	    entityManager.persist(product2);
	    entityManager.persist(product3);
	    entityManager.persist(product4);
	    entityManager.persist(product5);
	    entityManager.persist(company);
	    
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
