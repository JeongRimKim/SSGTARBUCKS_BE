package com.ssgtarbucks.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssgtarbucks.domain.MoveQRItemDTO;
import com.ssgtarbucks.domain.OutcomeQRItemDTO;
import com.ssgtarbucks.domain.QRCodeDTO;
import com.ssgtarbucks.domain.SearchDTO;
import com.ssgtarbucks.domain.StockLocationDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class QrCodeRepositoryTest {

	@Setter(onMethod = @__({ @Autowired }))
	private QRCodeRepository mapper;

	@Test
	@Disabled
	public void selectQrcodeIdToCount() {
		int count = mapper.selectQrcodeIdToCount();
		log.info(count);
	}

	@Test
	@Disabled
	public void insertQrcodeToRegisterLocation() {
		QRCodeDTO dto = new QRCodeDTO();
		// \ 한개로 테스트하기!!
		dto.setQrcode_path("C:\\AwesomeBeans\\resources\\qrcode\\product\\bid055-FR-E1.png");
		dto.setQrcode_type("product");
		dto.setQrcode_value("bid055-FR-E1");
		int result = mapper.insertQrcodeToRegisterLocation(dto);
		System.out.println("result : " + result);
	}
	

	@Test
	@Disabled
	public void selectQrcodeIdToFind() {
		int qrcode_id = mapper.selectQrcodeIdToFind("bid088-FR-I1");
		log.info("값 : "+qrcode_id);
	}
	@Disabled
	@Test
	public void updateLocationToAddQrcodeId() {
		StockLocationDTO dto = new StockLocationDTO();
		dto.setLocation_code("bid088-BA-H5");
		dto.setQrcode_id(20022);
		int result = mapper.updateLocationToAddQrcodeId(dto);
		System.out.println("result : " + result);
	}
	@Disabled
	@Test
	public void selectItemAndLocationToSearchbyQRcode() {
		QRCodeDTO dto = new QRCodeDTO();
		dto.setBranch_id("bid001");
		dto.setQrcode_value("bid001-BA-A2");
		List<SearchDTO> searchDtoList = mapper.selectItemAndLocationToSearchbyQRcode(dto);
		System.out.println("검색결과 : " + searchDtoList);
	}
	
	@Disabled
	@Test
	public void selectQRToFindLocationIDByLocQRValue() {
		MoveQRItemDTO dto = new MoveQRItemDTO();
		dto.setBranch_id("bid001");
		dto.setLocation_qrcode_value("bid001-FR-A5");
		int location_id = mapper.selectQRToFindLocationIDByLocQRValue(dto);
		System.out.println("검색결과 : " + location_id);
	}
	@Disabled
	@Test
	public void selectQRToFindItemIDByItemQRValue() {
		MoveQRItemDTO dto = new MoveQRItemDTO();
		dto.setItem_qrcode_value("2024-06-07@sj_065");
		int item_id = mapper.selectQRToFindItemIDByItemQRValue(dto);
		System.out.println("검색결과 : " + item_id);
	}
	
	@Disabled
	@Test
	public void updateStockToMoveQR() {
		MoveQRItemDTO dto = new MoveQRItemDTO();
		dto.setBranch_id("bid001");
		dto.setLocation_id(1);
		dto.setItem_id(13792);
		int count = mapper.updateStockToMoveQR(dto);
		System.out.println("수정결과(1) : " + count);
	}
	
	@Disabled
	@Test
	public void selectItemIdForOutcomeItemByItemQR() {
		OutcomeQRItemDTO dto = new OutcomeQRItemDTO();
		dto.setQrcode_value("2024-04-05@phj_061");
		dto.setBranch_id("bid001");
		int item_id = mapper.selectItemIdForOutcomeItemByItemQR(dto);
		log.info("item_id : "+ item_id);
	}
	
	@Disabled
	@Test
	public void updateStockCountForOutcomeItemByitemId() {
		OutcomeQRItemDTO dto = new OutcomeQRItemDTO();
		dto.setBranch_id("bid001");
		dto.setItem_id(5910);
		int result = mapper.updateStockCountForOutcomeItemByitemId(dto);
		log.info("result : "+ result);
	}
	
	@Disabled
	@Test
	public void selectOutcomeIdForFindOutcomeCode() {
		long outcome_code = mapper.selectOutcomeIdForFindOutcomeCode();
		log.info("outcome_code : "+ outcome_code);
	}
	
	@Disabled
	@Test
	public void insertOutcomeToUseItem() {
		OutcomeQRItemDTO dto = new OutcomeQRItemDTO();
		dto.setOutcome_code(202000000001L);
		dto.setBranch_id("bid001");
		int result = mapper.insertOutcomeToUseItem(dto);
		log.info("result : "+ result);
	}
	
	

	@Disabled
	@Test
	public void selectOutcomeListForFindOutcomeId() {
		int outcome_id = mapper.selectOutcomeListForFindOutcomeId();
		log.info("outcome_id : "+ outcome_id);
	}
	
	@Disabled
	@Test
	public void insertOutcomeListToUseItem() {
		OutcomeQRItemDTO dto = new OutcomeQRItemDTO();
		dto.setOutcome_id( 40 );
		dto.setItem_id(5910);
		int result = mapper.insertOutcomeListToUseItem(dto);
		log.info("result : "+ result);
	}
	
	@Disabled
		@Test
	public void selectDiscardIdForFindDiscardCode() {
		long discard_code = mapper.selectDiscardIdForFindDiscardCode();
		log.info("discard_code : "+ discard_code);
	}
	
	@Test
	@Disabled
	public void insertDiscardToUseItem() {
		OutcomeQRItemDTO dto = new OutcomeQRItemDTO();
		dto.setDiscard_code(202312000001L);
		dto.setBranch_id("bid001");
		int result = mapper.insertDiscardToUseItem(dto);
		log.info("result : "+ result);
	}
	
	
	

}