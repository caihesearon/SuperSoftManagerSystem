package hecai.service.impl;

import java.util.List;


import hecai.entity.User;
import hecai.mapper.UserMapper;
import hecai.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}

	@Override
	public User isExist(User user) {
		return userMapper.isExist(user);
	}

}
