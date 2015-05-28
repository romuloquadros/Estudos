package com.estudos.refactor;

import java.util.List;

public class CollectionUse {

	private static final String TYPE = "A";

	protected void markAsCheckedIfSameValueWithTwoFors(List<MyClass> myClasses) {
		for (MyClass myClass : myClasses) {
			if (myClass.getType().equals(TYPE)) {
				for (MyClass clazz : myClasses) {
					if (clazz.getValue().equals(myClass.getValue())) {
						clazz.setChecked(Boolean.TRUE);
					}
				}
			}
		}
	}

}
