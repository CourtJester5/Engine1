package com.nerdiful.graphics.Engine1.core;
import com.nerdiful.graphics.Engine1.Engine;
import com.nerdiful.graphics.Engine1.objects.Camera;
import com.nerdiful.graphics.Engine1.objects.Mesh;
import com.nerdiful.graphics.Engine1.objects.Point3D;

import java.awt.Color;
import java.util.ArrayList;

public class Update
{
	private ArrayList<Mesh> meshes;
	
	private Camera camera;
	private Mesh cube;
	private Mesh cube2;
	
	public Update(Engine engine)
	{
		camera = new Camera();
		cube = new Mesh("Cube", constructCube());
		//cube2 = new Mesh("Cube2", constructCube2(), Color.BLUE);
		
		meshes = new ArrayList<Mesh>();
		meshes.add(cube);
		//meshes.add(cube2);
		meshes.add(new Mesh("Origin", new Point3D[] {new Point3D(0,0,0)}, Color.RED));
	}
	
	public void update()
	{
		
	}
	
	public Camera getCamera()
	{
		return camera;
	}
	
	private Point3D[] constructCube()
	{
		Point3D[] verts = new Point3D[8];
		int vert = 0;
		
		for(int x=-1; x<=1; x+=2)
		{
			for(int y=-1; y<=1; y+=2)
			{
				for(int z=-1; z<=1; z+=2)
				{
					verts[vert] = new Point3D(x, y, z);
					vert++;
				}
			}
		}
		return verts;
	}
	
	private Point3D[] constructCube2()
	{
		Point3D[] verts = new Point3D[8];
		int vert = 0;
		
		for(int x=-1; x<=1; x+=2)
		{
			for(int y=-1; y<=1; y+=2)
			{
				for(int z=-1; z<=1; z+=2)
				{
					verts[vert] = new Point3D((double)x*5/6, (double)y*5/6, (double)z*5/6);
					vert++;
				}
			}
		}
		return verts;
	}
	
	public ArrayList<Mesh> getMeshes()
	{
		return meshes;
	}
}
