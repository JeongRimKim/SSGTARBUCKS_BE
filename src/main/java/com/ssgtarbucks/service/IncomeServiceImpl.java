package com.ssgtarbucks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssgtarbucks.domain.IncomeDTO;
import com.ssgtarbucks.persistence.IncomeRepository;

@Service
public class IncomeServiceImpl implements IncomeService {

	@Autowired
	private IncomeRepository incomeRepository;
	
	@Override
	public List<IncomeDTO> selectIncomeListByBranchId(String branch_id, int curPage) {
		int totalCount = incomeRepository.selectIncomeCountByBranchId(branch_id);
		
		return incomeRepository.selectIncomeListByBranchId(branch_id);
		
	}

	@Override
	public int selectIncomeCountByBranchId(String branch_id) {
		return incomeRepository.selectIncomeCountByBranchId(branch_id);
	}

}
