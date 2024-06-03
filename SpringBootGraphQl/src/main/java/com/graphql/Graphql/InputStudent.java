package com.graphql.Graphql;

import lombok.Data;

@Data
public class InputStudent {
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private String courseId;
}
