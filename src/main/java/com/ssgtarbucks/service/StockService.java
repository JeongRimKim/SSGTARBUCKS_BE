package com.ssgtarbucks.service;

import java.util.List;

import com.ssgtarbucks.domain.MoveItemDTO;
import com.ssgtarbucks.domain.SaleDTO;
import com.ssgtarbucks.domain.StockDTO;


public interface StockService {
		
	public List<StockDTO> selectStorageByBranchId(String branch_id);
	
	public int updateStockQuantityByItemId(int stock_quantity, int item_id);
	
	public List<SaleDTO> selectSaleListByBranchId(String branch_id);
	
	public void updateSaleTransaction(String branch_id, List<SaleDTO> saleList);

	int updateStockByItemIdToMove(MoveItemDTO moveItemDTO);
	
}
