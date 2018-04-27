package store.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/test")
@Controller
public class TestUploadController {

	@RequestMapping("/showUpload.do")
	public String showUpload(){
		return "upload";
	}
	
	@RequestMapping("/doUpload.do")
	//实现上传文件的功能
	public String doUpload(MultipartFile file) throws IllegalStateException, IOException{
		file.transferTo(new File("e:/picture",file.getOriginalFilename()));
		return "redirect:../main/showIndex.do";
	}
}
