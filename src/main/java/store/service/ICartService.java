package store.service;

import java.util.List;

import store.bean.Cart;
import store.bean.CartVo;

public interface ICartService {
	public void insertCart(Cart cart);//���빺�ﳵ����
	public List<CartVo> getCartVoByUid(Integer uid);//��ѯ�û����� ���е���Ϣ
	public void deleteById(Integer id);//ͨ��idɾ����Ʒ
}
