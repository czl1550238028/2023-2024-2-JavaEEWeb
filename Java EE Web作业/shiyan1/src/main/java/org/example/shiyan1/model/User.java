package org.example.shiyan1.model;

public class User {
    String name;
    int sex;
    String[] mycolor;

    public User(String name, int sex, String[] mycolor) {
        this.name = name;
        this.sex = sex;
        this.mycolor = mycolor;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String[] getMycolor() {
        return mycolor;
    }

    public void setMycolor(String[] mycolor) {
        this.mycolor = mycolor;
    }
}
