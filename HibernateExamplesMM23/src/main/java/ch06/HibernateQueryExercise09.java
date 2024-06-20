package ch06;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch00.HibernateUtils;

public class HibernateQueryExercise09 {
	//更新三個資料庫欄位
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		//更換條件
		String hql = "UPDATE Employee e SET e.salary = e.salary + :sal, e.birthday = :birth"
				+ " WHERE e.id = :empid";
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		   session.createQuery(hql)
		   			//更換內容
					.setParameter("sal", 3000)
					.setParameter("birth", java.sql.Date.valueOf("1982-1-25"))
					.setParameter("empid", 5)
					.executeUpdate();
		  
		   tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
	}
}
