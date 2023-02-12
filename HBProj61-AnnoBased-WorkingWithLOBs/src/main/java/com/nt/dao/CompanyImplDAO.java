//CompanyImplDAO.java
package com.nt.dao;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utils.HibernateUtil;

public class CompanyImplDAO implements ICompanyDAO {

	@Override
	public void saveData() {
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;
		try(ses){
			//read image file content to Byte[]
			File file1 = new File("E:\\Eclipse Workspaces\\Hibernate-NTHB412\\HBProj61-AnnoBased-WorkingWithLOBs\\src\\main\\java\\LOBS\\SampleImage.jpg");
			InputStream is = new FileInputStream(file1);
			byte[] imageContent = new byte[(int) file1.length()];
			is.read(imageContent);
			//read text file content to char[]
			File file2 = new File("E:\\Eclipse Workspaces\\Hibernate-NTHB412\\HBProj61-AnnoBased-WorkingWithLOBs\\src\\main\\java\\LOBS\\Resume.txt");
			Reader reader = new FileReader(file2);
			char[] resumeContent = new char[(int) file2.length()];
			reader.read(resumeContent);
			//prepare entity object
			Employee emp = new Employee();
			emp.setEmpName("Akash");  emp.setEmpSalary(50000.0);
			emp.setEmpPhoto(imageContent);  emp.setEmpResume(resumeContent);
			tx = ses.beginTransaction();
			int idVal = (int) ses.save(emp);
			tx.commit();
			System.out.println("Object is saved with id value :: "+idVal);
		}//try
			
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Object is not saved some problem occured!...!!!");
			}//if
		}//catch
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		
	}//method

	@Override
	public void loadData() {
		Session ses = HibernateUtil.getSession();
		try(ses){
			Employee emp = ses.get(Employee.class, 81);
			if(emp==null) {
				System.out.println("LOBs not Found");
				return;
			}//if
			else {
				System.out.println(emp.getEmpNo()+"  "+emp.getEmpName()+"   "+emp.getEmpSalary());
				byte[] photoContent = emp.getEmpPhoto();
				char[] resumeContent = emp.getEmpResume();
				//create output stream pointing to dest file
				OutputStream os = new FileOutputStream("new_SampleImage.jpg");
				os.write(photoContent);
				os.flush();
				os.close();
				//create writer stream pointing to dest file
				Writer writer = new FileWriter("new_Resume.txt");
				writer.write(resumeContent);
				writer.flush();
				writer.close();
				System.out.println("LOBs are successfully retrieved");
			}//else
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
			}//method

	
}//class
