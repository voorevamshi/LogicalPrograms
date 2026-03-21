package com.vmc.interview.Tmobile;

final public class Singleton {
	private static final Singleton singleton = null;

	public Singleton getSingleton() {
		if (singleton == null) {
			return new Singleton();
		}
		return null;

	}
}






