package com.minton.qapi.interfaceInfo.model;

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
 * 接口信息
 */
@Schema(description="接口信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "interface_info")
public class InterfaceInfo {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description="主键")
    private Long id;

    /**
     * 名称
     */
    @TableField(value = "`name`")
    @Schema(description="名称")
    private String name;

    /**
     * 描述
     */
    @TableField(value = "description")
    @Schema(description="描述")
    private String description;

    /**
     * 接口地址
     */
    @TableField(value = "url")
    @Schema(description="接口地址")
    private String url;

    /**
     * 请求参数
     */
    @TableField(value = "requestParams")
    @Schema(description="请求参数")
    private String requestparams;

    /**
     * 请求头
     */
    @TableField(value = "requestHeader")
    @Schema(description="请求头")
    private String requestheader;

    /**
     * 响应头
     */
    @TableField(value = "responseHeader")
    @Schema(description="响应头")
    private String responseheader;

    /**
     * 接口状态（0-关闭，1-开启）
     */
    @TableField(value = "`status`")
    @Schema(description="接口状态（0-关闭，1-开启）")
    private Integer status;

    /**
     * 请求类型
     */
    @TableField(value = "`method`")
    @Schema(description="请求类型")
    private String method;

    /**
     * 创建人
     */
    @TableField(value = "userId")
    @Schema(description="创建人")
    private Long userid;

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
     * 是否删除(0-未删, 1-已删)
     */
    @TableField(value = "isDelete")
    @Schema(description="是否删除(0-未删, 1-已删)")
    private Byte isdelete;
}