package com.ssgtarbucks.service;

import java.util.List;

import com.ssgtarbucks.domain.IncomeDTO;
import com.ssgtarbucks.domain.TotalDTO;

public interface BranchService {
	public List<TotalDTO> selectSearchBySearchWord(String searchWord);
	public List<TotalDTO> selectExpirationDateList(String branch_id, String curDate);
}
