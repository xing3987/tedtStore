package store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import store.bean.Address;
import store.bean.ResponseResult;
import store.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {

	@Resource
	AddressService addressService;

	@RequestMapping("/showAddress.do")
	public String showAddress() {
		return "addressAdmin";
	}

	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void> addAddress(HttpSession session, @RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince, @RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea, @RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone, @RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip, @RequestParam("addressName") String recvTag) {
		// 1.创建rr对象
		// 2.调用业务层方法
		// 3.设置rr的状态码和信息
		ResponseResult<Void> rr = new ResponseResult<Void>();
		Address address = new Address();
		address.setUid(this.getId(session));
		address.setRecvAddress(recvAddress);
		address.setRecvName(recvName);
		address.setRecvArea(recvArea);
		address.setRecvPhone(recvPhone);
		address.setRecvCity(recvCity);
		address.setRecvProvince(recvProvince);
		address.setRecvZip(recvZip);
		address.setRecvTel(recvTel);
		address.setRecvTag(recvTag);
		addressService.addAddress(address);
		rr.setState(1);
		rr.setMessage("添加成功");
		return rr;
	}

	@RequestMapping("/getAddressByUid.do")
	@ResponseBody
	// 得到所有的用户收货地址
	public ResponseResult<List<Address>> getAddressByUid(HttpSession session) {
		ResponseResult<List<Address>> rr = new ResponseResult<List<Address>>();
		Integer uid = this.getId(session);
		List<Address> address = addressService.getAddress(uid);
		rr.setState(1);
		rr.setData(address);
		return rr;
	}

	@RequestMapping("/setDefault.do")
	@ResponseBody
	public ResponseResult<Void> getDefault(HttpSession session, Integer id) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			addressService.setDefault(this.getId(session), id);
			rr.setState(1);
		} catch (Exception e) {
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
	}

	@RequestMapping("/getAddressById.do")
	@ResponseBody
	public ResponseResult<Address> getAddressById(Integer id) {
		ResponseResult<Address> rr = new ResponseResult<Address>();
		Address address=addressService.getAddressById(id);
		rr.setState(1);
		rr.setData(address);
		return rr;
	}
	
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	public ResponseResult<Address> updateAddress(Integer id, @RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince, @RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea, @RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone, @RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip, @RequestParam("addressName") String recvTag) {
		// 1.创建rr对象
		// 2.调用业务层方法
		// 3.设置rr的状态码和信息
		ResponseResult<Address> rr = new ResponseResult<Address>();
		Address address = new Address();
		address.setId(id);
		address.setRecvAddress(recvAddress);
		address.setRecvName(recvName);
		address.setRecvArea(recvArea);
		address.setRecvPhone(recvPhone);
		address.setRecvCity(recvCity);
		address.setRecvProvince(recvProvince);
		address.setRecvZip(recvZip);
		address.setRecvTel(recvTel);
		address.setRecvTag(recvTag);
		addressService.updateAddressById(address);;
		rr.setState(1);
		rr.setMessage("修改成功");
		return rr;
	}
	
	@RequestMapping("/deleteById.do")
	@ResponseBody
	public  ResponseResult<Void> deleteAddressById(Integer id){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		addressService.deletById(id);
		rr.setState(1);
		rr.setMessage("删除成功");
		return rr;
	}
	
}
