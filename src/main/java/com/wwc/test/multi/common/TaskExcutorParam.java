package com.wwc.test.multi.common;

import java.util.Date;

/**
 *	 线程执行参数
 * @author wwc
 *
 */
public class TaskExcutorParam {

	private Date createTime;
	
	private Date updateTime;
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
