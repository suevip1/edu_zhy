package com.edu.zhy.text;

import lombok.Getter;

import java.util.Objects;

/**
 * Description:: EduRoleEnum
 * 教育角色枚举
 *
 * @author lilingchen
 * @version 1.0
 * @date 2019/02/20.
 */
@Getter
public enum RoleEnum {
    CUSTOMER(0, "普通用户"),
    STUDENT(1, "学员"),
    TEACHER(2, "教师"),
    ADMIN(3, "管理员"),
    POTENTIAL_STUDENT(4, "潜在学员"),
    POTENTIAL_CUSTOMER(5, "潜在客户"),
    ;

    private int type;

    private String desc;

    RoleEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    /**
     * 默认是普通用户
     *
     * @param type 类型
     * @return 角色枚举
     */
    public static RoleEnum getByType(Integer type) {
        if (type == null || Objects.equals(type, 0)) {
            return CUSTOMER;
        } else if (Objects.equals(type, 1)) {
            return STUDENT;
        } else if (Objects.equals(type, 2)) {
            return TEACHER;
        } else if (Objects.equals(type, 3)) {
            return ADMIN;
        } else if (Objects.equals(type, 4)) {
            return POTENTIAL_STUDENT;
        } else if (Objects.equals(type, 5)) {
            return POTENTIAL_CUSTOMER;
        } else {
            System.err.println("role type error, not support");
        }

        return null;
    }
}
