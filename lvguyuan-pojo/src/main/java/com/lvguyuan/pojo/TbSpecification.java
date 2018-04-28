package com.lvguyuan.pojo;

import java.io.Serializable;

/**
 * 规格表
 */
public class TbSpecification implements Serializable {
    private Long id;//主键

    private String specName;//规格名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }
}