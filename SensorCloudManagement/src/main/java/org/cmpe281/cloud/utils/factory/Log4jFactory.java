package org.cmpe281.cloud.utils.factory;

/**
 * 
 * @author Vaishampayan Reddy
 *
 */
public class Log4jFactory implements ILoggerFactory {

	public ILogger getLogger(String loggerName) {		
		return new Log4jLogger(loggerName);
	}
}
