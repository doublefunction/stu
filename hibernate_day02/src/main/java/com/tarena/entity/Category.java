package com.tarena.entity;

import java.util.HashSet;
import java.util.Set;

public class Category {
    private Integer cid;
    private String cname;
    //在一的一方,用一个集合表示和product的关系
    private Set<Product> products = new HashSet<Product>();
    
    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public Set<Product> getProducts() {
        return products;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}