package com.fj.mapper;
import com.fj.entity.husband;
import org.apache.ibatis.annotations.Param;

public interface famyMapper {

    public husband selectByPrimaryKey(@Param("id") Integer id);

    public husband selectByPrimaryKey2(@Param("id") Integer id);

    public husband selectByPrimaryKey3(@Param("id") Integer id);
}
