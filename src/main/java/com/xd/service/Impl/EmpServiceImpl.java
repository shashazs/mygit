package com.xd.service.Impl;

import com.xd.bean.Emp;
import com.xd.dao.EmpMapper;
import com.xd.service.EmpService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EmpServiceImpl implements EmpService{


    @Autowired
    private EmpMapper empMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Emp> findAll(){
        return empMapper.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertEmp(Emp emp){
        return empMapper.insertEmp(emp);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteEmp(int empno){
        return empMapper.deleteEmp(empno);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
    public Emp findByOne(int empno){
        return empMapper.findByOne(empno);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
    public List<Emp> findEmpNo(@Param(value = "empno") int empno){
        return empMapper.findEmpNo(empno);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateEmp(Emp emp){
        return empMapper.updateEmp(emp);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Emp> findEmp(){
        return empMapper.findEmp();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int del(List<Integer> list){
        return empMapper.del(list);
    }


}