package com.superpoet.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 菜品口味关系表
 * @TableName dish_flavor
 */
@TableName(value ="dish_flavor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishFlavor implements Serializable {
    private static final long serialVersionUID = -54590813093165158L;
    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 菜品
     */
    @TableField(value = "dish_id")
    private Long dishId;

    /**
     * 口味名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 口味数据list
     */
    @TableField(value = "value")
    private String value;

    /**创建时间*/
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**更新时间*/
    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 修改人
     */
    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

    /**
     * 是否删除
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;
}
