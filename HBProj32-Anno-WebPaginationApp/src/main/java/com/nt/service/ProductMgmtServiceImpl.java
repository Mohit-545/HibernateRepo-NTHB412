//ProductMgmtServiceImpl.java
package com.nt.service;

import java.util.List;

import com.nt.dao.IProductDAO;
import com.nt.dao.ProductDAOImpl;
import com.nt.entity.Product;

public class ProductMgmtServiceImpl implements IProductMgmtService {
	private IProductDAO dao;
	
	public ProductMgmtServiceImpl() {
		dao = new ProductDAOImpl();
	}//constructor

	@Override
	public long getPagesCount(int pageSize) {
		//get total no of records in the db table
		long totalRecords = dao.getTotalRecordCount();
		//get PagesCount by applying default formula
		long pagesCount = totalRecords/pageSize;
			if(totalRecords%pageSize!=0) {
				pagesCount++;
			}//if
		return pagesCount;
	}

	@Override
	public List<Product> getPageData(int pageNo, int pageSize) {
		//find out startPosition for pagination
		int startPosition = (pageNo*pageSize) - pageSize;
		//get given page data from dao
		List<Product> list = dao.getPageData(startPosition, pageSize);
		return list;
	}

}//class
