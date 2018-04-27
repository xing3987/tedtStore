package tedtStore;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import store.bean.CartVo;
import store.bean.Order;
import store.bean.OrderItem;
import store.mapper.OrderMapper;
import store.service.IOrderService;
import store.service.OrderService;


public class TextOrder {
	ApplicationContext ac=new ClassPathXmlApplicationContext(
			"spring-dao.xml","spring-mvc.xml","spring-service.xml");
	OrderMapper orderMapper=ac.getBean("orderMapper",OrderMapper.class);
	IOrderService orderService=ac.getBean("orderService",OrderService.class);
	
	/************²âÊÔ³Ö¾Ã²ã**********************/
	@Test
	public void MapperInsertOrder(){
		Order order=new Order();
		order.setUid(21);
		orderMapper.insertOrder(order);
		System.out.println(order.getId());
	}
	
	@Test
	public void MapperInsertOrderItem(){
		OrderItem orderItem=new OrderItem();
		orderItem.setUid(10);
		orderItem.setGoodsId("123456");
		orderItem.setCount(3);
		orderMapper.insertOrderItem(orderItem);
	}
	
	
	@Test
	//ÐÞ¸Ä¶©µ¥Ö§¸¶×´Ì¬
	public void MapperUpdateItem(){
		orderMapper.updatePaymentStatusByOrderId(8);
	}
	
	/***************²âÊÔÒµÎñ²ã********************/	
	@Test
	public void ServiceAddOrder(){
		Order order=new Order();
		order.setUid(3);
		List<CartVo> cartVos=new ArrayList<CartVo>();
		CartVo cartVo=new CartVo();
		cartVo.setGoodsId("10000006");
		cartVo.setUid(3);
		cartVo.setCount(2);
		cartVo.setPrice(100);
		cartVo.setImage("/123154/1.jpg");
		cartVos.add(cartVo);
		orderService.addOrder(order, cartVos);
	}
	
	
}
