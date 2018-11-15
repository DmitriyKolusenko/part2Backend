package com.tsystems.tshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Order {
    private Integer client_Id;
    private Integer product_Id;
    private Integer ordernumber;
    private boolean iscash;
    private boolean delivery;
    private boolean ispaid;
    private Integer count;
    private ArrayList<Product> products = new ArrayList<>();

    @JsonIgnore
    public Integer getClient_Id() {
        return client_Id;
    }

    public void setClient_Id(Integer client_Id) {
        this.client_Id = client_Id;
    }
    @JsonIgnore
    public Integer getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(Integer product_Id) {
        this.product_Id = product_Id;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public boolean isIscash() {
        return iscash;
    }

    public void setIscash(boolean iscash) {
        this.iscash = iscash;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public boolean isIspaid() {
        return ispaid;
    }

    public void setIspaid(boolean ispaid) {
        this.ispaid = ispaid;
    }
    @JsonIgnore
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}
