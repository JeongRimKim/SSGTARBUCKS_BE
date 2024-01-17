package com.ssgtarbucks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssgtarbucks.domain.IncomeDTO;
import com.ssgtarbucks.domain.TotalDTO;
import com.ssgtarbucks.domain.UserDTO;
import com.ssgtarbucks.persistence.BranchRepository;
import com.ssgtarbucks.persistence.IncomeRepository;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepository;

	@Override
	public List<TotalDTO> selectSearchBySearchWord(String searchWord) {
		return branchRepository.selectSearchBySearchWord(searchWord);
	}

	@Override
	public List<TotalDTO> selectExpirationDateList(String branch_id, String curDate) {
		return branchRepository.selectExpirationDateList(branch_id, curDate);
	}

	@Override
	public UserDTO selectUserAndBranchInfo(String branch_id) {
		return branchRepository.selectUserAndBranchInfo(branch_id);
	}
	


}
