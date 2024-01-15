package com.ssgtarbucks.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssgtarbucks.domain.IncomeDTO;

@Mapper
public interface IncomeRepository {
	//입고내역 조회
	public List<IncomeDTO> selectIncomeListByBranchId(String branch_id);	
	
}