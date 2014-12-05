/**
 * 
 */
package com.hariram.observer.cache;

import java.util.Observable;

/**
 * @author hariram
 * 05-Dec-2014
 */
public abstract class CacheObservable extends Observable {
	/**
	 * 
	 */
	public void add() {
		addObserver(new CacheObserver(this));
	}
	
	/**
	 * 
	 */
	public void update() {
		setChanged();
		notifyObservers();
	}
}
