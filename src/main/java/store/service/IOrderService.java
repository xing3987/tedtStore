package store.service;

import java.util.List;

import store.bean.CartVo;

//��������ҵ���ӿ�
public interface IOrderService {
	public List<CartVo> getOrderByIds(Integer uid,Integer[] ids);
}
