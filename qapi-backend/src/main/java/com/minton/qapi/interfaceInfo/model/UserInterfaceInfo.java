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
 * 用户调用接口关系
 */
@Schema(description="用户调用接口关系")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_interface_info")
public class UserInterfaceInfo {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @Schema(description="主键")
    private Long id;

    /**
     * 调用用户 id
     */
    @TableField(value = "userId")
    @Schema(description="调用用户 id")
    private Long userid;

    /**
     * 接口 id
     */
    @TableField(value = "interfaceInfoId")
    @Schema(description="接口 id")
    private Long interfaceinfoid;

    /**
     * 总调用次数
     */
    @TableField(value = "totalNum")
    @Schema(description="总调用次数")
    private Integer totalnum;

    /**
     * 剩余调用次数
     */
    @TableField(value = "leftNum")
    @Schema(description="剩余调用次数")
    private Integer leftnum;

    /**
     * 0-正常，1-禁用
     */
    @TableField(value = "`status`")
    @Schema(description="0-正常，1-禁用")
    private Integer status;

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