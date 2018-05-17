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

//�������������
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
		session.setAttribute("cartVos", cartVos);//�Ѷ�����Ʒ���Ϸ���session���Ա㶩������ʹ��
		map.addAttribute("cartVos", cartVos);
		map.addAttribute("addressList",addressList);
		return "orderConfirm";
	}
	
	@RequestMapping("/addOrder.do")
	public String addOrder(HttpSession session){
		Order order=new Order();
		order.setUid(this.getId(session));
		List<CartVo> cartVos=(List<CartVo>) session.getAttribute("cartVos");//��session�л��cartVos
		orderService.addOrder(order, cartVos);
		session.setAttribute("orderId", order.getId());//�õ�orderId���󶨵�session���Ա�֧��ʱʹ��
		return "payment";
	}
	
	@RequestMapping("/paysuccess.do")
	public String paysuccess(HttpSession session){
		Integer orderId=(Integer) session.getAttribute("orderId");
		orderService.updateItem(orderId);
		session.removeAttribute("orderId");//�Ƴ�����id
		session.removeAttribute("cartVos");//�Ƴ����ﳵ��ѡ֧��������
		return "pay_success";
	}
	
}
