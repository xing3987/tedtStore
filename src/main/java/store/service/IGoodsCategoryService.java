package store.service;

import java.util.List;
import store.bean.GoodsCategory;
//��Ʒ��ѯ�����ӿ�
public interface IGoodsCategoryService {
	public List<GoodsCategory> getCategoryByParentId(Integer parentId,
			Integer offset,Integer count);//ͨ��parentId��ҳ��ѯ��Ʒ
}
