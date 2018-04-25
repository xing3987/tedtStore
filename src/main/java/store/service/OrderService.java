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

}
