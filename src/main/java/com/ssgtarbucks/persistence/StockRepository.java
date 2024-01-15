package com.ssgtarbucks.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssgtarbucks.domain.StockDTO;

@Mapper
public interface StockRepository {
		
	public List<StockDTO> selectStorageByBranchId(String branch_id);
	
	public int updateStockQuantityByItemId(int stock_quantity, int item_id);
}