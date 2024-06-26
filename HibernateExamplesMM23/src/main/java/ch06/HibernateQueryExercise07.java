package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch00.HibernateUtils;

public class HibernateQueryExercise07 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//群組的應用
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "SELECT e.depId, SUM(e.salary), MAX(e.salary) "
				   + " FROM Employee e GROUP BY e.depId";
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		
		   List<Object[]> emps = session.createQuery(hql)
				   					    .getResultList();
		   for(Object[] oa : emps) {
			   System.out.println(oa[0] + ", " + oa[1]+ ", " + oa[2]);
		   }
		   tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
