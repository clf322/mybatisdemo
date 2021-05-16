package com.example.mybatisdemo.mybatis;

import com.example.mybatisdemo.entity.TblStudents;
import org.springframework.stereotype.Repository;

@Repository
public interface TblStudentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblStudents record);

    int insertSelective(TblStudents record);

    TblStudents selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblStudents record);

    int updateByPrimaryKey(TblStudents record);
}