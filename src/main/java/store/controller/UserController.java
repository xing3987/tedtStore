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
// 用户管理相关控制器login.jsp,register.jsp
public class UserController extends BaseController{

	@Resource
	UserService userService;

	/********************** 注册页面 *****************/

	@RequestMapping("/showRegister.do") // 跳转到注册页面
	public String showRegister() {
		return "register";
	}

	@RequestMapping("/checkUsername.do") // 判断用户名是否存在，响应ajax的请求
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userService.checkUsername(username)) {
			rr.setState(0);
			rr.setMessage("用户名已经存在");
		} else {
			rr.setState(1);
			rr.setMessage("用户名可以使用");
		}

		return rr;
	}

	@RequestMapping("/checkEmail.do") // 判断邮箱是否存在ajax
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userService.checkEmail(email)) {
			rr.setState(0);
			rr.setMessage("邮箱已经存在");
		} else {
			rr.setState(1);
			rr.setMessage("邮箱可以使用");
		}
		return rr;
	}

	@RequestMapping("/checkPhone.do") // 判断电话是否存在ajax
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userService.checkPhone(phone)) {
			rr.setState(0);
			rr.setMessage("电话已经存在");
		} else {
			rr.setState(1);
			rr.setMessage("电话可以使用");
		}
		return rr;
	}

	/*
	 * 提交注册信息
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

	/***************** 登陆页面 *******************/
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

	@RequestMapping("/lcheckUsername.do") // 判断用户名是否存在，响应ajax的请求
	@ResponseBody
	public ResponseResult<Void> lcheckUsername(String username) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userService.checkUsername(username)) {
			rr.setState(1);
			rr.setMessage("用户名可以使用");
		} else {
			rr.setState(0);
			rr.setMessage("用户名不存在");
		}
		return rr;
	}

	/******************** 首页index.jsp ***********************/

	@RequestMapping("/exit.do")
	// 点击退出登陆，清除session
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
				rr.setMessage("密修改成功");
				
				//重新绑定session
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
				
				//重新绑定session
				User user=(User) session.getAttribute("user");
				user.setUsername(username);
				user.setGender(gender);
				user.setPhone(phone);
				user.setEmail(email);
				session.setAttribute("user", user);
				
				rr.setState(1);
				rr.setMessage("修改信息成功");
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
		rr.setMessage("上传成功");
		return rr;
	}
}
