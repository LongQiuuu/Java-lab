package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch00.HibernateUtils;

public class HibernateQueryExercise04 {
	//同時搜尋姓名 生日 薪水 
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "SELECT e.salary, e.name, e.birthday FROM Employee e";
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		   //全部存放在物件陣列裡
		   List<Object[]> list = session.createQuery(hql, Object[].class)
				   					   .getResultList();
		   for(Object[] oa : list) {
			   System.out.println(oa[0] + ", " + oa[1] + ", " + oa[2]);
		   }
		  
		   tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
