package store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import store.bean.User;

/*
 * ��½���������������û���Ϣ�޸�
 */
public class LoginInterceptor implements HandlerInterceptor{

	//ҳ�浽����������ǰ����
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//1.�ж�session user�Ƿ�Ϊnull
		//2.���Ϊnull,�ض��򵽵�½����
		//3.�����Ϊnull,����ִ��controller����
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("user");
		if(obj==null){
			response.sendRedirect(request.getContextPath()+"/user/toLogin.do");
			return false;
		}else{
			return true;
		}
	}

	//��Ӧ��ҳ��ǰִ��
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
		
	}
	

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}


}
