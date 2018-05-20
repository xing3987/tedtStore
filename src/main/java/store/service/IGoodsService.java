package store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import store.bean.Goods;
@Transactional
public interface IGoodsService {
	public List<Goods> getGoodsByCategoryId(Integer categoryId,
					Integer offset,Integer count);
	
	public Integer getCount(Integer categoryId);
	public Goods getGoodsById(Integer id);//ͨ��id������Ʒ
	public void setGoodsNumById(String id,Integer num);//ͨ��id������Ʒ����
}
