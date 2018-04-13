package store.controller;

import javax.servlet.http.HttpSession;

import store.bean.User;

public class BaseController {
	public Integer getId(HttpSession session){
		User user=(User) session.getAttribute("user");
		if(user!=null){
			return user.getId();
		}else{
			return null;
		}
	}
}
