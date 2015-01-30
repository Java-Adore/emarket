package com.emarket.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.emarket.business.service.MemberService;



@ManagedBean
@ViewScoped
public class TestBean implements Serializable {

	/**
	 * 
	 */

	@EJB
	MemberService memberService;
	 
	private static final long serialVersionUID = 1L;

	public void execute()  { 
	}
	
	
}
