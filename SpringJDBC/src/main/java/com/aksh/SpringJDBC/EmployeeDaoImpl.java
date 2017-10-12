package com.aksh.SpringJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

public class EmployeeDaoImpl implements EmployeeDao {
	 private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Employee findEmployeeById(int empId) {
		
		  
        Employee emp = null;
        String query = "select * from employee where empid=?"; 
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rsltSet = null;
        try {
            conn = dataSource.getConnection();
            prepStmt = (PreparedStatement) conn.prepareStatement(query);
            prepStmt.setInt(1, empId);
            rsltSet = prepStmt.executeQuery();
            emp = new Employee();
            while(rsltSet.next()){
                emp.setEmpId(empId);
                emp.setName(rsltSet.getString("name"));
                emp.setSalary(rsltSet.getInt("salary"));
                emp.setDept(rsltSet.getString("dept"));
            }
             
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rsltSet != null) rsltSet.close();
                if(prepStmt != null) prepStmt.close();
            } catch(Exception ex){}
        }
        return emp;
	}
	

}
