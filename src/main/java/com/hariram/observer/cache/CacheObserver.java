/**
 * 
 */
package com.hariram.observer.cache;

import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import com.hariram.annotation.AnnotationProcessor;
import com.hariram.annotation.cache.CacheAnnotationProcessor;

/**
 * @author hariram
 * date 05-Dec-2014
 */
public class CacheObserver implements Observer {
	CacheObservable cacheObservable = null;
	
	public static final Logger LOGGER = Logger.getLogger(CacheObserver.class);
	
	/**
	 * 
	 * @param cacheObservable
	 */
	public CacheObserver(CacheObservable cacheObservable) {
		this.cacheObservable = cacheObservable;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		LOGGER.info("CacheObserver.update, observable: " + o + ", arg: " + arg);
		if(o == cacheObservable) {
			LOGGER.info("CacheObserver.update, is cacheobservable object - calling cache annotation processor");
			//Update all @Cache variables in the class
			AnnotationProcessor processor = new CacheAnnotationProcessor();
			processor.process(cacheObservable);
			LOGGER.info("CacheObserver.update, cache annotation processing done");
		}
		LOGGER.info("CacheObserver.update, done");
	}
}
