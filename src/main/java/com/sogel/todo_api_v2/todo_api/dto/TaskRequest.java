package com.sogel.todo_api_v2.todo_api.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {

    private Long id;
    private String title;
    private String description;
    private String status;

}
