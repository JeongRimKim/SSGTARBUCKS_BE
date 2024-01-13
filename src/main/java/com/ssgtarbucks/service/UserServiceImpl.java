package com.ssgtarbucks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssgtarbucks.domain.UserDTO;
import com.ssgtarbucks.persistence.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO selectUserByUserId(String user_id) {
		return userRepository.selectUserByUserId(user_id);
	}

	@Override
	public UserDTO selectUserAndBranchToInfo(String user_id) {
		return userRepository.selectUserAndBranchToInfo(user_id);
	}

}