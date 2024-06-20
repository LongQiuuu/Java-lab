package jut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch00.HibernateUtils;
import ch01.model.Department;

public class MyTest {
	SessionFactory factory;
	Session session;
	Transaction tx;
	@Before
	public void setUp() throws Exception {
		factory = HibernateUtils.getSessionFactory();
		session = factory.openSession();
		tx=session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		tx.commit();
		session.close();
		factory.close();
	}

	@Test
	public void test() {
		//建立資料到資料庫
		Department obj= new Department();
		obj.setDepName("研發二部");
		session.save(obj);
	}
	@Test
	public void test2() {
		System.out.println("TestB");
	}
	@Test
	public void test3() {
		System.out.println("TestC");
	}

}
