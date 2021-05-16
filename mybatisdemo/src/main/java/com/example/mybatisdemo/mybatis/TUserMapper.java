package com.example.mybatisdemo.mybatis;

import com.example.mybatisdemo.entity.TUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}