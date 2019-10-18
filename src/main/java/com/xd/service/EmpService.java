package com.xd.service;

import com.xd.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpService {
    public List<Emp> findAll();

    public int insertEmp(Emp emp);

    public int deleteEmp(int empno);

    public Emp findByOne(int empno);

    public List<Emp> findEmpNo(@Param(value = "empno") int empno);

    public int updateEmp(Emp emp);

    public List<Emp> findEmp();

    public int del(List<Integer> list);



}