package store.mapper;

import org.apache.ibatis.annotations.Param;
import store.bean.GoodsCategory;

import java.util.List;

//������Ʒ������ѯ�ӿ�
public interface GoodsCategoryMapper {
	//����ͨ��parentId��ѯ��Ʒ��Ϣ�ķ�������ʵ�ַ�ҳ��ѯ���ܣ����ڲ����ж����������
		//@Param��װ��������
	public List<GoodsCategory> selectCategoryByParentId(@Param("parentId") Integer parentId,
			@Param("offset") Integer offset,@Param("count") Integer count);
}
