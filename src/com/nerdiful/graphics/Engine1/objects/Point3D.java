package com.nerdiful.graphics.Engine1.objects;

public class Point3D
{
	private double[] coordinate = new double[3];
	
	public Point3D(double x, double y, double z)
	{
		coordinate[0] = x;
		coordinate[1] = y;
		coordinate[2] = z;
	}
	
	public void add(double x, double y, double z)
	{
		coordinate[0] += x;
		coordinate[1] += y;
		coordinate[2] += z;
	}
	
	public double[] getPosition()
	{
		return coordinate;
	}
}
