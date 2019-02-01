package com.tcs.rbc.appium.poc.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class LogManager {
	private static LogManager logManager;
	private Logger log;
	
	private LogManager(){
		updateLog4jConfiguration();
	}
	
	public LogManager(Logger logger) {
		this();
		setLogger(logger);
	}

	private void setLogger(Logger log)
	{
		this.log = log;
	}
	
	public static LogManager getLogger(){
		if (logManager == null)
			logManager = new LogManager(Logger.getLogger(LogManager.class));
		
		return logManager;
	}
	
	public void Log(Object msg, LogLevel logLevel){
		switch(logLevel){
			case DEBUG:
				log.debug(Thread.currentThread().getName()+" :  "+msg.toString());
				break;
			case INFO:
				log.info(Thread.currentThread().getName()+" :  "+msg.toString());
				break;
			case WARNING:
				log.warn(Thread.currentThread().getName()+" :  "+msg.toString());
				break;
			case ERROR:
				log.error(Thread.currentThread().getName()+" :  "+msg.toString());
				break;
			case FATAL:
				log.fatal(Thread.currentThread().getName()+" :  ");
				log.fatal(msg);

				break;
			default:
				
		}
	}
	private void updateLog4jConfiguration() { 
	    Properties props = new Properties(); 
	    try { 
	        InputStream configStream = new FileInputStream(new File(System.getProperty("user.dir")  + "/resources/Config/log4j.properties")); 
	        props.load(configStream); 
	        configStream.close(); 
	    } catch (IOException e) { 
	        System.out.println("Errornot laod configuration file "); 
	    } 
	    props.setProperty("log4j.appender.FILE.file", System.getProperty("user.dir")+"/log/log.log"); 
	    org.apache.log4j.LogManager.resetConfiguration(); 
	    PropertyConfigurator.configure(props); 
	}

}
