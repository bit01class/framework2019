package com.bit.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

public class Ex01Action implements Action {
	Logger log=Logger.getLogger("com.bit.action.Ex01Action");
	@Override
	public String execute() throws Exception {
		log.debug("»£√‚");
		return this.SUCCESS;
	}

}
