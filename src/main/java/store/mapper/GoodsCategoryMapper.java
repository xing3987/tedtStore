package store.mapper;

import org.apache.ibatis.annotations.Param;
import store.bean.GoodsCategory;

import java.util.List;

//创建商品分类表查询接口
public interface GoodsCategoryMapper {
	//创建通过parentId查询商品信息的方法，并实现分页查询功能，由于参数有多个，所以用
		//@Param封装起来传递
	public List<GoodsCategory> selectCategoryByParentId(@Param("parentId") Integer parentId,
			@Param("offset") Integer offset,@Param("count") Integer count);
}
