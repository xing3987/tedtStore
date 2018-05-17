package store.mapper;

import org.apache.ibatis.annotations.Param;
import store.bean.Cart;
import store.bean.CartVo;

import java.util.List;

public interface CartMapper {
	public void insertCart(Cart cart);//���빺�ﳵ
	public List<CartVo> getCartVoByUid(Integer uid);//ͨ���û�uid��ѯ����܇����Ϣ
	public void deleteById(Integer id);//ͨ��idɾ����Ʒ
	public void deleteBatchById(int[] ids);//ͨ��id��������ɾ�����ﳵ��Ʒ
	public void updateCountById(@Param("id") Integer id,@Param("count") Integer count);//ͨ��id,count�ı�����
}
