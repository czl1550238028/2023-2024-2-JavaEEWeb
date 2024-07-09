package com.example.ch6_1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class MyUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//主键
    /**使用@Column注解，可以配置列相关属性（列名，长度等），
     * 可以省略，默认为属性名小写，如果属性名是词组，将在中间加上“_”。
     */
    private String uname;
    private String usex;
    private int age;
    //省略get和set方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
