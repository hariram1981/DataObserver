/**
 * 
 */
package com.hariram.observer.cache;

import java.util.Observable;
import java.util.Observer;

import com.hariram.annotation.AnnotationProcessor;
import com.hariram.annotation.cache.CacheAnnotationProcessor;

/**
 * @author hariram
 * date 05-Dec-2014
 */
public class CacheObserver implements Observer {
	CacheObservable cacheObservable = null;
	
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
		if(o == cacheObservable) {
			//Update all @Cache variables in the class
			//System.out.println("update here");
			AnnotationProcessor processor = new CacheAnnotationProcessor();
			System.out.println(cacheObservable.getClass());
			processor.process(cacheObservable);
		}
	}
}
