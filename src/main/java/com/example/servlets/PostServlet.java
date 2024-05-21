package com.example.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.beans.Employee;
import com.example.dao.ApplicationDao;

public class PostServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		System.out.println("Servlet 'doPost' method of 'AddEmployeeServlet' was called ");
		ApplicationDao myAppDao = new ApplicationDao();
		
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		
		Employee newEmployee = new Employee(firstName, lastName);
		myAppDao.saveEmployees(newEmployee);
		System.out.println("EMPLOYEE REGISTERED ! " + firstName + ", " + lastName);

        resp.sendRedirect("addEmployee.html");

    }

}
