package com.mi.dpay.core.mvc;

/**
 * Description:
 * @author 李晓伟 (xwlig@isoftstone.com) <p>iSoftStone</p>
 * @version 1.0 2015-3-5 上午11:40:01 
 */

public class ConsoleBaseController extends AbstractMvcController {
	
	/** The Constant APP_VIEW_FLAG. */
	public static final String APP_VIEW_FLAG = "clouds/console";
	
	/**
	 * Instantiates a new ebiz base mvc controller.
	 */
	public ConsoleBaseController() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ailk.tangram.core.mvc.IMvcAppViewConnector#getAppViewFlag()
	 */
	public String getAppViewFlag() {
		return APP_VIEW_FLAG;
	}


}
