/**
 * 
 */
package com.hariram.observer.cache.sample;

import com.hariram.annotation.cache.Cache;
import com.hariram.observer.cache.CacheObservable;

/**
 * @author hariram
 *
 */
public class CacheObservableSample extends CacheObservable {
	@Cache(key="d1",refreshRate=60)
	private String data = "test";

	public CacheObservableSample() {
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
