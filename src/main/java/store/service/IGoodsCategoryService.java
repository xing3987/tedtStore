package store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import store.bean.GoodsCategory;
//��Ʒ��ѯ�����ӿ�
@Transactional
public interface IGoodsCategoryService {
	public List<GoodsCategory> getCategoryByParentId(Integer parentId,
			Integer offset,Integer count);//ͨ��parentId��ҳ��ѯ��Ʒ
}
