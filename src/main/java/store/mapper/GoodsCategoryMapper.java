package store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import store.bean.GoodsCategory;

//������Ʒ������ѯ�ӿ�
public interface GoodsCategoryMapper {
	//����ͨ��parentId��ѯ��Ʒ��Ϣ�ķ�������ʵ�ַ�ҳ��ѯ���ܣ����ڲ����ж����������
		//@Param��װ��������
	public List<GoodsCategory> selectCategoryByParentId(@Param("parentId") Integer parentId,
			@Param("offset") Integer offset,@Param("count") Integer count);
}
