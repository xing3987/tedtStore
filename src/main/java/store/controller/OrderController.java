package store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import store.bean.Address;
import store.bean.CartVo;
import store.bean.Order;
import store.service.IAddressService;
import store.service.IOrderService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

//订单管理控制器
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	@Resource
	private IOrderService orderService;
	@Resource
	private IAddressService addressService;

	@RequestMapping("/showOrderConfirm.do")
	public String showOrderConfirm(HttpSession session, Integer[] ids, ModelMap map) {
		List<CartVo> cartVos = orderService.getOrderByIds(this.getId(session), ids);
		List<Address> addressList=addressService.getAddress(this.getId(session));
		session.setAttribute("cartVos", cartVos);//把订单商品集合放入session中以便订单管理使用
		map.addAttribute("cartVos", cartVos);
		map.addAttribute("addressList",addressList);
		return "orderConfirm";
	}
	
	@RequestMapping("/addOrder.do")
	public String addOrder(HttpSession session){
		Order order=new Order();
		order.setUid(this.getId(session));
		List<CartVo> cartVos=(List<CartVo>) session.getAttribute("cartVos");//从session中获得cartVos
		orderService.addOrder(order, cartVos);
		session.setAttribute("orderId", order.getId());//得到orderId并绑定到session，以便支付时使用
		return "payment";
	}
	
	@RequestMapping("/paysuccess.do")
	public String paysuccess(HttpSession session){
		Integer orderId=(Integer) session.getAttribute("orderId");
		orderService.updateItem(orderId);
		session.removeAttribute("orderId");//移除订单id
		session.removeAttribute("cartVos");//移除购物车勾选支付的数据
		return "pay_success";
	}
	
}
