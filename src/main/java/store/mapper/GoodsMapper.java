package store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import store.bean.Goods;

//��Ʒ��ϸ��Ϣӳ��
public interface GoodsMapper {
	public List<Goods> select(@Param("categoryId") Integer categoryId,
			@Param("offset") Integer offset,@Param("count") Integer count);
	public Integer selectCount(Integer categoryId);//ͨ������Id��ѯ��Ʒ������
}
