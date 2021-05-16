package com.example.mybatisdemo.controller;/**
 * @Author: LongfeiChen
 * @Description:
 * @Date: Created in 21:57 2021/5/15
 * @Modified By:
 */

import com.example.mybatisdemo.entity.TUser;
import com.example.mybatisdemo.mybatis.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
public class TUserController {
    @Autowired
    private TUserMapper tUserMapper;
    @RequestMapping("getUser/{id}")
    public TUser getmybatisDemos(@PathVariable("id") Long id){
        TUser tuser=tUserMapper.selectByPrimaryKey(1L);
        return tuser;
    }
    @RequestMapping("addUser")
    public void save( TUser tuser) {
        tUserMapper.insertSelective(tuser);
//        tUserMapper.insertSelective2(tuser);
    }
}
