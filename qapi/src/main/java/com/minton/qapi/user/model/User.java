package com.minton.qapi.user.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 */
@Schema(description="用户")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`")
public class User {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @Schema(description="id")
    private Long id;

    /**
     * 用户昵称
     */
    @TableField(value = "userName")
    @Schema(description="用户昵称")
    private String username;

    /**
     * 账号
     */
    @TableField(value = "userAccount")
    @Schema(description="账号")
    private String useraccount;

    /**
     * 用户头像
     */
    @TableField(value = "userAvatar")
    @Schema(description="用户头像")
    private String useravatar;

    /**
     * 性别
     */
    @TableField(value = "gender")
    @Schema(description="性别")
    private Byte gender;

    /**
     * 用户角色：user / admin
     */
    @TableField(value = "userRole")
    @Schema(description="用户角色：user / admin")
    private String userrole;

    /**
     * 密码
     */
    @TableField(value = "userPassword")
    @Schema(description="密码")
    private String userpassword;

    /**
     * accessKey
     */
    @TableField(value = "accessKey")
    @Schema(description="accessKey")
    private String accesskey;

    /**
     * secretKey
     */
    @TableField(value = "secretKey")
    @Schema(description="secretKey")
    private String secretkey;

    /**
     * 创建时间
     */
    @TableField(value = "createTime",fill = FieldFill.INSERT)
    @Schema(description="创建时间")
    private Date createtime;

    /**
     * 更新时间
     */
    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    @Schema(description="更新时间")
    private Date updatetime;

    /**
     * 是否删除
     */
    @TableField(value = "isDelete", fill = FieldFill.INSERT)
    @Schema(description="是否删除")
    private Byte isdelete;
}