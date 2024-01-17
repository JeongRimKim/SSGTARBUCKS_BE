package com.ssgtarbucks.persistence;

import org.apache.ibatis.annotations.Mapper;

import com.ssgtarbucks.domain.UserDTO;

@Mapper
public interface StockLocationRepository {
	
	int insertUserToJoin(UserDTO dto);
	
	UserDTO selectUserByUserId(String user_id);

	UserDTO selectUserAndBranchToInfo(String string);
	
}