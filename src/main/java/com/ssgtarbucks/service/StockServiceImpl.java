package com.ssgtarbucks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssgtarbucks.domain.StockDTO;
import com.ssgtarbucks.persistence.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;


	@Override
	public List<StockDTO> selectStorageByBranchId(String branch_id) {
		return stockRepository.selectStorageByBranchId(branch_id);
	}


	@Override
	public int updateStockQuantityByItemId(int stock_quantity, int item_id) {
		return stockRepository.updateStockQuantityByItemId(stock_quantity, item_id);
	}
	
	

}
