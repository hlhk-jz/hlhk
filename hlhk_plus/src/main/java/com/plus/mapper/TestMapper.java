package com.plus.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.plus.entty.TestEntty;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper extends BaseMapper<TestEntty> {
    void deled(Long id);

    String queryData( Long id);

    String selectData(@Param("id") String id,@Param("in_name") String name);
}
