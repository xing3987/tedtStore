package store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import store.bean.ResponseResult;
@Controller
@RequestMapping("/main")
public class MainController {

	
/********************��ҳindex.jsp***********************/	
	
	@RequestMapping("/showIndex.do")
	//��ת����ҳ
	public String showIndex(){
		return "index";
	}
	
	@RequestMapping("/showPersonal.do")
	//����û�����ʾ�޸�����ҳ��
	public String showPersonal(){
		return "personal_password";
	}
	
	@RequestMapping("/showPersonInfo.do")
	//��ת����ҳ
	public String showPersonInfo(){
		return "personInfo";
	}
	
}
