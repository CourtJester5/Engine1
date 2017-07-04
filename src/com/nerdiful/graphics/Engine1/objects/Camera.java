package com.nerdiful.graphics.Engine1.objects;

import java.util.Vector;

public class Camera
{
	private Point3D position = new Point3D(-10, 0, 0);
	private Point3D rotation = new Point3D(0, 0, 0);
	
	
	
	public Point3D getPosition()
	{
		return position;
	}
	
	public void move(int x, int y, int z)
	{
		position.add(x, y, z);
	}
}
