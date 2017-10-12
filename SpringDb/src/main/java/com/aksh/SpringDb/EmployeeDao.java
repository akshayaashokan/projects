package com.aksh.SpringDb;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int saveEmployee(Employee e){  
	   // String query="insert into employee values("+e.getEmpid()+"  "+e.getName()+"  "+e.getSalary()+"  "+e.getDept()+")";  
		String query="INSERT INTO employee " + "VALUES (2,'akshaya',1000,'kl')";
		return jdbcTemplate.update(query);  
	}  
	
	public int deleteEmployee(Employee e){  
	    String query="delete from employee where empid=2 ";  
	    return jdbcTemplate.update(query);  
	}  
}
