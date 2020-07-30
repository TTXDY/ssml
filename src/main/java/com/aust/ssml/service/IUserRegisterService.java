package com.aust.ssml.service;

import org.springframework.stereotype.Service;


@Service
public interface IUserRegisterService {

    void placeUser(String username, String userpwd, String email, String phone);
    String selectUser(String username);
}