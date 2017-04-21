package com.ishop.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 
 */
public class Collect implements Serializable {
    /**
     * 收藏夹表id,主键自增
     */
    private Integer id;

    /**
     * 用户id,来自用户表
     */
    private Integer userId;

    /**
     * 商品id,来自商品表
     */
    private Integer productId;

    /**
     * 创建时间
     */
    private Timestamp created;

    /**
     * 更新时间
     */
    private Timestamp updated;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
}