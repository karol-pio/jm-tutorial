package com.acme.craft.fixme.commons.string;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NameValidator {

	public boolean valid(String name) {
		if (StringUtils.isNotBlank(name)) {
			return true;
		}
		return false;
	}

	public boolean isJohn(String name) {
		String johnName = "John";
		return johnName.equals(name);
	}

	public String validationMessage(String firstName, String lastName, String nick) {
//		String.format() String.format("Hello %1$s, your name is %1$s and the time is %2$t", name, time)
		StringBuilder stBuilder = new StringBuilder();
		stBuilder.append("Provided name is not valid. First name: ");
		stBuilder.append(firstName);
		stBuilder.append(", lastName: ");
		stBuilder.append(lastName);
		stBuilder.append(" nick:");
		stBuilder.append(nick);
		
		return stBuilder.toString();
//		return "Provided name is not valid. First name: " + firstName + ", lastName: " + lastName + " nick:" + nick;
	}

}
