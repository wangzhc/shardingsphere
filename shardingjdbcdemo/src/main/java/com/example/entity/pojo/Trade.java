package com.example.entity.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Trade {
    private Long id;
    private Long userId;
    private Integer score;
    private Date createTime;

    public Trade() {}

    private Trade(Builder builder) {
        setId(builder.id);
        setUserId(builder.userId);
        setScore(builder.score);
        setCreateTime(builder.createTime);
    }


    public static final class Builder {
        private Long id;
        private Long userId;
        private Integer score;
        private Date createTime;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder userId(Long val) {
            userId = val;
            return this;
        }

        public Builder score(Integer val) {
            score = val;
            return this;
        }

        public Builder createTime(Date val) {
            createTime = val;
            return this;
        }

        public Trade build() {
            return new Trade(this);
        }
    }
}
