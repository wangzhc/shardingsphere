package com.example.entity.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long userId;
    private String name;
    private Integer age;
    private String address;

    public User() { }

    private User(Builder builder) {
        setUserId(builder.userId);
        setName(builder.name);
        setAge(builder.age);
        setAddress(builder.address);
    }

    public static final class Builder {
        private Long userId;
        private String name;
        private Integer age;
        private String address;

        public Builder() {
        }

        public Builder userId(Long val) {
            userId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

