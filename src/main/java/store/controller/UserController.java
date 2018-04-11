package store.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import store.bean.ResponseResult;
import store.bean.User;
import store.service.UserService;
import store.service.exception.PasswordNotMatchException;
import store.service.exception.UserNameAlreadyExistException;
import store.service.exception.UserNotFoundException;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Resource
	UserService userService;
	
/**********************ע��ҳ��*****************/
	
	@RequestMapping("/showRegister.do")//��ת��ע��ҳ��
	public String showRegister(){		
		return "register";
	}
	
	@RequestMapping("/checkUsername.do")//�ж��û����Ƿ���ڣ���Ӧajax������
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		if(userService.checkUsername(username)){
			rr.setState(0);
			rr.setMessage("�û����Ѿ�����");
		}else{
			rr.setState(1);
			rr.setMessage("�û�������ʹ��");
		}
		
		return rr;
	}
	
	@RequestMapping("/checkEmail.do")//�ж������Ƿ����ajax
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		if(userService.checkEmail(email)){
			rr.setState(0);
			rr.setMessage("�����Ѿ�����");
		}else{
			rr.setState(1);
			rr.setMessage("�������ʹ��");
		}		
		return rr;
	}
	@RequestMapping("/checkPhone.do")//�жϵ绰�Ƿ����ajax
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		if(userService.checkPhone(phone)){
			rr.setState(0);
			rr.setMessage("�绰�Ѿ�����");
		}else{
			rr.setState(1);
			rr.setMessage("�绰����ʹ��");
		}
		return rr;
	}
	
	
	/*
	 * �ύע����Ϣ
	 */
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname") String username,
			@RequestParam("upwd") String password,String email,String phone){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		User user=new User(null,username,password,email,phone,null,null,null,null,null,null);
		try{
			userService.register(user);
		}catch(Exception e){
			if(e instanceof UserNameAlreadyExistException){
				rr.setState(0);
				rr.setMessage(e.getMessage());
			}
		}
		return rr;
	}
	
/*****************��½ҳ��*******************/
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/login.do")
	public  ResponseResult<User> login(String username,String password){
		ResponseResult<User> rr=new ResponseResult<User>();
		try{
			User user=userService.login(username, password);
			if(user!=null){
				rr.setState(1);
				rr.setData(user);
			}
		}catch(Exception e){
				rr.setState(0);
				rr.setMessage(e.getMessage());
		}		
		return rr;		
	}
	
}


