package com.shenshanlaoyuan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by shenshanlaoyuan on 2018/4/27.
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;
    @Min(value = 18,message = "未成年少女禁止入内")
    private Integer age;
    private String cupSize;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
