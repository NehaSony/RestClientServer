package com.smsc.data.in.smscData.model;

import java.io.Serializable;

public class ApplicationData implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6560910625848398997L;
	
	
	private Boolean DELIVER_SM;
	
	public ApplicationData() {}

	public ApplicationData(Boolean dELIVER_SM) {
		super();
		DELIVER_SM = dELIVER_SM;
	}


	/**
	 * @return the dELIVER_SM
	 */
	public Boolean getDELIVER_SM() {
		return DELIVER_SM;
	}


	/**
	 * @param dELIVER_SM the dELIVER_SM to set
	 */
	public void setDELIVER_SM(Boolean dELIVER_SM) {
		DELIVER_SM = dELIVER_SM;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ApplicationData [DELIVER_SM=" + DELIVER_SM + "]";
	}

}
