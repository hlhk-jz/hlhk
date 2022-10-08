package com.plus.entty;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("hlhk")
public class TestEntty {
    @TableId(value = "id",type = IdType.AUTO)//这个用于主键上的注解，mybatis-plus默认注解是id
    //type = IdType.AUTO 这个是自动，但是数据库中需要自增
    //@TableId(value = "emp_id",type =IdType.ASSIGN_ID ) 这个是mybatis-plus利用雪花算法，产生主键
    // INPUT   insert 前自行 set 主键值
    private Integer id;
    @TableField(value = "fen_shu")
    private String fenshu;
    private String type;
}
