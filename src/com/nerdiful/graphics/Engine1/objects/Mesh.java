package com.nerdiful.graphics.Engine1.objects;

import java.awt.Color;
import java.util.Vector;

public class Mesh
{
	private String name = null;
	private Color color = Color.WHITE;
	private Vector position;
	private Vector rotation;
	private Point3D[] vertices;
	
	public Mesh(String name, Point3D[] verts)
	{
		this.name = name;
		vertices = verts;
	}
	
	public Mesh(String name, Point3D[] verts, Color color)
	{
		this.name = name;
		vertices = verts;
		this.color = color;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public Point3D[] getPoints()
	{
		return vertices;
	}
}
