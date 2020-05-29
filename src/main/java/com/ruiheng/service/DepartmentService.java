package com.ruiheng.service;

import com.ruiheng.entity.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 查询所有部门
     * @return
     */
    List<Department> getAllDepartment(Integer epId);

    /**
     * 新增部门
     * @param departmentName
     * @return
     */
    Integer addDepartment(String departmentName,Integer parentId,Integer epId);

    /**
     * 通过部门id来修改部门名字
     * @param departmentName
     * @param id
     * @return
     */
    Integer updateDepartmentName(String departmentName,Integer id);

    /**
     * 通过id修改部门状态,在用户界面删除
     * @param id
     * @return
     */
    Integer updateDepartmentFindId(Integer id);
}
