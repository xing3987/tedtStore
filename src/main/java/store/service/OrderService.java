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
	
	//ͨ��uid��idsȷ�϶�����Ʒ
	public List<CartVo> getOrderByIds(Integer uid, Integer[] ids) {
		List<CartVo> orderList=new ArrayList<CartVo>();
		List<CartVo> cartVos=cartMapper.getCartVoByUid(uid);//�õ����û������й��ﳵ��Ʒ
		for(CartVo cartVo:cartVos){
			for(int id:ids){//�����Ʒid���ڴ�������id������ӵ�����������
				if(cartVo.getId()==id){
					orderList.add(cartVo);
					break;
				}
			}
		}
		return orderList;
	}

	//��Ӷ�����Ϣ�Ͷ������飬���޸���Ʒ���
	public void addOrder(Order order, List<CartVo> cartVos) {
		orderMapper.insertOrder(order);
		for(CartVo cartVo:cartVos){
			//���ö���������Ϣ
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
			orderMapper.insertOrderItem(orderItem);//���붩��������
			
			Goods goods=goodsMapper.selectGoodsById(Integer.parseInt(cartVo.getGoodsId()));//ͨ��id��ѯ����Ʒ��Ϣ��Ϊ�˵õ���Ʒ����
			//������Ʒ����������������ȥ��������
			goodsMapper.updateNumById(cartVo.getGoodsId(), goods.getNum()-cartVo.getCount());
		}		
	}


	//ͨ������id�޸�֧��״̬
	public void updateItem(Integer orderId) {
		orderMapper.updatePaymentStatusByOrderId(orderId);
	}

}
