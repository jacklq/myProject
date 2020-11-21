package com.lqtest.druid_mybatis.lqtest.controller;

import com.lqtest.druid_mybatis.lqtest.entity.Student;
import com.lqtest.druid_mybatis.lqtest.service.IStudentService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*浏览器输入：http://localhost:8081/sptest/insert
 * */
@RestController
public class CuidController {


    private Logger logger= LoggerFactory.getLogger(CuidController.class);
    @Autowired
    private IStudentService studentService;



    /*插入数据表*/
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Integer insert(@RequestBody Student student) {
        logger.info("插入数据");
        return  studentService.insert(student);

    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Integer update(@RequestBody Student student) {
        logger.info("更改数据");
        return studentService.updateByPrimaryKey(student);

    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Integer delete(@RequestBody Student student) {
        Long id=student.getId();
        logger.info("删除数据");
       return studentService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public Student select(@RequestBody Student student) {
        logger.info("查找数据");
        Long id=student.getId();
        return studentService.selectByPrimaryKey(id);

    }
    //在postman中输入为["1","28"]
    @RequestMapping(value = "/selectBatchByPrimaryKey", method = RequestMethod.POST)
    public List<Student> selectBatchByPrimaryKey(@RequestBody List<Long> inputList) {
        logger.info("批量查找数据");
        return studentService.selectBatchByPrimaryKey(inputList);
    }

    //在postman中输入为[
    //    {
    //        "id": 1,
    //        "num": "2020222",
    //        "sname": "jackup",
    //        "sex": "0",
    //        "age": "29",
    //        "cretim": "2020-12-10T00:00:00.000+0000"
    //    },
    //    {
    //        "id": 29,
    //        "num": "2020223",
    //        "sname": "jackup",
    //        "sex": "2",
    //        "age": "30",
    //        "cretim":  "2020-13-10T00:00:00.000+0000"
    //    }
    //]
    @RequestMapping(value = "/updateBatchForeach", method = RequestMethod.POST)
    public Integer updateBatchForeach(@RequestBody List<Student> studentList) {
        logger.info("批量更新数据Foreach");
        return studentService.updateBatchForeach(studentList);
    }
    @RequestMapping(value = "/updateBatchCaseWhen", method = RequestMethod.POST)
    public Integer updateBatchCaseWhen(@RequestBody List<Student> studentList) {
        logger.info("批量更新数据CaseWhen");
        return studentService.updateBatchCaseWhen(studentList);
    }

    //在postman中输入为["1","28"]
    @RequestMapping(value = "/deleteBatchByPrimaryKey", method = RequestMethod.POST)
    public Integer deleteBatchByPrimaryKey(@RequestBody List<Long> inputList) {
        logger.info("批量删除数据");
        return studentService.deleteBatchByPrimaryKey(inputList);
    }
    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public Integer insertBatch(@RequestBody List<Student> studentList) {
        logger.info("批量插入数据");
        return studentService.insertBatch(studentList);
    }

}