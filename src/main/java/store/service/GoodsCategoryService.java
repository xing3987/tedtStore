package store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import store.bean.GoodsCategory;
import store.mapper.GoodsCategoryMapper;
//实现商品类接口
@Service
public class GoodsCategoryService implements IGoodsCategoryService{

	@Resource
	private GoodsCategoryMapper categoryMapper;
	
	/*
	 * 通过parentId分页查询商品信息
	 */
	public List<GoodsCategory> getCategoryByParentId(Integer parentId, Integer offset, Integer count) {
		List<GoodsCategory> goodsCategorys=categoryMapper.selectCategoryByParentId(parentId, offset, count);
		return goodsCategorys;
	}

}
