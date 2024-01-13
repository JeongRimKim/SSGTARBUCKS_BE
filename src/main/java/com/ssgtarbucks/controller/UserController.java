package com.ssgtarbucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssgtarbucks.domain.TokenDTO;
import com.ssgtarbucks.domain.UserDTO;
import com.ssgtarbucks.jwt.JwtUtil;
import com.ssgtarbucks.service.UserService;


@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	AuthenticationManagerBuilder authenticationManagerBuilder;

	@Autowired
	JwtUtil jwtUtil;

	@Value("${jwt.name}")
	String tokenKey;

	@Autowired
	private UserService userService;

	@PostMapping("/user/login")
	public ResponseEntity<TokenDTO> login(@RequestBody UserDTO userDTO) {
		System.out.println("UserController - /user/login(POST) >>> userDTO : " + userDTO);

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userDTO.getUser_id(), userDTO.getUser_pw());
		
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtUtil.generateToken(userDTO.getUser_id());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(tokenKey, "Bearer+" + jwt);
		
		
		TokenDTO tokenDTO = new TokenDTO();
		userDTO = userService.selectUserAndBranchToInfo(userDTO.getUser_id());
		tokenDTO.setUser_id(userDTO.getUser_id());
		tokenDTO.setUser_type(userDTO.getUser_type());
		tokenDTO.setBranch_id(userDTO.getBranch_id());
		tokenDTO.setBranch_name(userDTO.getBranch_name());
		tokenDTO.setJwtauthtoken("Bearer+" + jwt);
		
		
		System.out.println("UserController - /user/login(POST) >>> tokenDTO : " + tokenDTO);
		return new ResponseEntity<>(tokenDTO, httpHeaders, HttpStatus.OK);
	}
	
	@PostMapping("/user/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody UserDTO userDTO) { // 회원 가입
		System.out.println("UserController - /user/signup(POST) >>> userDTO : " + userDTO);
    		// PW 테스트용 생성(feature테스트)
           // userService.signup(userDTO);
  
        return ResponseEntity.ok(userDTO);
    }
}