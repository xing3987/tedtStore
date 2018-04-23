package tedtStore;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import store.bean.Cart;
import store.bean.CartVo;
import store.mapper.CartMapper;
import store.service.CartService;
import store.service.ICartService;

public class TextCart {
	ApplicationContext ac=new ClassPathXmlApplicationContext(
			"spring-dao.xml","spring-mvc.xml","spring-service.xml");
	CartMapper cartMapper=ac.getBean("cartMapper",CartMapper.class);
	ICartService cartService=ac.getBean("cartService",CartService.class);
	
	/************���Գ־ò�**********************/
	@Test
	public void insertCart(){
		Cart cart=new Cart();
		cart.setCount(2);
		cart.setGoodsId("121");
		cart.setUid(163);
		cartMapper.insertCart(cart);
	}
	
	@Test
	//���Եõ�����܇��Ϣ�����(��������)
	public void getCartByUid(){
		List<CartVo> cartVos=cartMapper.getCartVoByUid(11);
		System.out.println(cartVos);
	}
	
	@Test
	//����ͨ��idɾ����Ʒ
	public void MapperDeleteById(){
		cartMapper.deleteById(1);
	}
	
	/***************����ҵ���********************/	
	@Test
	public void ServiceinsertCart() {//���빺�ﳵ����
		Cart cart=new Cart();
		cart.setCount(22);
		cart.setGoodsId("1221");
		cart.setUid(164);
		cartService.insertCart(cart);		
	}
	
	@Test
	public void ServicegetCartByUid() {//ͨ��uid��ѯ���ﳵ����
		List<CartVo> cartVos=cartService.getCartVoByUid(11);
		System.out.println(cartVos);		
	}
	
	@Test
	//����ͨ��idɾ����Ʒ
	public void ServiceDeleteById(){
		cartService.deleteById(2);
	}
	
}
