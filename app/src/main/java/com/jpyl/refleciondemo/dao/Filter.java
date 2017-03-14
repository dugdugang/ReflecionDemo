package com.jpyl.refleciondemo.dao;

import com.jpyl.refleciondemo.dao.anno.Column;
import com.jpyl.refleciondemo.dao.anno.Table;

/**
 * Created by dg on 2017/3/14.
 */
@Table("user")
public class Filter {
    @Column(name = "id", isId = true)
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "age")
    private int age;
    @Column(name = "city")

    private String city;
    @Column(name = "email")

    private String email;
    @Column(name = "mobile")

    private String mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
