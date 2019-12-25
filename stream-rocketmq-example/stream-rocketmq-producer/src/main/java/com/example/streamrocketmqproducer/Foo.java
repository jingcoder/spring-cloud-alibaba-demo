package com.example.streamrocketmqproducer;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/11 11:15
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

public class Foo {

    private int id;

    private String bar;

    public Foo() {
    }

    public Foo(int id, String bar) {
        this.id = id;
        this.bar = bar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    @Override
    public String toString() {
        return "Foo{" + "id=" + id + ", bar='" + bar + '\'' + '}';
    }

}
