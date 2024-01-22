package com.ssgtarbucks.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ssgtarbucks.domain.ProductDTO;
import com.ssgtarbucks.domain.StockLocationDTO;
import com.ssgtarbucks.domain.UserDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class BranchRepositoryTest {

	@Setter(onMethod = @__({ @Autowired }))
	private UserRepository mapper;
	
	@Setter(onMethod = @__({ @Autowired }))
	private BranchRepository bmapper;

	@Disabled
	@Test
	public void test() {
		log.info("================================================테스트 파일  test");
	}

	@Disabled
	@Test
	public void selectUserByUserId() throws Exception {
		UserDTO userDTO = mapper.selectUserByUserId("m001");
		log.info("====================================================\\n" + userDTO);
	}
	
	@Disabled
	@Test
	public void selectUserAndBranchToInfo() throws Exception {
		UserDTO userDTO = mapper.selectUserAndBranchToInfo("a001");
		log.info("====================================================\\n" + userDTO);
	}
	
	@Disabled
	@Test
	public void insertUserToJoin() throws Exception {
		UserDTO dto = new UserDTO();
		dto.setUser_id("m060");
		String samplePwd = new BCryptPasswordEncoder().encode("m060");
		dto.setUser_pw(samplePwd);
		dto.setUser_name("김태형");
		dto.setUser_type("manager");
		dto.setUser_email("hunghung60@google.com");
		dto.setUser_phone("010-5555-4444");

		assertEquals(1, mapper.insertUserToJoin(dto));
	}
	
	@Disabled
	@Test
	public void updateBCryptPW() throws Exception {
		//이클립스 SHA256 -> 스프링시큐리티 BCryptPasswordEncoder
		for (int i = 1; i < 5; i++) {
			String originalPassword = String.format("a%03d", i);
			String encodingPassword = new BCryptPasswordEncoder().encode(originalPassword);
			log.info(i + "번째===================================================\n");
			log.info("originalPassword :" + originalPassword + "\n");
			log.info("encodingPassword :" + encodingPassword + "\n");
		}
		for (int i = 1; i < 57; i++) {
			String originalPassword = String.format("m%03d", i);
			String encodingPassword = new BCryptPasswordEncoder().encode(originalPassword);
			log.info(i + "번째===================================================\n");
			log.info("originalPassword :" + originalPassword + "\n");
			log.info("encodingPassword :" + encodingPassword + "\n");
		}
		
	}
	@Disabled
	@Test
	public void selectLocationSectionTofindMaxValue() {
		StockLocationDTO dto = new StockLocationDTO();
		dto.setBranch_id("bid087");
		dto.setLocation_section("E");
		int max_value = bmapper.selectLocationSectionTofindMaxValue(dto);
		log.info("결과 >>>>>> " + max_value);
	}
	
	@Disabled
	@Test
	public void updateLocationCode() {
		StockLocationDTO dto = new StockLocationDTO();
		dto.setLocation_section("E2");
		dto.setLocation_code("RE-E2-03-02");
		dto.setBranch_id("bid087");
		int result = bmapper.updateLocationCode(dto);
		log.info("결과 >>>>>>"+ result);
	}
	
	@Disabled
	@Test
	public void insertStockLocation() {
		StockLocationDTO dto = new StockLocationDTO();
		dto.setLocation_area("FR");
		dto.setLocation_section("E4");
		dto.setLocation_section_name("상부장");
		dto.setLocation_area("자동문옆상부장");
		dto.setBranch_id("bid087");
		int result = bmapper.insertStockLocation(dto);
		log.info("결과 >>>>>>"+ result);
	}
	
	@Test
	@Disabled
	public void joinProductFortotalProductQuantity() {
		List<ProductDTO> pList = bmapper.joinProductFortotalProductQuantity("bid001");
		log.info("결과>>>>"+ pList);
	}
	
	

	@Test
	public void selectLocaitonToShowList() {
		List<StockLocationDTO> sList = bmapper.selectLocaitonToShow("bid001");
		log.info("결과 > "+sList);
		
	}
}