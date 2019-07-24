package com.tc.mywebapp.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tc.mywebapp.bean.EmployeeInfoBean;
import com.tc.mywebapp.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public final class EmployeeDAOHibernateImpl implements EmployeeDao {

	public List<EmployeeInfoBean> getAllEmployeeInfo() {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
		List<EmployeeInfoBean> beans = null;
		try (Session session = HibernateUtil.openSession();) {
			String hql = "from EmployeeInfoBean";
			Query query = session.createQuery(hql);
			beans = query.list();
		}
		return beans;

	}

	public EmployeeInfoBean getEmployeeInfo(String id) {
		try {
			return getEmployeeInfo(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}

	}

	public EmployeeInfoBean getEmployeeInfo(int id) {
		try (Session session = HibernateUtil.openSession();) {

			// 3. Open Session

			// 4. Interact with the DB via Session
			EmployeeInfoBean bean = session.get(EmployeeInfoBean.class, id);

			// 5. Close Session
			session.close();

			return bean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private boolean saveOrUpdate(EmployeeInfoBean bean) {
		Transaction txn = null;
		try (Session session = HibernateUtil.openSession();) {

			txn = session.beginTransaction();
			session.saveOrUpdate(bean);
			txn.commit();
			return true;
		} catch (Exception e) {

			log.severe(Arrays.toString(e.getStackTrace()));
			if (txn != null) {
				txn.rollback();
			}
			return false;
		}
	}

	@Override
	public boolean createEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return saveOrUpdate(bean);

	}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return saveOrUpdate(bean);
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		Transaction txn = null;
		EmployeeInfoBean bean = new EmployeeInfoBean();
		bean.setId(id);
		try (Session session = HibernateUtil.openSession();) {

			txn = session.beginTransaction();
			session.delete(bean);
			txn.commit();
			return true;
		} catch (Exception e) {
			log.severe(Arrays.toString(e.getStackTrace()));
			if (txn != null) {
				txn.rollback();
			}
			return false;
		}
	}

	@Override
	public boolean deleteEmployeeInfo(String id) {
		// TODO Auto-generated method stub
		return deleteEmployeeInfo(Integer.parseInt(id));
	}

//END of getEmployeeInfo(int) method

}
