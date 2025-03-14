package com.learn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.learn.vo.UserVO;

@Mapper
public interface UserMapper {
	List<UserVO> getAllUsers();

	int createUser(UserVO userVO);

	UserVO getUserById(@Param("id") Long id);

	int updateUser(UserVO userVO);
	
	int deleteUser(@Param("id") Long id);
}
