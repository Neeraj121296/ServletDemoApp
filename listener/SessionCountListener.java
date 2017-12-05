package com.srivastava.onlineapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCountListener
 *
 */
@WebListener
public class SessionCountListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
private static int counter;
	
	public static int getCounter(){
		return counter;
	}
    public SessionCountListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	counter++;
    	System.out.println("Session Created.. "+counter);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	if(counter>0){
    		counter--;
        
    	}
    	System.out.println("Session Destroy "+counter);	
         // TODO Auto-generated method stub
    }
    public void contextDestroyed(ServletContextEvent arg0)  { 
        // TODO Auto-generated method stub
   }

	/**
    * @see ServletContextListener#contextInitialized(ServletContextEvent)
    */
   public void contextInitialized(ServletContextEvent arg0)  { 
        // TODO Auto-generated method stub
   		for(int i = 1; i<=100; i++){
   			try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
   			System.out.println("Server is Doing Caching "+i);
   		}
   
	
}
}
