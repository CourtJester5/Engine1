package com.nerdiful.graphics.Engine1.objects;

import java.util.Vector;

public class Mesh
{
	private String name = null;
	private Vector position;
	private Vector rotation;
	private Point3D[] vertices;
	
	public Mesh(String name, Point3D[] verts)
	{
		this.name = name;
		vertices = verts;
	}
	
	public Point3D[] getPoints()
	{
		return vertices;
	}
}
