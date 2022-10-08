package com.plus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plus.entty.TestEntty;
import com.plus.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestMapper mapper;
    public List<TestEntty> selectList() {
        return mapper.selectList(new QueryWrapper<>());
    }

    public Object pages() {
        Page page = new Page(1,10);
        IPage<TestEntty> iPage = mapper.selectPage(page, new QueryWrapper<>());
        return iPage;
    }


    public void deleId(Long id) {
        mapper.deled(id);
    }

    public String queryData( Long id) {
        return mapper.queryData(id);
    }

    public String selectData(String id, String name) {
        return mapper.selectData(id,name);
    }
}
