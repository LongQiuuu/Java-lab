package lab01.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import lab01.dao.MemberDao;
import lab01.model.MemberBean;
import lab01.utils.HibernateUtils;

public class MemberHibernateDaoImpl implements MemberDao {

	SessionFactory factory=null;

	public MemberHibernateDaoImpl() {
		factory=HibernateUtils.getSessionFactory();
		
	}

	//private static final String SELECT_BY_MEMBERID = "SELECT memberId, password, name, phone, birthday, registerdate, picture, weight FROM memberlab01 WHERE memberId = ?";

	public MemberBean findByMemberId(String id) {
		
		MemberBean memberBean=null;
		
		Session session = factory.getCurrentSession();
		String hql ="FROM MemberEntityA WHERE memberId = :mid";
		
		List<MemberBean> beans = session.createQuery(hql,MemberBean.class)
		                                .setParameter("mid",id)
		                                .getResultList();
		if(beans.size()>0) {
			memberBean = beans.get(0);
		}
		
		return memberBean;
	}

	//private static final String SELECT_ALL = "SELECT id, memberId, password, name, phone, birthday, registerdate, picture, weight FROM memberlab01";

	public List<MemberBean> findAll() {
		Session session = factory.getCurrentSession();
		String hql ="FROM MemberEntityA "; 
		
		List<MemberBean> beans = session.createQuery(hql,MemberBean.class)
		                                .getResultList();
		
		return beans;
	}

	//private static final String INSERT = "INSERT INTO memberlab01 (memberId, password, name, phone, birthday, registerdate, picture, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	public void save(MemberBean bean) {
		Session session = factory.getCurrentSession();
		session.save(bean);
	}

	//private static final String DELETE_BY_MEMBERID = "DELETE FROM memberlab01 WHERE memberId=?";

	public void deleteByMemberId(String memberId) {
		Session session = factory.getCurrentSession();
		String hql ="DELETE FROM MemberEntityA WHERE memberId=:mid"; 
		session.createQuery(hql)
			   .setParameter("mid",memberId)
			   .executeUpdate();
	}

	@Override
	public boolean existsByMemberId(String memberId) {
		MemberBean memberBean = findByMemberId(memberId);
		return (memberBean != null);
	}

	//private static final String SELECT_BY_ID = "SELECT id, memberId, password, name, phone, birthday, registerdate, picture, weight FROM memberlab01 WHERE id = ?";
	//一主見茶
	@Override
	public MemberBean findById(Integer id) {
		Session session =factory.getCurrentSession();
		MemberBean memberBean = session.get(MemberBean.class, id);
		
		return memberBean;
	}

	
	
	private static final String DELETE_BY_ID = "DELETE FROM memberlab01 WHERE id=?";

	@Override
	public void deleteById(Integer id) {
		Session session =factory.getCurrentSession();
		MemberBean memberBean =session.get(MemberBean.class, id);
		if(memberBean !=null) {
			session.delete(memberBean);
		}
		
	}

	//private static final String UPDATE = "UPDATE memberlab01 set name = ?,  password = ?,  phone = ?, birthday = ?,  weight = ? WHERE id = ?";

	@Override
	public void update(MemberBean memberBean) {
		Session session =factory.getCurrentSession();
		//因為我們的註冊日期是不能去異動的 可是系統又不允許使用null值 所以才會做下面兩段
		MemberBean temp=session.get(MemberBean.class, memberBean.getId());
		//但因為這樣會有相同永續物件都擁有oid 系統不允許這樣 所以要先把temp 分離
		session.evict(temp);
		//將抓取到的值放入讓他不會顯示null
		memberBean.setRegisterDate(temp.getRegisterDate());
		//更新資料庫
		session.update(memberBean);
		
		//也可以不使用update 直接使用merge 就可以不用把temp踢出去
		//session.merge(memberBean);
	}

}