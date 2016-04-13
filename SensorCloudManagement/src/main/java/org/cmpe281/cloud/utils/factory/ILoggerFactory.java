package org.cmpe281.cloud.utils.factory;

/**
 * 
 * @author Vaishampayan Reddy
 *
 */
public interface ILoggerFactory {
	/**
	 * Get logger object with the given name
	 * @param loggerName - name of the logger
	 * @return ILogger object
	 */
	ILogger getLogger(String loggerName);
}
