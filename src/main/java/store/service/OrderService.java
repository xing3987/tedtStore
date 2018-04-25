package store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.CartVo;
import store.mapper.CartMapper;
@Service
public class OrderService implements IOrderService{
	
	@Resource
	private CartMapper cartMapper;
	
	//通过uid和ids确认订单商品
	public List<CartVo> getOrderByIds(Integer uid, Integer[] ids) {
		List<CartVo> orderList=new ArrayList<CartVo>();
		List<CartVo> cartVos=cartMapper.getCartVoByUid(uid);//得到该用户的所有购物车商品
		for(CartVo cartVo:cartVos){
			for(int id:ids){//如果商品id等于传递来的id，则添加到订单集合中
				if(cartVo.getId()==id){
					orderList.add(cartVo);
					break;
				}
			}
		}
		return orderList;
	}

}
