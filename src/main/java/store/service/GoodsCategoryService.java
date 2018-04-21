package store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.GoodsCategory;
import store.mapper.GoodsCategoryMapper;
//ʵ����Ʒ��ӿ�
@Service
public class GoodsCategoryService implements IGoodsCategoryService{

	@Resource
	private GoodsCategoryMapper categoryMapper;
	
	/*
	 * ͨ��parentId��ҳ��ѯ��Ʒ��Ϣ
	 */
	public List<GoodsCategory> getCategoryByParentId(Integer parentId, Integer offset, Integer count) {
		List<GoodsCategory> goodsCategorys=categoryMapper.selectCategoryByParentId(parentId, offset, count);
		return goodsCategorys;
	}

}
