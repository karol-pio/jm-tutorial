package com.acme.craft.fixme.solid.dependency.inversion;

import lombok.Data;

@Data
public class Lamp implements SwitchController{

	private boolean on = false;

	@Override
	public void pressSwitch(Switch sw) {
		if (sw.isPressed()) {
			on = true;
		} else {
			on = false;
		}		
	}
	
}
