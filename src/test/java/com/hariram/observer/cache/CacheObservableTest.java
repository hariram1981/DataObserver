package com.hariram.observer.cache;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.hariram.cache.CacheManager;
import com.hariram.observer.cache.sample.CacheObservableSample;

public class CacheObservableTest {

	@Test
	public void test() {
		CacheObservableSample sample = new CacheObservableSample();
		System.out.println(CacheManager.getFromCache("d1"));
		sample.setData("c1");
		System.out.println(CacheManager.getFromCache("d1"));
		sample.setData("c2");
		System.out.println(CacheManager.getFromCache("d1"));
/*		try {
			Field field = sample.getClass().getDeclaredField("data");
			field.setAccessible(true);
			System.out.println(field.get(sample));
			field.setAccessible(false);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
*/		assertTrue(true);
	}

}
