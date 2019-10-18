/**
 * 
 */
package com.xd.dao;

import com.xd.bean.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmpMapper {
	public List<Emp> findAll();
	
	public int insertEmp(Emp emp);
	
	public int deleteEmp(int empno);
	
	public Emp findByOne(int empno);
	
	public List<Emp> findEmpNo(@Param(value = "empno") int empno);
	
	public int updateEmp(Emp emp);
	
	public List<Emp> findEmp();
	
	public int del(List<Integer> list);
	


}
