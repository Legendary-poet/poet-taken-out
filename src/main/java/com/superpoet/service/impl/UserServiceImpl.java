package com.superpoet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.superpoet.domain.User;
import com.superpoet.mapper.UserMapper;
import com.superpoet.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
