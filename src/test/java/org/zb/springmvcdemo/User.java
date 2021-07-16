package org.zb.springmvcdemo;

import java.util.Optional;

public class User {
    private String name;
    private String city;

    public User(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static void main(String[] args) {
        User user = new User("zhangsan","hangzhou");
        User user2 = null;
        Optional.ofNullable(user)
                .ifPresent(u-> System.out.println(u.getName()));
        Optional.ofNullable(user2)
                .ifPresent(u-> System.out.println(u.getName()));
        User user4 = Optional.ofNullable(user)
                .filter(u -> u.getName() == "zhangsan")
                .orElseGet(() -> {
                    System.out.println("名字不叫lisi");
                    User user3 = new User("lisi", "beijing");
                    return user3;
                });
        System.out.println(user4.getName());

    }
}
