package tedtStore;

import java.io.FileInputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

//测试加密
public class TestMD5 {
	@Value("#{dbConfig.salt}")
	private String salt;
	@Test
	public void test(){
		System.out.println(salt);
		String str1=DigestUtils.md5Hex("123456");//调用加密包的方法,转为32位消息摘要，加密是不可逆的
		String str2=DigestUtils.md5Hex("123456");//如果数据相同，消息摘要也相同，是对应的
		System.out.println(str1);
		System.out.println(str2);
		
		//判断两个文件是否相同
		try {
			String fileStr1=DigestUtils.md5Hex(new FileInputStream("1.txt"));//通过输入流读取文件
			String fileStr2=DigestUtils.md5Hex(new FileInputStream("2.txt"));
			System.out.println(fileStr1);
			System.out.println(fileStr2);
			System.out.println(fileStr1.equals(fileStr2));
		} catch (Exception e){}
		
		//加盐处理,更加安全
		String salt="你喜欢编程吗";
		String pwd="123456";
		String strpwd=DigestUtils.md5Hex(pwd+salt);
		System.out.println(strpwd);
	}
	
	
}
