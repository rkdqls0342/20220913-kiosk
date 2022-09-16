package edu.sungil.foods.web.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sungil.foods.web.domain.AdminMapper;
import edu.sungil.foods.web.domain.dto.MenuInfo;

@Service
public class AdminService {
	
	private final Path imgPath = Paths.get("src/main/resources/static/media");
	
	@Autowired
	AdminMapper adminMapper;
	
	public void addMenu(MenuInfo menuInfo) {
		
		String fileNm = "";
		if(!(menuInfo.getMENU_IMG_NM() == null)) {
			fileNm = String.valueOf(System.currentTimeMillis()) + "_" + menuInfo.getMENU_IMG_NM().getOriginalFilename();
			
			try {
				Files.copy(menuInfo.getMENU_IMG_NM().getInputStream(),imgPath.resolve(fileNm));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		menuInfo.setFileNm(fileNm);
		adminMapper.insertMenu(menuInfo);
	}
	
	
}
