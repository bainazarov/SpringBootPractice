package com.bainazarov.springBoot.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String username;
    private LocalDate birthday;
}
