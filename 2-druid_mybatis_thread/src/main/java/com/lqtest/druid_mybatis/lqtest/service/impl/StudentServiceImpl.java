package com.lqtest.druid_mybatis.lqtest.service.impl;

import com.lqtest.druid_mybatis.lqtest.dao.StudentDao;
import com.lqtest.druid_mybatis.lqtest.entity.Student;
import com.lqtest.druid_mybatis.lqtest.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)/*发生异常则回滚*/
public class StudentServiceImpl implements IStudentService {


    @Autowired
    private StudentDao studentDao;

    /**
     * * ********单元测试用************/
    public StudentDao getStudentDao() {
        return studentDao;
    }
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    /*************************************/


    public Integer insert(Student student) {
        return studentDao.insert(student);
    }

    public Integer deleteByPrimaryKey(Long id) {
        return studentDao.deleteByPrimaryKey(id);
    }

    public Integer updateByPrimaryKey(Student student) {
        return studentDao.updateByPrimaryKey(student);
    }

    public Student selectByPrimaryKey(Long id) {
        return studentDao.selectByPrimaryKey(id);
    }

    /*批量操作*/
    public List<Student> selectBatchByPrimaryKey(List idList) {
        return studentDao.selectBatchByPrimaryKey(idList);
    }

    public Integer updateBatchForeach(List<Student> studentList) {
        return studentDao.updateBatchForeach(studentList);
    }

    public Integer updateBatchCaseWhen(List<Student> studentList) {
        return studentDao.updateBatchCaseWhen(studentList);
    }

    public Integer  deleteBatchByPrimaryKey(List idList) {
        return studentDao.deleteBatchByPrimaryKey(idList);
    }
    public Integer insertBatch(List<Student> studentList){
        return studentDao.insertBatch(studentList);
    }



}

