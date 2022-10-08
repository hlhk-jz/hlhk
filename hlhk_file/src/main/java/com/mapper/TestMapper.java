package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface TestMapper {
    void insert(@Param(value="map") Map<String,Object> map, @Param(value="table_name") String tableName);
}
