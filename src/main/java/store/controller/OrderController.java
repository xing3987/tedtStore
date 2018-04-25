package store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import store.bean.Address;
import store.bean.CartVo;
import store.service.IAddressService;
import store.service.IOrderService;

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
		map.addAttribute("cartVos", cartVos);
		map.addAttribute("addressList",addressList);
		return "orderConfirm";
	}
}
