package com.nerdiful.graphics.Engine1.objects;

import com.nerdiful.graphics.Engine1.core.Screen;

import java.awt.geom.Rectangle2D;
import java.util.Vector;

public class Camera
{
	private final double PROJ_PLANE_W = 1;
	private final double PROJ_PLANE_H = (PROJ_PLANE_W * (double) Screen.height) / (double) Screen.width;
	
	private Point3D position;
	private Point3D rotation;
	private Rectangle2D projectionPlane;
	
	private double projPlaneDist = 0.5;
	
	public Camera()
	{
		position = new Point3D(1.5, .5, -5);
		rotation = new Point3D(0, 0, 0);
		projectionPlane = new Rectangle2D.Double(position.getPosition()[0]-PROJ_PLANE_W/2,
				position.getPosition()[1]-PROJ_PLANE_H / 2, PROJ_PLANE_W, PROJ_PLANE_H);
	}
	
	public void move(int x, int y, int z)
	{
		position.add(x, y, z);
	}
	
	public Point3D getPosition()
	{
		return position;
	}
	
	public double getXPos()
	{
		return position.getPosition()[0];
	}
	
	public double getYPos()
	{
		return position.getPosition()[1];
	}
	
	public double getZPos()
	{
		return position.getPosition()[2];
	}
	
	public Rectangle2D getProjPlane()
	{
		return projectionPlane;
	}
	
	public double getProjPlaneDist()
	{
		return projPlaneDist;
	}
}
