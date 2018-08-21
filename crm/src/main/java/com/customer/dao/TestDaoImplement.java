package com.customer.dao;

import com.customer.entity.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class TestDaoImplement implements TestDao {

    //@Autowired
    private SessionFactory factory;

    public TestDaoImplement(){
        factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Test.class).buildSessionFactory();
    }


    //@Transactional
    public void insert() {

        Test test = new Test("haider 4");
        Test test2 = new Test("mofiz 4");
        
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(test);
        session.save(test2);
//        if( factory==null) {
//        	System.out.println("too much pain mada faka ");
//        }
        session.getTransaction().commit();
        factory.close();
        System.out.println("done");

    }
}
