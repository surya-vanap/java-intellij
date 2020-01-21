package com.play.immutable.lombok;

import java.util.Objects;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@Builder(builderClassName = "Builder",buildMethodName = "build")
public class Customer {
    private long id;
    private String name;

    public static class Builder {
        public Customer build() {
            if (id < 0) {
                throw new RuntimeException("Invaid id");
            }
            if (Objects.isNull(name)) {
                throw new RuntimeException("name is null");
            }
            return new Customer(id, name);
        }
    }
}