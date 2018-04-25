package store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import store.bean.Cart;
import store.bean.CartVo;
import store.bean.ResponseResult;
import store.service.ICartService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Resource
	ICartService cartService;
	
	
	
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(HttpSession session,String goodsId,Integer count){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		Cart cart=new Cart();
		cart.setUid(this.getId(session));
		cart.setGoodsId(goodsId);
		cart.setCount(count);
		cartService.insertCart(cart);
		rr.setState(1);
		rr.setMessage("��ӳɹ�");
		return rr;
	}
	
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,ModelMap map){
		List<CartVo> cartVos=cartService.getCartVoByUid(this.getId(session));
		map.addAttribute("cartVos",cartVos);
		return "cart";
	}
	
	@RequestMapping("/deleteById.do")
	//ͨ��idɾ�����ﳵ����
	public String showCart(Integer id){
		cartService.deleteById(id);
		return "redirect:../cart/showCart.do";
	}	
	
	@RequestMapping("/deleteBatchById.do")
	//ͨ��id��������ɾ�����ﳵ����
	public String showCart(int[] ids){
		cartService.deleteBatchById(ids);
		return "redirect:../cart/showCart.do";
	}
	
	@RequestMapping("/updateCountById.do")
	@ResponseBody
	//ͨ��id��������ɾ�����ﳵ����
	public ResponseResult<Void> updateCountById(Integer id,Integer count){	
		ResponseResult<Void> rr=new ResponseResult<Void>();
		cartService.updateCountById(id, count);
		rr.setState(1);
		rr.setMessage("�޸ĳɹ�");
		return rr;
	}
}
