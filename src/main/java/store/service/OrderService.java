package store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.CartVo;
import store.bean.Goods;
import store.bean.Order;
import store.bean.OrderItem;
import store.mapper.CartMapper;
import store.mapper.GoodsMapper;
import store.mapper.OrderMapper;
@Service
public class OrderService implements IOrderService{
	
	@Resource
	private CartMapper cartMapper;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private GoodsMapper goodsMapper;
	
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

	//添加订单信息和订单详情，并修改商品库存
	public void addOrder(Order order, List<CartVo> cartVos) {
		orderMapper.insertOrder(order);
		for(CartVo cartVo:cartVos){
			//设置订单详情信息
			OrderItem orderItem=new OrderItem();
			orderItem.setUid(cartVo.getUid());
			orderItem.setGoodsId(cartVo.getGoodsId());
			orderItem.setImage(cartVo.getImage());
			orderItem.setTitle(cartVo.getTitle());
			orderItem.setPrice(cartVo.getPrice());
			orderItem.setCount(cartVo.getCount());
			orderItem.setPaymentStatus(0);
			orderItem.setOrderStatus(0);
			orderItem.setOrderId(order.getId());
			orderMapper.insertOrderItem(orderItem);//插入订单详情中
			
			Goods goods=goodsMapper.selectGoodsById(Integer.parseInt(cartVo.getGoodsId()));//通过id查询该商品信息，为了得到商品数量
			//设置商品的现在数量，库存减去购买数量
			goodsMapper.updateNumById(cartVo.getGoodsId(), goods.getNum()-cartVo.getCount());
		}		
	}


	//通过订单id修改支付状态
	public void updateItem(Integer orderId) {
		orderMapper.updatePaymentStatusByOrderId(orderId);
	}

}
