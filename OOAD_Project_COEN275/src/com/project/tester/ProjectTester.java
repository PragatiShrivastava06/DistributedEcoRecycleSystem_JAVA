/**
 * @author Pragati Shrivastava and Rachana Deolikar
 * @version 1.0
 */
package com.project.tester;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.project.event.batch.BatchProcessor;
import com.project.ui.RMOSDisplay;
import com.project.ui.Vending;

/** The entry main() method */
public class ProjectTester 
{
	public static void main(String[] args) 
	{
	 // Run GUI codes on the Event-Dispatcher Thread for thread safety
		SwingUtilities.invokeLater(new Runnable() 
		{
		      @Override
		      public void run() 
		      {	
		    	  // open RMOS UI
		    	RMOSDisplay rmosdisplay = new RMOSDisplay();
		  		rmosdisplay.setVisible(true) ;
		      }
		   });		
		
		BatchProcessor bp = new BatchProcessor();
		/** scheduler starts batch processing for clearing RCM and also Updating Funds (Pull Model)*/
		bp.executeEventsPeriodically();
		
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	// open RCM UI
                Vending vend = new Vending("RCM");
                vend.setSize(800, 800);
                vend.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                vend.setVisible(true);
		vend.setFocusable(true);
		
            }
        });
	}
}

