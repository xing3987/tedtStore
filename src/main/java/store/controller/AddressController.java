package store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	@RequestMapping("/showAddress.do")
	public String showAddress(){
		return "addressAdmin";
	}
}
