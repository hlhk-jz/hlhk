package com.dao;

import com.pojo.VehiclePojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper {

    List<VehiclePojo> selectList();
}
