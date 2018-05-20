package store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import store.bean.Goods;
@Transactional
public interface IGoodsService {
	public List<Goods> getGoodsByCategoryId(Integer categoryId,
					Integer offset,Integer count);
	
	public Integer getCount(Integer categoryId);
	public Goods getGoodsById(Integer id);//通过id查找商品
	public void setGoodsNumById(String id,Integer num);//通过id设置商品数量
}
