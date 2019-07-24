package com.techchefs.emp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techchefs.emp.beans.EmployeeInfoBean;
import com.techchefs.emp.util.HibernateUtil;

public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@Override
	public List<EmployeeInfoBean> getAllEmployeeInfo() {
		Session session = HibernateUtil.openSession();
		String hql = "from EmployeeInfoBean";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public EmployeeInfoBean getEmployeeInfo(String id) {
		Session session = HibernateUtil.openSession();
		return session.get(EmployeeInfoBean.class, Integer.parseInt(id));
	}

	@Override
	public EmployeeInfoBean getEmployeeInfo(int id) {
		Session session = HibernateUtil.openSession();
		return session.get(EmployeeInfoBean.class, id);
	}

	@Override
	public boolean createEmployeeInfo(EmployeeInfoBean bean) {
		return saveOrUpdate(bean);
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean bean) {
		return saveOrUpdate(bean);
	}

	@Override
	public boolean deleteEmployeeIfo(int id) {
		Transaction txn = null;
		EmployeeInfoBean bean = new EmployeeInfoBean();
		bean.setId(id);

		try {
			Session session = HibernateUtil.openSession();
			txn = session.beginTransaction();
			session.delete(bean);
			txn.commit();
			return true;
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteEmployeeIfo(String id) {
		deleteEmployeeIfo(Integer.parseInt(id));
		return false;
	}

	private boolean saveOrUpdate(EmployeeInfoBean bean) {
		Transaction txn = null;
		try {
			Session session = HibernateUtil.openSession();
			txn = session.beginTransaction();
			session.saveOrUpdate(bean);
			txn.commit();
			return true;
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<EmployeeInfoBean> getEmployeesInfo(String id, String record) {
		Session session = HibernateUtil.openSession();
		String hql = "from EmployeeInfoBean where str(id) like :id";
		Query query = session.createQuery(hql);
		if (record == null) {
			query.setParameter("id", id + "%");
		} else {
			query.setParameter("id", id);
		}
		List<EmployeeInfoBean> empList = query.list();
		return empList;
	}
}
