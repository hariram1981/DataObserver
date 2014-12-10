package com.hariram.observer.cache;

import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import com.hariram.annotation.AnnotationProcessor;
import com.hariram.annotation.cache.CacheAnnotationProcessor;

/**
 * Cache observer class that observes variables annotated by @Cache
 * 
 * @author hariram
 * date 05-Dec-2014
 */
public class CacheObserver implements Observer {
	CacheObservable cacheObservable = null;
	
	public static final Logger LOGGER = Logger.getLogger(CacheObserver.class);
	
	/**
	 * Parameterized constructor
	 * 
	 * @param cacheObservable object to be observed
	 */
	public CacheObserver(CacheObservable cacheObservable) {
		this.cacheObservable = cacheObservable;
	}
	
	/**
	 * Updates the cache when the observable is changed
	 * 
	 * @param o object that is observed
	 * @param arg arguments for the object
	 */
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
