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
import store.service.IOrderService;
import store.service.OrderService;

public class TextCart {
	ApplicationContext ac=new ClassPathXmlApplicationContext(
			"spring-dao.xml","spring-mvc.xml","spring-service.xml");
	CartMapper cartMapper=ac.getBean("cartMapper",CartMapper.class);
	ICartService cartService=ac.getBean("cartService",CartService.class);
	IOrderService orderService=ac.getBean("orderService",OrderService.class);
	
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
	
	@Test
	//����ͨ��id����ɾ����Ʒ
	public void MapperDeleteBatchById(){
		int[] ids={3,17};
		cartMapper.deleteBatchById(ids);
	}
	
	@Test
	//����ͨ��id,count�޸���Ʒ����
	public void MapperupdateCountById(){
		cartMapper.updateCountById(25, 3);
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
	
	@Test
	//����ͨ��id����ɾ����Ʒ
	public void ServiceDeleteBatchById(){
		int[] ids={3,18};
		cartService.deleteBatchById(ids);
	}
	
	@Test
	//����ͨ��id,count�޸���Ʒ����
	public void ServiceUpdateCountById(){
		cartService.updateCountById(25, 4);
	}
	
	@Test
	//����ͨ��uid,ids�õ�������Ʒ
	public void ServiceGetOrderByIds(){
		Integer[] ids={16,21,23};
		List<CartVo> cartVos=orderService.getOrderByIds(11, ids);
		System.out.println(cartVos);
	}
	
}
