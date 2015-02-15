package com.emarket.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.dialect.FirebirdDialect;

import com.emarket.business.facade.EmarketFacade;
import com.emarket.domain.*;
import com.emarket.utils.WebUtils;

@ManagedBean
@ViewScoped
public class ManageProductsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	EmarketFacade emarketFacade;

	private List<Flower> flowersList;
	private List<Honey> honeyList;
	private List<Miscellaneous> miscellaneousList;
	private List<Wax> waxList;

	private Flower activeflower;
	private Honey activeHoney;
	private Wax activeWax;
	private Miscellaneous activeMiscellaneous;

	private Flower flowerType;

	@PostConstruct
	public void init() {
		flowersList = emarketFacade.getAllFlowersProducts();
		honeyList = emarketFacade.getAllHoneyProducts();
		miscellaneousList = emarketFacade.getAllMiscellaneousProducts();
		waxList = emarketFacade.getAllWaxProducts();
		activeflower = new Flower();
		activeHoney = new Honey();
		activeWax = new Wax();
		activeMiscellaneous = new Miscellaneous();
		flowerType = new Flower();

	}

	public EmarketFacade getEmarketFacade() {
		return emarketFacade;
	}

	public void setEmarketFacade(EmarketFacade emarketFacade) {
		this.emarketFacade = emarketFacade;
	}

	public List<Flower> getFlowersList() {
		return flowersList;
	}

	public void setFlowersList(List<Flower> flowersList) {
		this.flowersList = flowersList;
	}

	public List<Honey> getHoneyList() {
		return honeyList;
	}

	public void setHoneyList(List<Honey> honeyList) {
		this.honeyList = honeyList;
	}

	public List<Miscellaneous> getMiscellaneousList() {
		return miscellaneousList;
	}

	public void setMiscellaneousList(List<Miscellaneous> miscellaneousList) {
		this.miscellaneousList = miscellaneousList;
	}

	public List<Wax> getWaxList() {
		return waxList;
	}

	public void setWaxList(List<Wax> waxList) {
		this.waxList = waxList;
	}

	public void addNewHoneyProduct() {

		try {
			if (flowerType.getID() != null) {
				activeHoney.setSource(flowerType);
			}
			activeHoney.setProductType("Honey");
			activeHoney = emarketFacade.addNewHoneyProduct(activeHoney);
			if (honeyList.contains(activeHoney) == false) {
				honeyList.add(activeHoney);
			}
			WebUtils.fireSuccessMessage();

		} catch (Exception ex) {
			WebUtils.fireFaildMessage();

		} finally {
			WebUtils.invokeJavaScriptFunction("PF('honeyDialog').hide()");
			activeHoney = new Honey();

		}

	}

	public void addNewWaxProduct() {

		try {
			activeWax.setProductType("Wax");
			activeWax = emarketFacade.addNewWaxProduct(activeWax);
			if (waxList.contains(activeWax) == false) {
				waxList.add(activeWax);
			}
			WebUtils.fireSuccessMessage();

		} catch (Exception ex) {
			WebUtils.fireFaildMessage();

		} finally {
			WebUtils.invokeJavaScriptFunction("PF('waxDialog').hide()");
			activeWax = new Wax();

		}
	}

	public void addNewMiscellaneousProduct() {

		try {
			activeMiscellaneous.setProductType("Miscellaneous");
			activeMiscellaneous = emarketFacade
					.addNewProduct(activeMiscellaneous);
			if (miscellaneousList.contains(activeMiscellaneous) == false) {
				miscellaneousList.add(activeMiscellaneous);
			}
			WebUtils.fireSuccessMessage();

		} catch (Exception ex) {
			WebUtils.fireFaildMessage();

		} finally {
			WebUtils.invokeJavaScriptFunction("PF('miscellaneousDialog').hide()");
			activeMiscellaneous = new Miscellaneous();

		}

	}

	public void addNewFlower() {

		try {

			activeflower = emarketFacade.addNewFlowerProduct(activeflower);
			if(flowersList.contains(activeflower)==false)
			{
			flowersList.add(activeflower);
			}
			WebUtils.fireSuccessMessage();

		} catch (Exception ex) {
			WebUtils.fireFaildMessage();

		} finally {
			WebUtils.invokeJavaScriptFunction("PF('flowerDialog').hide()");
			activeflower = new Flower();

		}

	}

	public Flower getActiveflower() {
		return activeflower;
	}

	public void setActiveflower(Flower activeflower) {
		this.activeflower = activeflower;
	}

	public Honey getActiveHoney() {
		return activeHoney;
	}

	public void setActiveHoney(Honey activeHoney) {
		this.activeHoney = activeHoney;
	}

	public Wax getActiveWax() {
		return activeWax;
	}

	public void setActiveWax(Wax activeWax) {
		this.activeWax = activeWax;
	}

	public Miscellaneous getActiveMiscellaneous() {
		return activeMiscellaneous;
	}

	public void setActiveMiscellaneous(Miscellaneous activeMiscellaneous) {
		this.activeMiscellaneous = activeMiscellaneous;
	}

	public Flower getFlowerType() {
		return flowerType;
	}

	public void setFlowerType(Flower flowerType) {
		this.flowerType = flowerType;
	}

	public void edit(Editable editable) {
		editable.setEditMode(true);

		if (editable instanceof Honey) {
			activeHoney = (Honey) editable;
			WebUtils.invokeJavaScriptFunction("PF('honeyDialog').show();");
		} else if (editable instanceof Wax) { 
			activeWax = (Wax) editable;

			WebUtils.invokeJavaScriptFunction(" PF('waxDialog').show();");

		} else if (editable instanceof Miscellaneous) {
			activeMiscellaneous = (Miscellaneous) editable;
			WebUtils.invokeJavaScriptFunction(" PF('miscellaneousDialog').show();");

		} else if (editable instanceof Flower) {
			activeflower = (Flower) editable;
			WebUtils.invokeJavaScriptFunction("PF('flowerDialog').show();");

		}
	}
	
	
	public void cancel() {

			activeHoney = new Honey();
			WebUtils.invokeJavaScriptFunction("PF('honeyDialog').hide();");
		
			activeWax = new Wax();

			WebUtils.invokeJavaScriptFunction(" PF('waxDialog').hide();");

			activeMiscellaneous = new Miscellaneous();
			WebUtils.invokeJavaScriptFunction(" PF('miscellaneousDialog').hide();");

			activeflower = new Flower() ; 
			WebUtils.invokeJavaScriptFunction("PF('flowerDialog').hide();");

		
	}
	
	public void refresh()
	{
	

		activeMiscellaneous = new Miscellaneous();

		activeflower = new Flower() ; 

	}
	
	
	public void refreshAndShowHoneyDialog()
	{
		activeHoney = new Honey(); 
		WebUtils.invokeJavaScriptFunction("PF('honeyDialog').show();");

	}
	
	public void refreshAndShowWaxDialog()
	{
		activeWax = new Wax();
		WebUtils.invokeJavaScriptFunction("PF('waxDialog').show();");
	}
	
	public void refreshAndShowMiscellaneousDialog()
	{
		activeMiscellaneous = new Miscellaneous();
		WebUtils.invokeJavaScriptFunction("PF('miscellaneousDialog').show();");
	}
	
	public void refreshAndShowFlowersDialog()
	{
		activeflower = new Flower();
		WebUtils.invokeJavaScriptFunction("PF('flowerDialog').show();");

	}
}
