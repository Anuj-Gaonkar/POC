package com.poc.spring.service.internal;

import com.poc.spring.model.User;

public interface UserInternalService {
    User saveNewUserToDb(User user);

    User findByEmail(String email);
}
