package com.example.mybatisdemo.controller;/**
 * @Author: LongfeiChen
 * @Description:
 * @Date: Created in 21:57 2021/5/15
 * @Modified By:
 */

import com.example.mybatisdemo.entity.TblStudents;
import com.example.mybatisdemo.mybatis.TblStudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *ClassName TblStudentsController
 *@Description TODO
 *@Author: longfei
 *@Date: 2021/5/15 21:57
 *@Version 1.0
 **/
@RestController
public class TblStudentsController {
    @Autowired
    private TblStudentsMapper tblStudentsMapper;
    @RequestMapping("gettblStudents/{id}")
    public TblStudents getmybatisDemos(@PathVariable("id") Integer id){
        TblStudents tblStudents=tblStudentsMapper.selectByPrimaryKey(1);
        return tblStudents;
    }
}
