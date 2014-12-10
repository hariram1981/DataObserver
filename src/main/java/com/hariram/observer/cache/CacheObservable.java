/**
 * 
 */
package com.hariram.observer.cache;

import java.util.Observable;

/**
 * Observable class that adds observers for cache.
 * 
 * @author hariram
 * 05-Dec-2014
 */
public abstract class CacheObservable extends Observable {
	/**
	 * Add observe to observe this object
	 */
	public void add() {
		addObserver(new CacheObserver(this));
	}
	
	/**
	 * Updates the observer when the observable is changed
	 */
	public void update() {
		setChanged();
		notifyObservers();
	}
}
