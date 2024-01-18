package com.ssgtarbucks.persistence;

import org.apache.ibatis.annotations.Mapper;

import com.ssgtarbucks.domain.StockLocationDTO;
import com.ssgtarbucks.domain.UserDTO;

@Mapper
public interface UserRepository {
	
	int insertUserToJoin(UserDTO dto);
	
	UserDTO selectUserByUserId(String user_id);

	UserDTO selectUserAndBranchToInfo(String string);
	
}
