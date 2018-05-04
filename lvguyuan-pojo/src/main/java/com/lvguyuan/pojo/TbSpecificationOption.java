package com.lvguyuan.pojo;

import java.io.Serializable;

/**
 * 规格选择表
 */
public class TbSpecificationOption implements Serializable {
    private Long id;//主键

    private String optionName;//规格选项名称

    private Long specId;//规格ID

    private Integer orders;//排序

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName == null ? null : optionName.trim();
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}