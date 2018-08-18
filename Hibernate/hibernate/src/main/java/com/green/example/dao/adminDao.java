package com.green.example.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.green.example.entity.admin;
import com.green.example.dao.HibernateUtil;
import org.hibernate.query.Query;

public class adminDao {
 
    public static void main(String[] args) {
    	System.out.println("Hello");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
       
        Query hql = session.createQuery("from admin");
		List<admin> admins = hql.list();
         
        session.close();
         
        for (admin ad : admins) {
            System.out.println(ad.getUser()+". "+ad.getPassword());
        }
    }
}

