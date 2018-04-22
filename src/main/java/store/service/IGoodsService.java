package store.service;

import java.util.List;

import store.bean.Goods;

public interface IGoodsService {
	public List<Goods> getGoodsByCategoryId(Integer categoryId,
					Integer offset,Integer count);
	
	public Integer getCount(Integer categoryId);
}
