package com.ruiheng.service.impl;

import com.ruiheng.entity.Department;
import com.ruiheng.mapper.DepartmentMapper;
import com.ruiheng.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDepartment(Integer epId) {
        return departmentMapper.getAllDepartment(epId);
    }

    @Override
    public Integer addDepartment(String departmentName,Integer parentId,Integer epId) {
        return departmentMapper.addDepartment(departmentName,parentId,epId);
    }

    @Override
    public Integer updateDepartmentName(String departmentName, Integer id) {
        return departmentMapper.updateDepartmentName(departmentName,id);
    }

    @Override
    public Integer updateDepartmentFindId(Integer id) {
        return departmentMapper.updateDepartmentFindId(id);
    }
}
