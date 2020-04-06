package com.magic.cosmetic.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 自动填充
 *
 * @author likang
 * @date 2020/3/15 11:52
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        // 这里可以将创建人和修改人修改为当前用户信息，没时间写，暂时写死
        Date date = new Date();
        this.strictInsertFill(metaObject, "state", Boolean.class, true);
        this.strictInsertFill(metaObject, "createdBy", String.class, "管理员");
        this.strictInsertFill(metaObject, "createdTime", Date.class, date);
        this.strictInsertFill(metaObject, "updatedBy", String.class, "管理员");
        this.strictInsertFill(metaObject, "updatedTime", Date.class, date);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date date = new Date();
        this.strictUpdateFill(metaObject, "updatedBy", String.class, "管理员");
        this.strictUpdateFill(metaObject, "updatedTime", Date.class, date);
    }
}
