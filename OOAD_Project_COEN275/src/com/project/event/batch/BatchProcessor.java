/**
 * @author Pragati Shrivastava
 * @version 1.0
 */
package com.project.event.batch;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import com.project.EcoRe.Constant;

public class BatchProcessor {
	
	 /* thread created as a scheduler*/
	/*ScheduledExecutorService scheduler will take a runnable thread and execute periodically*/
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	/* executer object will execute event handling process i.e it will clear RCM when capacity is above 75 percent
													It will also Refill Cash/Coupon if Funds go below 25 percent*/
	ExecuteBatch executer = new ExecuteBatch();

	/** This method executes events periodically
	 * No i/o parameter
	 */
	public void executeEventsPeriodically() 
	{
		final Runnable eventFinder = new Runnable() 
		{
			public void run() {
				System.out
						.println("Logic to find event and execute those events strats");
				executer.executeBatch();//will execute what is written in batch
			}
		};
		/* business logic for event handling(clear RCM,Refill Cash/Coupon)*/
		final ScheduledFuture<?> eventHandler = scheduler.scheduleAtFixedRate(
				eventFinder, Constant.SCHEDULE_AT_FIXEDRATE,
				Constant.SCHEDULE_AT_FIXEDRATE, SECONDS);
		scheduler.schedule(new Runnable() 
		{
			public void run() {
				eventHandler.cancel(true);
			}
		}, 60*60, SECONDS);//scheduler will run for 1 hour
	}
}
