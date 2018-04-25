package store.service;

import java.util.List;

import store.bean.Cart;
import store.bean.CartVo;

public interface ICartService {
	public void insertCart(Cart cart);//插入购物车数据
	public List<CartVo> getCartVoByUid(Integer uid);//查询用户购物 车中的信息
	public void deleteById(Integer id);//通过id删除商品
	public void deleteBatchById(int[] ids);//通过id集合批量删除购物车商品
	public void updateCountById(Integer id,Integer count);//通过id,count修改商品数量
}
