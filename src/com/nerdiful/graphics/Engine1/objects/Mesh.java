package com.nerdiful.graphics.Engine1.objects;

import java.util.Vector;

public class Mesh
{
	private String name;
	private Vector position;
	private Vector rotation;
	private Vector[] vertices;
	
	public Mesh(String name, int numVertices)
	{
		this.name = name;
		vertices = new Vector[numVertices];
	}
}
