/**
 * 
 */
package com.grabkart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grabkart.entity.Product;
import com.grabkart.entity.User;
import com.grabkart.service.GrabKartService;

/**
 * @author Sundaram
 *
 */
@Controller
public class LoginController {

	private static final String buyerDashboard = "buyerDashboard";
	private static final String sellerDashboard = "sellerDashboard";
	private static final String buyer = "buyer";
	private static final String seller = "seller";
	
	@Autowired
	private GrabKartService grabKartService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String initForm(Model model){
		String target = "home";
		User user = new User();
		model.addAttribute(user);
		return target;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("user") User user, Model model){
		String target="home";
		User userRetrieved = grabKartService.login(user);

		if (userRetrieved == null) {
			model.addAttribute("errorMessage", "Invalid username/password.");
			model.addAttribute("invalidUser", true);
		} else {
			String type = userRetrieved.getType();
			if (type.equals(buyer)) {
				target = buyerDashboard;
				showBuyerDashboard(model);
			} else if(type.equals(seller)) {
				target = sellerDashboard;
				showSellerDashboard(model, userRetrieved);
			}
		}
		return target;
	}

	private void showSellerDashboard(Model model, User userRetrieved) {
		List<Product> productList = grabKartService.getProductListForSeller(userRetrieved);
		model.addAttribute("productList", productList);
	}

	private void showBuyerDashboard(Model model) {
		List<Product> productList = grabKartService.getProductList();
		model.addAttribute("productList", productList);
	}
}
