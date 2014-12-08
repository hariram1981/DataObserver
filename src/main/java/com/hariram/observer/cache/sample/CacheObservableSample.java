/**
 * 
 */
package com.hariram.observer.cache.sample;

import com.hariram.annotation.AnnotationProcessor;
import com.hariram.annotation.cache.Cache;
import com.hariram.annotation.cache.CacheAnnotationProcessor;
import com.hariram.observer.cache.CacheObservable;

/**
 * @author hariram
 *
 */
public class CacheObservableSample extends CacheObservable {
	@Cache(key="d1",refreshRate=60)
	private String data = "test";

	public CacheObservableSample() {
		//Initially process @Cache
		AnnotationProcessor processor = new CacheAnnotationProcessor();
		processor.process(this);
		//Add observable
		add();
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
		update();
	}
	
}
