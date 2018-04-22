package store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import store.bean.Goods;

//商品详细信息映射
public interface GoodsMapper {
	public List<Goods> select(@Param("categoryId") Integer categoryId,
			@Param("offset") Integer offset,@Param("count") Integer count);
	public Integer selectCount(Integer categoryId);//通过分类Id查询商品的数量
}
