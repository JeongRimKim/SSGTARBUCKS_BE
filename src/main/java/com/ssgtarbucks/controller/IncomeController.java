package com.ssgtarbucks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssgtarbucks.domain.IncomeDTO;
import com.ssgtarbucks.domain.UserDTO;
import com.ssgtarbucks.service.IncomeService;

@RestController
@RequestMapping("/api/v1/income")
public class IncomeController {
	
	@Autowired
	private IncomeService incomeService;
	
	@GetMapping("/list")
	public ResponseEntity<List<IncomeDTO>> incomeList (@RequestParam String branch_id) { //입고목록
		//@RequestParam(required = false, defaultValue = "1") int curPage
		System.out.println("branch_id>>>>>>>>>>>>" + branch_id);
		
		int curPage = 1;
		
		List<IncomeDTO> incomeList = incomeService.selectIncomeListByBranchId(branch_id,curPage);
		System.out.println("IncomeController - /income/list/incomeList(get) >>> incomeList :" + incomeList);

        return ResponseEntity.ok(incomeList);
    }

}
