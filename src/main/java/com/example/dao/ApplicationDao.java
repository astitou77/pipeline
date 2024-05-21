package com.example.dao;

import com.example.beans.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ApplicationDao {

	public int saveEmployees(Employee emp) {
		int rowsAffected = 0;
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			String sql = "INSERT INTO employees VALUES (?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, emp.getFirstName());
			statement.setString(2, emp.getLastName());
			
			rowsAffected = statement.executeUpdate();
			
		}catch(SQLException e) {e.printStackTrace();}
		
		System.out.println("rows updated: " + rowsAffected);
		return rowsAffected;
	}

	// public static void main(String[] args) {
	// 	ApplicationDao myAppDao = new ApplicationDao();
		
	// 	Employee wayne = new Employee("Test111", "Test222");
	// 	myAppDao.saveEmployees(wayne);
	// }
}
