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
	
	//�����ؼ�ǰ����
	@Before("within(store.controller.UserController)")//��һ�ַ�ʽwithin(����)
	public void  test1(){
		System.out.println("ִ�з���֮ǰ");
	}
		
	//���ܷ��������쳣����ִ��
	@After("bean(userController)")
	public void  test2(){
		System.out.println("afterִ�з���֮��");
	}
	
	//�������쳣��ִ��
	@AfterReturning("bean(userController)")
	public void  test3(){
		System.out.println("afterReturningִ�з������쳣֮��");
	}
	
	//�����쳣ִ��
	@AfterThrowing("bean(userController)")
	public void  test4(){
		System.out.println("ִ�з������쳣ʱ����");
	}
	
	//��ҵ��ǰ�󶼻ᷢ��
	@Around("bean(userController)")
	public Object  test5(ProceedingJoinPoint pd) throws Throwable{
		System.out.println("ִ�з���֮ǰ��ִ�л���֪ͨ");
		Long lbefore=System.currentTimeMillis();
		//ִ��ҵ���߼�����,�н��ʱ���ض���
		Object obj=pd.proceed();
		Long lafter=System.currentTimeMillis();
		System.out.println(lafter-lbefore);//��ӡҵ��ִ����Ҫ��ʱ��
		System.out.println(obj);
		System.out.println("ִ�з���֮��ִ�л���֪ͨ");
		return obj;
	}
	
	@Around("execution(* store.controller.UserController.*(..))")
	public Object  test6(ProceedingJoinPoint pd) throws Throwable{
		System.out.println("executionִ�з���֮ǰ��ִ�л���֪ͨ");
		//ִ��ҵ���߼�����,�н��ʱ���ض���
		Object obj=pd.proceed();
		System.out.println("executionִ�з���֮��ִ�л���֪ͨ");
		return obj;
	}

}
