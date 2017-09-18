package cn.stwms.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.stwms.dao.UserMapper;
import cn.stwms.model.User;
import cn.stwms.utils.BaseUtils;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<?> list(){
		List<?> users=userMapper.getAllUser("s");
		return users;
	}
	
	public User find(int id){
		User user=userMapper.getUserById(id);
		return user;
	}
	
	public int save(User user){
		user.setAddtime(BaseUtils.getTime());
		user.setPassword(BaseUtils.md5(user.getPassword()));
		int result=userMapper.addUser(user);
		return result;
	}
}
