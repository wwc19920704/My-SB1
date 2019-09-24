package com.wwc.test.multi.common.test;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.wwc.test.multi.common.Task;

public class TestMain {
	/**
	 * 	线程池
	 */
	private  static ThreadPoolExecutor threadPool= new ThreadPoolExecutor(50, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	
	public static void main(String[] args) {
		MyTaskParamExcutor excutor=new MyTaskParamExcutor();
		//任务个数
		Integer taskCounts=2500;
		long start=new Date().getTime();
		for (int i = 0; i < taskCounts; i++) {
			//实例化任务和,任务参数,并且将任务放入线程
			MyTaskParam param=new MyTaskParam();
			param.setSeconds(6);
			Task task=new Task();
			task.setExcuteParam(param);
			task.setExcutor(excutor);
			//当所有的任务被放入队列时，线程池才将线程开启，并run对应的任务
			threadPool.execute(task);
		}
		 //这里是不再增加新任务，等待执行的任务不受影响 
		threadPool.shutdown();
		try {
            boolean loop = true;
            do {//等待所有任务完成 
//                loop = !threadPool.awaitTermination(5, TimeUnit.HOURS); //阻塞，直到线程池里所有任务结束
            	//当所有的任务执行完成以后才会退出
            	loop=(Task.successNum.get()>=taskCounts)?false:true;
            	Thread.currentThread().sleep(60000);
            	System.err.println("已经执行完成任务个数=="+Task.successNum.get()+",剩余="+(taskCounts-Task.successNum.get()));
            } while(loop);
        } catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		long end=new Date().getTime();
		System.err.println("总共耗时=="+(end-start));
	}
}
