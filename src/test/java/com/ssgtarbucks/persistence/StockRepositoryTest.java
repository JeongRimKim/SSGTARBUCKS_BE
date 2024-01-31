package com.ssgtarbucks.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ssgtarbucks.domain.MoveItemDTO;
import com.ssgtarbucks.domain.MoveQRItemDTO;
import com.ssgtarbucks.domain.ProductDTO;
import com.ssgtarbucks.domain.StockLocationDTO;
import com.ssgtarbucks.domain.UserDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class StockRepositoryTest {
	
	@Setter(onMethod = @__({ @Autowired }))
	private StockRepository smapper;

	@Disabled
	@Test
	public void test() {
		log.info("\n테스트 파일  test");
	}
	@Disabled
	@Test
	public void location_section() {
		MoveItemDTO dto = new MoveItemDTO();
		dto.setBranch_id("bid001");
		dto.setLocation_alias("케이크 및 빵 냉장고");
		String result = smapper.selectLocationToFindSection(dto);
		log.info("\n section : " + result);
	}
	
	@Test
	@Disabled
	public void selectLocationToFindLocationId() {
		MoveItemDTO dto = new MoveItemDTO();
		dto.setLocation_code("bid001-FR-A1");
		int result = smapper.selectLocationToFindLocationId(dto);
		log.info("\n location_id : " + result);
	}
	
	@Disabled
	@Test
	public void updateStockByItemIdToMove() {
		MoveItemDTO dto = new MoveItemDTO();
		dto.setBranch_id("bid001");
		dto.setLocation_code("bid001-FR-A1");
		List<Integer> list = new ArrayList<>();
		list.add(13792);
		list.add(3670);
//		dto.setItem_list(list);
		int result = smapper.updateStockByItemIdToMove(dto);
		log.info("\n 이동 결과 : " + result);
	}
	
	@Disabled
	@Test
	public void updateStockQByItemQRCodeToMove() {
		MoveQRItemDTO dto = new MoveQRItemDTO();
		dto.setBranch_id("bid001");
		dto.setLocation_qrcode_value("bid001-FR-B3");
		dto.setItem_qrcode_value("2024-06-07@sj_065");
		int result = smapper.updateStockQByItemQRCodeToMove(dto);
		log.info("\n 이동 결과 : " + result);
		
	}
}