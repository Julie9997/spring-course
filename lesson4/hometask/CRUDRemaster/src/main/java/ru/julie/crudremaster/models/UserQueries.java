package ru.julie.crudremaster.models;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix="sql")
@Data
public class UserQueries {
    private String findAll;
    private String save;
    private String deleteById;
    private String getUserById;
    private String update;
}
