//ProductDAOImpl.java
package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class ProductDAOImpl implements IProductDAO {

	@Override
	public long getTotalRecordCount() {
		Session ses = HibernateUtil.getSession();
		try(ses){
				Query query = ses.createQuery("select count(*) from Product");
				long count = (long) query.getSingleResult();
				return count;
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		}//catch
	}

	@Override
	public List<Product> getPageData(int startPosition, int pageSize) {
		Session ses = HibernateUtil.getSession();
		try(ses){
			//prepare and execute HQL Select query
			Query query = ses.createQuery("from Product order by pid asc");
			//set values Pagination params
			query.setFirstResult(startPosition);
			query.setMaxResults(pageSize);
			List<Product> list = query.getResultList();
			return list;
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		}//catch
	}

}//class
