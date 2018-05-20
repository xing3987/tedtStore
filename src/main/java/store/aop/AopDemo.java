package store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AopDemo {
	
	//触发控件前发生
	@Before("within(store.controller.UserController)")//第一种方式within(类名)
	public void  test1(){
		System.out.println("执行方法之前");
	}
		
	//不管发不发生异常都会执行
	@After("bean(userController)")
	public void  test2(){
		System.out.println("after执行方法之后");
	}
	
	//不发生异常会执行
	@AfterReturning("bean(userController)")
	public void  test3(){
		System.out.println("afterReturning执行方法无异常之后");
	}
	
	//发生异常执行
	@AfterThrowing("bean(userController)")
	public void  test4(){
		System.out.println("执行方法有异常时触发");
	}
	
	//在业务前后都会发生
	@Around("bean(userController)")
	public Object  test5(ProceedingJoinPoint pd) throws Throwable{
		System.out.println("执行方法之前，执行环绕通知");
		Long lbefore=System.currentTimeMillis();
		//执行业务逻辑方法,有结果时返回对象
		Object obj=pd.proceed();
		Long lafter=System.currentTimeMillis();
		System.out.println(lafter-lbefore);//打印业务执行需要的时间
		System.out.println(obj);
		System.out.println("执行方法之后，执行环绕通知");
		return obj;
	}
	
	@Around("execution(* store.controller.UserController.*(..))")
	public Object  test6(ProceedingJoinPoint pd) throws Throwable{
		System.out.println("execution执行方法之前，执行环绕通知");
		//执行业务逻辑方法,有结果时返回对象
		Object obj=pd.proceed();
		System.out.println("execution执行方法之后，执行环绕通知");
		return obj;
	}

}
