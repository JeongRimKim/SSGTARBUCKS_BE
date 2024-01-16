package com.ssgtarbucks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssgtarbucks.domain.SaleDTO;
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


	@Override
	public List<SaleDTO> selectSaleListByBranchId(String branch_id) {
		return stockRepository.selectSaleListByBranchId(branch_id);
	}


	@Transactional
	@Override
	public void updateSaleTransaction(String branch_id, List<SaleDTO> saleList) {
		 try{
			 
			 stockRepository.updateSaleList(branch_id);
			 
			 for(int i = 0; i<saleList.size(); i++) {
				 stockRepository.updateStockQuantityByItemId(saleList.get(i).getSale_list_quantity(), saleList.get(i).getItem_id());
				 stockRepository.updateItemStatus(saleList.get(i).getItem_id());
			 }
			 
	      }catch (Exception e){
	   }		
	}

}
