package store.mapper;

import org.apache.ibatis.annotations.Param;
import store.bean.Cart;
import store.bean.CartVo;

import java.util.List;

public interface CartMapper {
	public void insertCart(Cart cart);//插入购物车
	public List<CartVo> getCartVoByUid(Integer uid);//通过用户uid查询购物車内信息
	public void deleteById(Integer id);//通过id删除商品
	public void deleteBatchById(int[] ids);//通过id数组批量删除购物车商品
	public void updateCountById(@Param("id") Integer id,@Param("count") Integer count);//通过id,count改变数量
}
