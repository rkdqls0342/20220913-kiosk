package edu.sungil.foods.web.domain.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MenuInfo {

	private String MENU_NM;
	private long MENU_PRICE;
	private String MENU_DESC;
	private long MENU_STOCK_QTY;
	private String MENU_DISP_YN;
	private MultipartFile MENU_IMG_NM;
	private String fileNm;
	
}
