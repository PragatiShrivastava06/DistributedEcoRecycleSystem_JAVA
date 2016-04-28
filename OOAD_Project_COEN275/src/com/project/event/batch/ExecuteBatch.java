/**
 * @author Pragati Shrivastava
 * @version 1.0
 */
package com.project.event.batch;

import java.util.List;

import com.project.EcoRe.Constant;
import com.project.logic.BackendLogic;

/** This will execute the batch in every 30 seconds 
 */
public class ExecuteBatch {

	BackendLogic logic =  new BackendLogic();
	/*logic to perform batch process(Scheduling) */
	public void executeBatch() 
	{
		
		List<Event> eventList = logic.getCurrentEventList();
		
		for(Event event : eventList){
			/*clear RCM when capacity is above 75 percent*/
			if(Constant.FILLED100P.equalsIgnoreCase(event.getEvent()) ||Constant.FILLED75P.equalsIgnoreCase(event.getEvent()) ){
				logic.clearRCMWeight(event.getRcmId()+"");
			}
			 /*Refill Cash if Cash go below 25 percent*/
			if(Constant.CASH0P.equalsIgnoreCase(event.getEvent()) || Constant.CASH25P.equalsIgnoreCase(event.getEvent())  ){
				logic.setFund(event.getRcmId()+"", Constant.CREDIT_CASH);
			}
			/*Refill Coupon if Coupon go below 25 percent*/
			if(Constant.COUPON0P.equalsIgnoreCase(event.getEvent()) || Constant.COUPON25P.equalsIgnoreCase(event.getEvent())  ){
				logic.setCoupon(event.getRcmId()+"", Constant.CREDIT_COUPON);
			}
			/*deletes row from event table when RCM is emptied or fund is refilled in RCM */
			boolean isDeleted = logic.clearEvent(event.getId());
			if(!isDeleted){
				System.out.println("Need Manual efforts as Event id " + event.getId() +" is not deleted. Please take care.");
			}
		}
	}

}
