package com.wwc.test.multi.common;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 	线程中的任务
 * @author wwc
 *
 */
public class Task implements Runnable{
	
	/**
	 *	 线程执行的执行器
	 */
	private TaskExcutor excutor;
	
	/**
	 * 	线程执行任务的canshu
	 */
	private TaskExcutorParam excuteParam;
	
	/**
	 * 	已完成数量,保证原子性
	 */
	public static AtomicInteger successNum=new AtomicInteger(0);
	
	public TaskExcutor getExcutor() {
		return excutor;
	}


	public void setExcutor(TaskExcutor excutor) {
		this.excutor = excutor;
	}


	public TaskExcutorParam getExcuteParam() {
		return excuteParam;
	}


	public void setExcuteParam(TaskExcutorParam excuteParam) {
		this.excuteParam = excuteParam;
	}


	@Override
	public void run() {
		try {
			//执行上传文件操作
			excutor.excute(excuteParam);
		}finally {
			//无论成功与否都会自增
			successNum.incrementAndGet();
		}
	}
}
