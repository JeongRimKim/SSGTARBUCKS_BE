package com.ssgtarbucks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssgtarbucks.domain.MoveItemDTO;
import com.ssgtarbucks.domain.SaleDTO;
import com.ssgtarbucks.domain.StockDTO;
import com.ssgtarbucks.service.StockService;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@GetMapping("/list")
	public ResponseEntity<List<StockDTO>> stockList (@RequestParam String branch_id) { 
		System.out.println("branch_id>>>>>>>>>>>>" + branch_id);
		
		List<StockDTO> stockList = stockService.selectStorageByBranchId(branch_id);
		System.out.println("StockController - /stock/list/stockList(get) >>> stockList :" + stockList);

        return ResponseEntity.ok(stockList);
    }
	
	@PutMapping("/quantity")
	public ResponseEntity<List<StockDTO>> changeQuantity (@RequestParam String branch_id, @RequestBody StockDTO stockDTO ) { 
		System.out.println("branch_id>>>>>>>>>>>>" + branch_id);
		System.out.println(stockDTO.getItem_id());
		System.out.println(stockDTO.getStock_quantity());

		int result = stockService.updateStockQuantityByItemId(stockDTO.getStock_quantity(), stockDTO.getItem_id());
		if(result > 0) {
			System.out.println("StockController - /stock/list/quantity(put) >>> 수량정정성공");
		}
				
		List<StockDTO> stockList = stockService.selectStorageByBranchId(branch_id);
		System.out.println("StockController - /stock/list/quantity(put) >>> stockList :" + stockList);

        return ResponseEntity.ok(null);
    }
	
	@GetMapping("/sale/list")
	public ResponseEntity<List<SaleDTO>> saleList (@RequestParam String branch_id) { 
		System.out.println("branch_id>>>>>>>>>>>>" + branch_id);
		
		List<SaleDTO> saleList = stockService.selectSaleListByBranchId(branch_id);
		System.out.println("StockController - /stock/sale/list/stockList(get) >>> stockList :" + saleList);

        return ResponseEntity.ok(saleList);
    }
	
	@PutMapping("/sale/product")
	public ResponseEntity<List<SaleDTO>> changeQuantity (@RequestParam String branch_id) { 
		System.out.println("branch_id>>>>>>>>>>>>" + branch_id);

		
		List<SaleDTO> saleList = stockService.selectSaleListByBranchId(branch_id);
		
		stockService.updateSaleTransaction(branch_id, saleList);

		System.out.println("StockController - /stock/list/quantity(put) >>> stockList :" + saleList);

        return ResponseEntity.ok(null);
    }

	@PutMapping("/checked/inspection")
	public ResponseEntity<List<SaleDTO>> inspectionList (@RequestParam String branch_id) { 
		System.out.println("branch_id>>>>>>>>>>>>" + branch_id);

        return ResponseEntity.ok(null);
    }

	
}
