package com.toluene.commonbatis.crud;

import java.math.BigDecimal;

public class Lineitem extends LineitemKey {
    private String itemid;

    private Integer quantity;

    private BigDecimal unitprice;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public String toString() {
        return "Lineitem [itemid=" + itemid + ", quantity=" + quantity
                + ", unitprice=" + unitprice + ", getOrderid()=" + getOrderid()
                + ", getLinenum()=" + getLinenum() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
}