package com.sd.training.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Bic;
import com.sd.training.struts2.service.BicService;
import com.sd.training.struts2.serviceImpl.BicServiceImpl;

public class BicAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String BIC_FORM="bicForm";
	
	private Bic bic;
	private String message;
		public Bic getBic() {
			return bic;
		}
		public void setBic(Bic bic) {
			this.bic = bic;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		public String save() {
			BicService bicService=new BicServiceImpl();
			Bic bicResponse=bicService.save(bic);
			if( bicResponse!= null){
				setMessage("User data saved successfully.");
			}else{
				setMessage("Error while saving.");
			}
			return BIC_FORM;
		}
	

}
