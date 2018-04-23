package store.mapper;

import java.util.List;

import store.bean.Cart;
import store.bean.CartVo;

public interface CartMapper {
	public void insertCart(Cart cart);//���빺�ﳵ
	public List<CartVo> getCartVoByUid(Integer uid);//ͨ���û�uid��ѯ����܇����Ϣ
	public void deleteById(Integer id);//ͨ��idɾ����Ʒ
}
