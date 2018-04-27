package store.service;

import java.util.List;

import store.bean.Goods;

public interface IGoodsService {
	public List<Goods> getGoodsByCategoryId(Integer categoryId,
					Integer offset,Integer count);
	
	public Integer getCount(Integer categoryId);
	public Goods getGoodsById(Integer id);//通过id查找商品
	public void setGoodsNumById(String id,Integer num);//通过id设置商品数量
}
