package com.ssgtarbucks.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	
	

}