package store.service;

import java.util.List;
import store.bean.GoodsCategory;
//商品查询服务层接口
public interface IGoodsCategoryService {
	public List<GoodsCategory> getCategoryByParentId(Integer parentId,
			Integer offset,Integer count);//通过parentId分页查询商品
}
