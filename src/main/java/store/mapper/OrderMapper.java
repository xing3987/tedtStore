package store.mapper;

import store.bean.Order;
import store.bean.OrderItem;

public interface OrderMapper {
	public void insertOrder(Order order);			//��Ӷ���	
	public void insertOrderItem(OrderItem orderItem);		//��Ӷ�����Ʒ
	public void updatePaymentStatusByOrderId(Integer orderId);//���ݶ���id�޸Ķ���֧��״̬
}
