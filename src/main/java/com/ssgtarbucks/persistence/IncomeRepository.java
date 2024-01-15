package com.ssgtarbucks.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssgtarbucks.domain.IncomeDTO;

@Mapper
public interface IncomeRepository {
	//지점별 목록 개수 구하기 (페이지네이션용)
	public int selectIncomeCountByBranchId(String branch_id);
	//입고내역 조회
	public List<IncomeDTO> selectIncomeListByBranchId(String branch_id);
	
	
}