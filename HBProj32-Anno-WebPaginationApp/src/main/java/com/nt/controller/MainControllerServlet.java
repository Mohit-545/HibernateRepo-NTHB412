package com.nt.controller;

import java.io.IOException;
import java.util.List;

import com.nt.entity.Product;
import com.nt.service.IProductMgmtService;
import com.nt.service.ProductMgmtServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainControllerServlet extends HttpServlet {
	private IProductMgmtService service;
	
	@Override
	public void init() throws ServletException {
		service = new ProductMgmtServiceImpl();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String pageSize = req.getParameter("pageSize");
		String pgNo = req.getParameter("pgNo");
		HttpSession ses = req.getSession();
		int pageNo = 0;
		
		if(pageSize!=null) {		//if submit button is clicked
			ses.setAttribute("pageSize", pageSize);
			pgNo = "1";
			pageNo = Integer.parseInt(pgNo);
		}//if
		else {		//if hyperlink is clicked
			pageNo = Integer.parseInt(pgNo);
			if(ses.getAttribute("pageSize")!=null) {
				pageSize = (String)ses.getAttribute("pageSize");
			}//if
			else
				pageSize = "3";  //default pagesize
		}//else
		
		//use service to get all records
		try {
			long pagesCount = service.getPagesCount(Integer.parseInt(pageSize));
			List<Product> list = service.getPageData(pageNo, Integer.parseInt(pageSize));
			//keep the results in the request scope 
			ses.setAttribute("pageData", list);
			ses.setAttribute("pagesCount", pagesCount);
			//forward to show_report.jsp file
			RequestDispatcher rd = req.getRequestDispatcher("/show_report.jsp");
			rd.forward(req, res);
		}//try
		catch (Exception e) {
			e.printStackTrace();
			ses.setAttribute("errMsg", e.getMessage());
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
					rd.forward(req, res);
		}//catch
	}//doGet
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost

}//class
