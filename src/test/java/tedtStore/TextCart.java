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
	
	/************测试持久层**********************/
	@Test
	public void insertCart(){
		Cart cart=new Cart();
		cart.setCount(2);
		cart.setGoodsId("121");
		cart.setUid(163);
		cartMapper.insertCart(cart);
	}
	
	@Test
	//测试得到购物車信息的语句(两边联查)
	public void getCartByUid(){
		List<CartVo> cartVos=cartMapper.getCartVoByUid(11);
		System.out.println(cartVos);
	}
	
	@Test
	//测试通过id删除商品
	public void MapperDeleteById(){
		cartMapper.deleteById(1);
	}
	
	@Test
	//测试通过id批量删除商品
	public void MapperDeleteBatchById(){
		int[] ids={3,17};
		cartMapper.deleteBatchById(ids);
	}
	
	@Test
	//测试通过id,count修改商品数量
	public void MapperupdateCountById(){
		cartMapper.updateCountById(25, 3);
	}
	
	/***************测试业务层********************/	
	@Test
	public void ServiceinsertCart() {//插入购物车数据
		Cart cart=new Cart();
		cart.setCount(22);
		cart.setGoodsId("1221");
		cart.setUid(164);
		cartService.insertCart(cart);		
	}
	
	@Test
	public void ServicegetCartByUid() {//通过uid查询购物车数据
		List<CartVo> cartVos=cartService.getCartVoByUid(11);
		System.out.println(cartVos);		
	}
	
	@Test
	//测试通过id删除商品
	public void ServiceDeleteById(){
		cartService.deleteById(2);
	}
	
	@Test
	//测试通过id批量删除商品
	public void ServiceDeleteBatchById(){
		int[] ids={3,18};
		cartService.deleteBatchById(ids);
	}
	
	@Test
	//测试通过id,count修改商品数量
	public void ServiceUpdateCountById(){
		cartService.updateCountById(25, 4);
	}
	
	@Test
	//测试通过uid,ids得到订单商品
	public void ServiceGetOrderByIds(){
		Integer[] ids={16,21,23};
		List<CartVo> cartVos=orderService.getOrderByIds(11, ids);
		System.out.println(cartVos);
	}
	
}
