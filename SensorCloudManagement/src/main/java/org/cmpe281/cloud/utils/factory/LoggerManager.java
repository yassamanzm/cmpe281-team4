package org.cmpe281.cloud.utils.factory;

 /**
  *  Factory Manager to create various types of log factory .
  *  Right now it supports log4JFactory only. 
  * @author Vaishampayan Reddy
  *
  */

public class LoggerManager
{
 public static ILoggerFactory getLoggerFactory() {
		//right now default to log4j logger
		return new Log4jFactory();
	}
}
