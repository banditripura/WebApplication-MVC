package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.javatpoint.beans.Emp;

public class EmpDao {
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Emp p){    
	    String jdbc="insert into Employee(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";    
	    return template.update(jdbc);    
	}    
	public int update(Emp p){    
	    String jdbc="update Employee set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";    
	    return template.update(jdbc);    
	}    
	public int delete(int id){    
	    String jdbc="delete from Employee where id="+id+"";    
	    return template.update(jdbc);    
	}    
	public Emp getEmpById(int id){    
	    String jdbc="select * from Employee where id=?";    
	    return template.queryForObject(jdbc, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));    
	}    
	public List<Emp> getEmployees(){    
	//ssList<Emp> emps=new ArrayList<Emp>();
}
}
