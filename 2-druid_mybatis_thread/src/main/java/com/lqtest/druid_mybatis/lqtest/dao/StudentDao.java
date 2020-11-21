package com.lqtest.druid_mybatis.lqtest.dao;

import com.lqtest.druid_mybatis.lqtest.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentDao {

    /*增删改查*/
    public Integer insert(Student record);
    public Integer deleteByPrimaryKey(Long id);
    public Integer updateByPrimaryKey(Student record);
    public  Student selectByPrimaryKey(Long id);

    /*批量操作*/
    public List<Student> selectBatchByPrimaryKey(List idList);
    public Integer updateBatchForeach(List<Student> studentList);
    public Integer updateBatchCaseWhen(List<Student> studentList);
    public Integer deleteBatchByPrimaryKey(List idList);
    public Integer insertBatch(List<Student> studentList);



    public Integer insertSelective(Student record);
    public Integer updateByPrimaryKeySelective(Student record);


}