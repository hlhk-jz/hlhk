package com.service;

import com.dao.TestMapper;
import com.pojo.VehiclePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;
    @Transactional
    public List selectList() {
        List<VehiclePojo> vehiclePojos = testMapper.selectList();
        return vehiclePojos;
    }
}
