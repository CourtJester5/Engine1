package com.nerdiful.graphics.Engine1.core;

import java.util.ArrayList;
import com.nerdiful.graphics.Engine1.Engine;
import com.nerdiful.graphics.Engine1.objects.Camera;
import com.nerdiful.graphics.Engine1.objects.Mesh;
import com.nerdiful.graphics.Engine1.objects.Point3D;

public class Update
{
	private ArrayList<Mesh> meshes;
	
	private Camera camera;
	private Mesh cube;
	
	public Update(Engine engine)
	{
		camera = new Camera();
		cube = new Mesh("Cube", constructCube());
		
		meshes = new ArrayList<Mesh>();
		meshes.add(cube);
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
	
	public ArrayList<Mesh> getMeshes()
	{
		return meshes;
	}
}
