package com.wwc.test.multi.common.test;

import com.wwc.test.multi.common.TaskExcutor;
import com.wwc.test.multi.common.TaskExcutorParam;

public class MyTaskParamExcutor implements TaskExcutor{

	@Override
	public void excute(TaskExcutorParam param) {
		MyTaskParam taskParam=(MyTaskParam) param;
		try {
			String threadName=Thread.currentThread().getName();
			Thread.currentThread().sleep(taskParam.getSeconds()*10000);
			System.err.println("线程=="+threadName+"执行完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
