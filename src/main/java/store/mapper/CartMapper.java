package store.mapper;

import java.util.List;

import store.bean.Cart;
import store.bean.CartVo;

public interface CartMapper {
	public void insertCart(Cart cart);//插入购物车
	public List<CartVo> getCartVoByUid(Integer uid);//通过用户uid查询购物車内信息
	public void deleteById(Integer id);//通过id删除商品
}
