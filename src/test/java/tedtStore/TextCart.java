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
	
}
