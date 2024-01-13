package com.ssgtarbucks.service;

import com.ssgtarbucks.domain.UserDTO;

public interface UserService {
	
	public UserDTO selectUserByUserId(String user_id);
	
	UserDTO selectUserAndBranchToInfo(String string);

}
