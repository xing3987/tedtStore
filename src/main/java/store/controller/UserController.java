package store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import store.bean.ResponseResult;
import store.bean.User;
import store.service.UserService;
import store.service.exception.PasswordNotMatchException;
import store.service.exception.UserNameAlreadyExistException;
import store.service.exception.UserNotFoundException;

@Controller
@RequestMapping("user")
// �û�������ؿ�����login.jsp,register.jsp
public class UserController extends BaseController{

	@Resource
	UserService userService;

	/********************** ע��ҳ�� *****************/

	@RequestMapping("/showRegister.do") // ��ת��ע��ҳ��
	public String showRegister() {
		return "register";
	}

	@RequestMapping("/checkUsername.do") // �ж��û����Ƿ���ڣ���Ӧajax������
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userService.checkUsername(username)) {
			rr.setState(0);
			rr.setMessage("�û����Ѿ�����");
		} else {
			rr.setState(1);
			rr.setMessage("�û�������ʹ��");
		}

		return rr;
	}

	@RequestMapping("/checkEmail.do") // �ж������Ƿ����ajax
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userService.checkEmail(email)) {
			rr.setState(0);
			rr.setMessage("�����Ѿ�����");
		} else {
			rr.setState(1);
			rr.setMessage("�������ʹ��");
		}
		return rr;
	}

	@RequestMapping("/checkPhone.do") // �жϵ绰�Ƿ����ajax
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userService.checkPhone(phone)) {
			rr.setState(0);
			rr.setMessage("�绰�Ѿ�����");
		} else {
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
	public ResponseResult<Void> register(@RequestParam("uname") String username, @RequestParam("upwd") String password,
			String email, String phone) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = new User(null, username, password, email, phone, null, null, null, null, null, null);
		try {
			userService.register(user);
		} catch (Exception e) {
			if (e instanceof UserNameAlreadyExistException) {
				rr.setState(0);
				rr.setMessage(e.getMessage());
			}
		}
		return rr;
	}

	/***************** ��½ҳ�� *******************/
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(@RequestParam("lname") String username, @RequestParam("lwd") String password,
			HttpSession session) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			User user = userService.login(username, password);
			if (user != null) {
				rr.setState(1);
				session.setAttribute("user", user);
			}
		} catch (Exception e) {
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
	}

	@RequestMapping("/lcheckUsername.do") // �ж��û����Ƿ���ڣ���Ӧajax������
	@ResponseBody
	public ResponseResult<Void> lcheckUsername(String username) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userService.checkUsername(username)) {
			rr.setState(1);
			rr.setMessage("�û�������ʹ��");
		} else {
			rr.setState(0);
			rr.setMessage("�û���������");
		}
		return rr;
	}

	/******************** ��ҳindex.jsp ***********************/

	@RequestMapping("/exit.do")
	// ����˳���½�����session
	public String exit(HttpSession session) {
		session.invalidate();
		return "redirect:../main/showIndex.do";
	}

	@RequestMapping("/personal.do")
	@ResponseBody
	public ResponseResult<Void> password(HttpSession session, String oldPwd, String newPwd) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
			try {
				userService.changePassword(this.getId(session), oldPwd, newPwd);
				rr.setState(1);
				rr.setMessage("���޸ĳɹ�");
				
				//���°�session
				User user=(User) session.getAttribute("user");
				user.setPassword(newPwd);
				session.setAttribute("user", user);
				
			} catch (Exception e) {
				rr.setState(0);
				rr.setMessage(e.getMessage());
			}
		return rr;
	}
	
	@RequestMapping("/personInfo.do")
	@ResponseBody
	public ResponseResult<Void> personInfo(HttpSession session, String username,Integer gender,String phone,String email) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
			try {
				userService.update(this.getId(session), username, gender, phone, email);
				
				//���°�session
				User user=(User) session.getAttribute("user");
				user.setUsername(username);
				user.setGender(gender);
				user.setPhone(phone);
				user.setEmail(email);
				session.setAttribute("user", user);
				
				rr.setState(1);
				rr.setMessage("�޸���Ϣ�ɹ�");
			} catch (Exception e) {
				rr.setState(0);
				rr.setMessage(e.getMessage());
			}
		return rr;
	}
	
	@RequestMapping("/upload.do")
	@ResponseBody
	public ResponseResult<Void> upload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		ResponseResult<Void> rr=new ResponseResult<Void>();
		file.transferTo(new File("e:/picture",file.getOriginalFilename()));
		rr.setState(1);
		rr.setMessage("�ϴ��ɹ�");
		return rr;
	}
}
