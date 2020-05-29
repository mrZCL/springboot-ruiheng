package com.ruiheng.mapper;

import com.ruiheng.entity.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "DepartmentMapper")
public interface DepartmentMapper {
    /**
     * 查询所有部门
     * @return
     */
    List<Department> getAllDepartment(@Param("epId")Integer epId);

    /**
     * 新增部门
     * @param departmentName
     * @return
     */
    Integer addDepartment(@Param("departmentName")String departmentName,@Param("parentId")Integer parentId,@Param("epId")Integer epId);

    /**
     * 通过部门id来修改部门名字
     * @param departmentName
     * @param id
     * @return
     */
    Integer updateDepartmentName(@Param("departmentName")String departmentName,@Param("id")Integer id);

    /**
     * 通过id修改部门状态,在用户界面删除
     * @param id
     * @return
     */
    Integer updateDepartmentFindId(@Param("id")Integer id);
}