package com.nerdiful.graphics.Engine1.objects;

public class Point3D
{
	private double[] coordinate;
	
	public Point3D()
	{
		coordinate = new double[] {0, 0, 0};
	}
	
	public Point3D(double x, double y, double z)
	{
		coordinate = new double[] {x, y, z};
	}
	
	public double getX()
	{
		return coordinate[0];
	}
	
	public double getY()
	{
		return coordinate[1];
	}
	
	public double getZ()
	{
		return coordinate[2];
	}
	
	public Point3D add(double x, double y, double z)
	{
		coordinate[0] += x;
		coordinate[1] += y;
		coordinate[2] += z;
		
		return new Point3D(coordinate[0],coordinate[1], coordinate[2]);
	}
	
	public Point3D add(Point3D delta)
	{
		coordinate[0] += delta.getX();
		coordinate[1] += delta.getY();
		coordinate[2] += delta.getZ();
		
		return new Point3D(coordinate[0], coordinate[1], coordinate[2]);
	}
	
	public Point3D multDouble(double delta)
	{
		coordinate[0] *= delta;
		coordinate[1] *= delta;
		coordinate[2] *= delta;
		
		return new Point3D(coordinate[0], coordinate[1], coordinate[2]);
	}
	
	public double[] getPosition()
	{
		return coordinate;
	}
}
