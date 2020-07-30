package com.aust.ssml.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegisterMapper {
    void insertUser(@Param("username") String username,
                     @Param("userpwd") String userpwd,
                     @Param("email") String email,
                    @Param("phone") String phone);

    String selectUser(@Param("username") String username);
}
