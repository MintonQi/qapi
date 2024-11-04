package com.minton.qapi.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createtime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updatetime", Date.class, new Date());
        this.strictInsertFill(metaObject, "isdelete", Byte.class, (byte) 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatetime", Date.class, new Date());
    }

}
