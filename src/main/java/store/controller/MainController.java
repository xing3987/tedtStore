package store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/main")
public class MainController {

	
/********************首页index.jsp***********************/	
	
	@RequestMapping("/showIndex.do")
	//跳转到首页
	public String showIndex(){
		return "index";
	}
	
	@RequestMapping("/showPersonal.do")
	//点击用户，显示修改密码页面
	public String showPersonal(){
		return "personal_password";
	}
}
