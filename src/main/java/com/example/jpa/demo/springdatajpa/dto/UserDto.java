package com.example.jpa.demo.springdatajpa.dto;

import lombok.Data;
@Data
public class UserDto {
    private Long id;
    private String username;
    private String teamName;
    public UserDto(Long id, String username, String teamName) {
    this.id = id;
    this.username = username;
    this.teamName = teamName;
 }
}