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
	public void insertCart(Cart cart) {//插入购物车数据
		cartMapper.insertCart(cart);		
	}
	
	public List<CartVo> getCartVoByUid(Integer uid) {//查询购物車中的信息
		List<CartVo> cartVos=cartMapper.getCartVoByUid(uid);
		return cartVos;
	}

	//通过id删除商品
	public void deleteById(Integer id) {
		cartMapper.deleteById(id);		
	}

	//通过id集合批量删除购物车商品
	public void deleteBatchById(int[] ids) {
		cartMapper.deleteBatchById(ids);
	}

	//通过id，count修改购物车商品数量
	public void updateCountById(Integer id, Integer count) {
		cartMapper.updateCountById(id, count);
	}
		
	
	
}
