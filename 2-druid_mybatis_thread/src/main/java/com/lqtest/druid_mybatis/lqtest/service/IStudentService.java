package com.lqtest.druid_mybatis.lqtest.service;

import com.lqtest.druid_mybatis.lqtest.entity.Student;

import java.util.List;


public interface IStudentService {
    public Integer insert(Student student);
    public Integer deleteByPrimaryKey(Long id);
    public Integer updateByPrimaryKey(Student student);
    public Student selectByPrimaryKey(Long id);

    public List<Student> selectBatchByPrimaryKey(List idList);
    public  Integer updateBatchForeach(List<Student> studentList);
    public  Integer updateBatchCaseWhen(List<Student> studentList);
    public Integer deleteBatchByPrimaryKey(List idList);
    public Integer insertBatch(List<Student> studentList);
}

