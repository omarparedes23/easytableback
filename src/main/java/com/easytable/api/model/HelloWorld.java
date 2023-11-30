package com.easytable.api.model;

public class HelloWorld {
	public String value="Hola mundo cruel";

	@Override
	public String toString() {
		return value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
