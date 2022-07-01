package com.superpoet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.superpoet.domain.User;

import org.apache.ibatis.annotations.Mapper;

/**
* @author Superpoet
* @description 针对表【user(用户信息)】的数据库操作Mapper
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




