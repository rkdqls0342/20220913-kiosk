package edu.sungil.foods.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.sungil.foods.web.domain.dto.UserInfo;
import edu.sungil.foods.web.service.DefaultService;

/**
 * @author koobk
 */
@Controller
public class DefaultController {
	@Autowired
	DefaultService defaultService;

	@RequestMapping(value="/userInfo",method=RequestMethod.GET)
	public void getUserInfo() {
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserInfo> getUserInfo(@RequestParam(value = "userNo", required = true)Long userNo) {
		return new ResponseEntity<UserInfo>(defaultService.getUserInfo(userNo), HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/add", method = RequestMethod.POST)
	@ResponseBody
	public void addUserInfo(@RequestParam(value = "userNo", required = true)Long userNo,
			@RequestParam(value = "userNm", required = true)String userNm,
			@RequestParam(value = "userBirthDt", required = true)String userBirthDt) {
		
		UserInfo userInfo =new UserInfo();
		userInfo.setUserNo(userNo);
		userInfo.setUserNm(userNm);
		userInfo.setUserBirthDt(userBirthDt);
		
		defaultService.addUserInfo(userInfo);
	}
	
	
	
	
}
