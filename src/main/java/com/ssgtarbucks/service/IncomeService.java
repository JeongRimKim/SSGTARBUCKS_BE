package com.ssgtarbucks.service;

import java.util.List;

import com.ssgtarbucks.domain.IncomeDTO;

public interface IncomeService {
	public int selectIncomeCountByBranchId(String branch_id);
	public List<IncomeDTO> selectIncomeListByBranchId(String branch_id, int curPage);
}
