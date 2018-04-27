package tedtStore;

import java.io.FileInputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

//���Լ���
public class TestMD5 {
	@Value("#{dbConfig.salt}")
	private String salt;
	@Test
	public void test(){
		System.out.println(salt);
		String str1=DigestUtils.md5Hex("123456");//���ü��ܰ��ķ���,תΪ32λ��ϢժҪ�������ǲ������
		String str2=DigestUtils.md5Hex("123456");//���������ͬ����ϢժҪҲ��ͬ���Ƕ�Ӧ��
		System.out.println(str1);
		System.out.println(str2);
		
		//�ж������ļ��Ƿ���ͬ
		try {
			String fileStr1=DigestUtils.md5Hex(new FileInputStream("1.txt"));//ͨ����������ȡ�ļ�
			String fileStr2=DigestUtils.md5Hex(new FileInputStream("2.txt"));
			System.out.println(fileStr1);
			System.out.println(fileStr2);
			System.out.println(fileStr1.equals(fileStr2));
		} catch (Exception e){}
		
		//���δ���,���Ӱ�ȫ
		String salt="��ϲ�������";
		String pwd="123456";
		String strpwd=DigestUtils.md5Hex(pwd+salt);
		System.out.println(strpwd);
	}
	
	
}
