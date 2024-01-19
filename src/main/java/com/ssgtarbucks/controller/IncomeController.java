package com.ssgtarbucks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssgtarbucks.domain.IncomeDTO;
import com.ssgtarbucks.domain.ItemDTO;
import com.ssgtarbucks.domain.ProductDTO;
import com.ssgtarbucks.domain.UserDTO;
import com.ssgtarbucks.service.IncomeService;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

@RestController
@RequestMapping("/api/v1/income")
public class IncomeController {
	
	@Autowired
	private IncomeService incomeService;
	
	@GetMapping("/list")
	public ResponseEntity<List<IncomeDTO>> incomeList (@RequestParam String branch_id) { //입고목록
		System.out.println("branch_id>>>>>>>>>>>>" + branch_id);
				
		List<IncomeDTO> incomeList = incomeService.selectIncomeListByBranchId(branch_id);
		System.out.println("IncomeController - /income/list/incomeList(get) >>> incomeList :" + incomeList);

        return ResponseEntity.ok(incomeList);
    }
	
	@GetMapping("/list/inspection")
	public ResponseEntity<List<IncomeDTO>> inspection(@RequestParam String incomeId) {

		System.out.println("QRCodeController - /inspection/income(GET) >>>"+incomeId);
		
		List<IncomeDTO> incomeList = incomeService.selectIncomeListByIncomeId(incomeId);
		
		return ResponseEntity.ok(incomeList);
	} 
	

	@GetMapping("/inspection/product")
	public String inspectionProduct(String scanResult, String itemCode) {
		String returnValue = "실패";
		String [] result = scanResult.split("@");
		
		System.out.println("QRCodeController - /inspection/product(GET) >>>"+result[1]);
		System.out.println("QRCodeController - /inspection/product(GET) >>>"+itemCode);

		ItemDTO scanItemDTO = incomeService.selectItemAllByItemCode(result[1]);
		ItemDTO originItemDTO = incomeService.selectItemAllByItemCode(itemCode);
		
		System.out.println(scanItemDTO+"<-scan///////////origin->"+originItemDTO);

		if (originItemDTO != null) {
			System.out.println(scanItemDTO.getItem_code()+"<-scan///////////origin->"+originItemDTO.getItem_code());
			
			if(scanItemDTO.getItem_code().equals( originItemDTO.getItem_code() )) {

				int updateResult = incomeService.updateIncomeListResult(originItemDTO.getItem_id());
				if(updateResult>=1) returnValue = "성공";
			}
		}
		
		return returnValue;
	}
	
	@GetMapping("/inspection/complete")
	public String inspectionComplete(@RequestParam String incomeId, @RequestParam String branch_id) {
		List<IncomeDTO> incomeList = incomeService.selectIncomeListByIncomeId(incomeId);
		
		for(int i=0; i<incomeList.size(); i++) {
			IncomeDTO incomeDTO = incomeList.get(i);
			//승인된 재고 중
			if(incomeDTO.getIncome_list_result().equals("승인")) {
				String[] item_code = incomeDTO.getItem_code().split("_");
				//int result1 = incomeService.selectSameItemCount(item_code[1],incomeDTO.getItem_exp() );
				int result2 = incomeService.selectSameProductCount(item_code[1]);
				
				//같은 상품번호를 가진 재고가 있음
				if(result2>0) {
					int updateStockResult = incomeService.updateIncomeListResult(incomeDTO.getItem_id());
					
				//같은 상품번호를 가진 재고가 없음
				}else {
					int insertStockResult = incomeService.insertStockItem(branch_id, incomeDTO.getItem_id());
				}
				int updateItemStatus = incomeService.updateItemStatus(incomeDTO.getItem_id());

			}
			
		}
		
		int result =  incomeService.updateIncomeStatus(incomeId);
				
		return null;
		
	}
	
}
