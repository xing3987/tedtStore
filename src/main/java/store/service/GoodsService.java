package store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.Goods;
import store.mapper.GoodsMapper;

@Service
public class GoodsService implements IGoodsService{
	@Resource
	private GoodsMapper goodsMapper;

	public List<Goods> getGoodsByCategoryId(Integer categoryId, Integer offset, Integer count) {
		List<Goods> goodses=goodsMapper.select(categoryId, offset, count);
		return goodses;
	}

}
