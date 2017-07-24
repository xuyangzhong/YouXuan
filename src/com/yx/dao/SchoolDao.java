package com.yx.dao;

import java.util.List;

import org.hibernate.Session;

import com.yx.model.Goal;
import com.yx.model.Minformation;
import com.yx.model.Nature;
import com.yx.model.School;
import com.yx.util.HibernateSessionFactory;

public class SchoolDao {
	//查出所有学校
	public List<School> SelectAllSch(){
		Session session=null;
		List<School> list=null;
		try {
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql="from School s order by s.sid asc";
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
	//根据学校名查找学校ID 
	public String SearchID(String name){
		Session session=null;
		School s=null;
		try {
			System.out.println("name="+name);
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql="from School s where s.sname=?";
			//String hql="from School s where s.sname='清华大学'";
			s=(School) session.createQuery(hql).setParameter(0, name).uniqueResult();
			//s=(School) session.createQuery(hql).uniqueResult();
			session.getTransaction().commit();
			System.out.println("s的值="+((s==null)?"null":s.getSname()));
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		if(s!=null){
			return s.getSid();
		}
		else return null;
	}
	//根据属性ID确定属性名称
	public String SearchNature(String Nid){
		Session session=null;
		Nature n=null;
		try {
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql="from Nature n where n.nid = ?";
			n=(Nature) session.createQuery(hql).setParameter(0, Nid).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return n.getNname();
	}
	//添加学校
	public boolean addSchool(Minformation minfor){
		boolean success=false;
		Session session=null;
		try {
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			session.save(minfor);
			session.getTransaction().commit();
			success=true;
		} catch (Exception e) {
			success=false;
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return success;
	}
	//添加学校分数
	public boolean addGoal(Goal goal){
		boolean success = false;
		Session session=null;
		try {
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			session.save(goal);
			session.getTransaction().commit();
			success=true;
		} catch (Exception e) {
			success=false;
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			HibernateSessionFactory.closeSession();
		}
		return success;
	}
}
