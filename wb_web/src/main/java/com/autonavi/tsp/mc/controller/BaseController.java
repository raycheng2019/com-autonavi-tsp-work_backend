/**
 * 
 */
package com.autonavi.tsp.mc.controller;

import org.apache.commons.lang.StringUtils;

/**
 * @author weichuanbo
 */
public class BaseController {  
	
	protected int pageSize = 10;
	
	protected int pageIndex = 1;
	
	protected String DEFAULT_PAGE="index";

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/***
	 * 描述：验证分页参数
	 * @param pageIndex
	 * @param pagesize
	 * @author: allen.yin
	 * @日期: 2014年10月17日 下午2:34:16
	 */
	public void validate(String pageIndex, String pagesize) {
		if (StringUtils.isNotBlank(pageIndex)) {
			int p = new Integer(pageIndex);
			if (p > 0) {
				setPageIndex(p);
			}
		}
		if (StringUtils.isNotBlank(pagesize)) {
			int psize = new Integer(pagesize);
			if (psize > 0) {
				setPageSize(psize);
			}
		}
	}
	/***
	 * 描述：验证分页参数
	 * @param pageIndex
	 * @param pagesize
	 * @author: allen.yin
	 * @日期: 2014年10月17日 下午2:34:16
	 */
	public void validate(int pageIndex, int pagesize) {
		if (pageIndex > 0) {
			setPageIndex(pageIndex);
		}
		if (pagesize > 0) {
			setPageSize(pagesize);
		}
	} 
}
