package com.graphql.Graphql;

import lombok.Data;

@Data
public class InputCourse {
    private Integer id;
    private String name;
    private String category;
    private String teacher;
}
