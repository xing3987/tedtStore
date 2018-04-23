package store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.Cart;
import store.bean.CartVo;
import store.mapper.CartMapper;
@Service
public class CartService implements ICartService{
	@Resource
	CartMapper cartMapper;
	public void insertCart(Cart cart) {//���빺�ﳵ����
		cartMapper.insertCart(cart);		
	}
	
	public List<CartVo> getCartVoByUid(Integer uid) {//��ѯ����܇�е���Ϣ
		List<CartVo> cartVos=cartMapper.getCartVoByUid(uid);
		return cartVos;
	}

	//ͨ��idɾ����Ʒ
	public void deleteById(Integer id) {
		cartMapper.deleteById(id);		
	}
		
	
	
}
