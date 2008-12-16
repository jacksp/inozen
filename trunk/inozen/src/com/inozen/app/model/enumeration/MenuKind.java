package com.inozen.app.model.enumeration;

import java.util.Arrays;

import com.inozen.framework.enumeration.AbstractType;
import com.inozen.framework.enumeration.Pair;

public class MenuKind extends AbstractType {
	public static final int TOP = 10;
	public static final int LEFT = 20;
	public static final int INNER = 30;
	
	public MenuKind() {
		super(Arrays.asList(
				new Pair(TOP, "���"), 
				new Pair(LEFT, "����"),
				new Pair(INNER, "����"))
		);
	}
	
	private static MenuKind menuKind = new MenuKind();
	
	public static MenuKind getInstance() {
		return menuKind;
	}
}
