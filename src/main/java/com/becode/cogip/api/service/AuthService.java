package com.becode.cogip.api.service;

import com.becode.cogip.api.model.User;

public interface AuthService {
    User login(String username, String password);
    User register(String username, String password);
}
