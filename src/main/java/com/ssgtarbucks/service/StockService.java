package com.ssgtarbucks.service;

import java.util.List;

import com.ssgtarbucks.domain.StockDTO;


public interface StockService {
		
	public List<StockDTO> selectStorageByBranchId(String branch_id);
	
	public int updateStockQuantityByItemId(int stock_quantity, int item_id);

}
