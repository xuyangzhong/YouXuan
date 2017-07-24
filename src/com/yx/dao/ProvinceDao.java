package com.yx.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.yx.model.Province;
import com.yx.util.HibernateSessionFactory;

public class ProvinceDao {
	//查找出所有省份
	public List<Province> SelectAllPro(){
		Session session=null;
		List<Province> list=null;
		try {
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql="from Province p order by p.pid asc";
			list=session.createQuery(hql).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			HibernateSessionFactory.closeSession();
		}
		return list;
	}
	//根据省份名查找省份ID
	public String SearchID(String name){
		Session session=null;
		Province p=null;
		try {
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql="from Province p where p.pname = ?";
			p=(Province) session.createQuery(hql).setParameter(0, name).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return p.getPid();
	}
}
