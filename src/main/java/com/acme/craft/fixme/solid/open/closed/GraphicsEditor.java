package com.acme.craft.fixme.solid.open.closed;

public class GraphicsEditor {
	
	
	public void drawShape(Shape s) {
		if (s instanceof Triangle) {
			Rectangle triangle = (Rectangle) s;
			triangle.draw();;
		} if (s instanceof Circle) {
			Circle circle = (Circle) s;
			circle.draw();
		}
	}

}
