package hecai.mapper;

import java.util.List;

import hecai.entity.User;

public interface UserMapper {

	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * 根据用户名和密码查询用户是否存在
	 * @param user
	 * @return
	 */
	public User isExist(User user);
}
