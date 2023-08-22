package com.bainazarov.springBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private List<Post> posts;
}
