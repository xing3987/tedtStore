package store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import store.bean.User;

/*
 * 登陆拦截器用于拦截用户信息修改
 */
public class LoginInterceptor implements HandlerInterceptor{

	//页面到导致器方法前拦截
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//1.判断session user是否为null
		//2.如果为null,重定向到登陆界面
		//3.如果不为null,继续执行controller方法
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("user");
		if(obj==null){
			response.sendRedirect(request.getContextPath()+"/user/toLogin.do");
			return false;
		}else{
			return true;
		}
	}

	//响应后到页面前执行
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
		
	}
	

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}


}
