package com.example.mybatisdemo.controller;/**
 * @Author: LongfeiChen
 * @Description:
 * @Date: Created in 0:28 2021/5/10
 * @Modified By:
 */

import com.example.mybatisdemo.entity.runoobTbl;
import com.example.mybatisdemo.mapper.runoobTblMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 *ClassName mybatisDemoController
 *@Description TODO
 *@Author: longfei
 *@Date: 2021/5/10 0:28
 *@Version 1.0
 **/
@RestController
public class runoobTblController {
    /**
     *
     */
    @Autowired
    private runoobTblMapper  runoobtblMapper;
    @RequestMapping("getmybatisDemos")
    public  List<runoobTbl> getmybatisDemos(){
        List<runoobTbl> mybatisdemos=runoobtblMapper.getAll();
        return mybatisdemos;
    }
    @RequestMapping("getmybatisDemo")
    public  runoobTbl getmybatisDemos(Long id){
        runoobTbl mybatisdemo=runoobtblMapper.getOne(id);
        return mybatisdemo;
    }

    @RequestMapping("add")
    public void save(runoobTbl mybatisdemo) {
        runoobtblMapper.insert(mybatisdemo);
    }
    @RequestMapping(value="delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        runoobtblMapper.delete(id);
    }

    @RequestMapping(value="hello",method= RequestMethod.GET)
   public String hello(Map<String,Object> map){
        return "饶你吗？";
    }



}
