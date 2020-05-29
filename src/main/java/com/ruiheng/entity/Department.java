package com.ruiheng.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 部门类
 */
@Data
public class Department implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 部门父级id
     */
    private Integer parentId;

    /**
     * 企业id
     */
    private Integer epId;

    /**
     * 状态1有效2删除
     */
    private Integer status;

    /**
     * 该部门下的所有员工
     */
    private Integer count;

}
