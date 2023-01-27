//IProductDAO.java
package com.nt.dao;

import java.util.List;

import com.nt.entity.Product;

public interface IProductDAO {
	
	public long getTotalRecordCount();
	
	public List<Product> getPageData(int startPosition, int pageSize);

}//interface
