package com.acme.craft.fixme.solid.dependency.inversion;

public class Switch {

	private Lamp lamp;
	private boolean pressed;

	public Switch(Lamp lamp) {
		this.lamp = lamp;
	}

	public boolean isPressed() {
		return pressed;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

//	private void pressSwitch() {
//		pressed = !pressed;
//		if (pressed) {
//			lamp.setOn(true);
//		} else {
//			lamp.setOn(false);
//		}
//	}

}
