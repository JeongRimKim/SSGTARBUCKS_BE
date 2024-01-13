package com.ssgtarbucks.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ssgtarbucks.domain.UserDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class UserRepositoryTest {

	@Setter(onMethod = @__({ @Autowired }))
	private UserRepository mapper;

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

}