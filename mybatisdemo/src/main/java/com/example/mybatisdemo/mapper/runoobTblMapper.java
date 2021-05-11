package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.runoobTbl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: LongfeiChen
 * @Description:
 * @Date: Created in 23:46 2021/5/9
 * @Modified By:
 */
@Mapper
public interface runoobTblMapper {
    List<runoobTbl> getAll();

    runoobTbl getOne(Long id);

    void insert(runoobTbl mybatisdemo);

    void update(runoobTbl mybatisdemo);

    void delete(Long id);

}
