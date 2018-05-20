package store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import store.bean.CartVo;
import store.bean.Order;
@Transactional
//��������ҵ���ӿ�
public interface IOrderService {
	public List<CartVo> getOrderByIds(Integer uid,Integer[] ids);
	public void addOrder(Order order,List<CartVo> cartVos);//��Ӷ�����Ϣ���Ͷ���������Ϣ
	public void updateItem(Integer orderId);//ͨ��orderId�޸Ķ���֧��״̬
}
