package com.emarket.business.facade;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.emarket.business.service.MemberService;
import com.emarket.business.service.ProductService;
import com.emarket.domain.Flower;
import com.emarket.domain.Honey;
import com.emarket.domain.Miscellaneous;
import com.emarket.domain.Order;
import com.emarket.domain.OrderItem;
import com.emarket.domain.Product;
import com.emarket.domain.ShoppingCart;
import com.emarket.domain.User;
import com.emarket.domain.Wax;
import com.emarket.general.Constants;
import com.emarket.general.EMarketException;
import com.emarket.utils.Util;

@Stateless
public class EmarketFacadeImpl implements EmarketFacade {

	@EJB
	private MemberService memberService;
	
	@EJB
	ProductService productService;

	@Override
	public List<User> getAllUsers() {
		
		return memberService.getAllUsers();
	}

	@Override
	public User getUserByID(Long l) {
		
		return memberService.getUserByID(l);
	}

	@Override
	public void updateUserByID(User user) {
		// TODO Auto-generated method stub
		memberService.updateUserByID(user);
	}
	
	public User login(String userName, String password) throws EMarketException {

		User member = memberService.getUserByUserName(userName);
		if (member == null) {
			throw Constants.invalidEmail;
		} else {
			if (member.getPassword() != null
					&& member.getPassword().equals(Util.encrypt(password))) {
				return member;

			} else {
				throw Constants.invalidPassword;
			}
		}
	}

	@Override
	public User register(String firstName, String lastName, String userName,
			String password, String confirmPassword, String userPicPath)
			throws EMarketException {

		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(com.emarket.utils.Util.encrypt(password));
		if(user.getRole()!=1)
		{
			user.setRole(0);
		}
		user = memberService.addUser(user);
		return user;

	}


	@Override
	public List<Flower> getAllFlowersProducts() {
		
		return productService.getAllFlowersProducts();
	}

	@Override
	public Flower addNewFlowerProduct(Flower product) {
		
		return productService.addNewFlowerProduct(product);
	}

	@Override
	public List<Wax> getAllWaxProducts() {
		
		return productService.getAllWaxProducts();
	}

	@Override
	public Wax addNewWaxProduct(Wax product) {
		
		return productService.addNewWaxProduct(product);
	}

	@Override
	public List<Miscellaneous> getAllMiscellaneousProducts() {
		
		return productService.getAllMiscellaneousProducts();
	}

	@Override
	public Miscellaneous addNewProduct(Miscellaneous product) {
		
		return productService.addNewProduct(product);
	}

	@Override
	public List<Honey> getAllHoneyProducts() {
		
		return productService.getAllHoneyProducts();
	}

	@Override
	public Honey addNewHoneyProduct(Honey product) {
		
		return productService.addNewHoneyProduct(product);
	}

	@Override
	public void handleShoppingCart(ShoppingCart shoppingCart , User user,boolean immediate) {

		Order order = new Order();
		order.setOrderDate(new Date());
		order.setUser(user);
		
		order = productService.addNewOrder(order);
		
		Map<Integer,Product> map = new HashMap();
		
		for(Product p : shoppingCart.getOrders().keySet())
		{
			Product currentProduct = productService.getProduct(p);
			
			map.put(shoppingCart.getOrders().get(p), currentProduct);
			
			OrderItem orderItem = new OrderItem();
			
				orderItem.setAmount( shoppingCart.getOrders().get(p));
			
			orderItem.setPrice(p.getPrice());
			orderItem.setProduct(p);
			orderItem.setOrder(order);
			productService.addNewOrderItem(orderItem);
		}
		
	}

	
}
