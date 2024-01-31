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
		dto.setUser_name("양지용");
		dto.setUser_type("manager");
		dto.setUser_email("seungwon123@google.com");
		dto.setUser_phone("010-9875-3214");
		System.out.println(">>>>>>>"+samplePwd);
		assertEquals(1, mapper.insertUserToJoin(dto));
	}
	
	@Test
	@Disabled
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
	
	@Test
	public void updateBCryptPWSample() throws Exception {
		//이클립스 SHA256 -> 스프링시큐리티 BCryptPasswordEncoder
			String originalPassword = String.format("20k30011");
			String encodingPassword = new BCryptPasswordEncoder().encode(originalPassword);
			log.info("\noriginalPassword :" + originalPassword + "\n");
			log.info("\nencodingPassword :" + encodingPassword + "\n");
			log.info("===================================================\n");
		
		
	}

}