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
	
	private static double speed = .05;
	private static Point3D move;
	
	public Camera()
	{
		position = new Point3D(1.5, .75, -7.5);
		rotation = new Point3D(0, 0, 0);
		projectionPlane = new Rectangle2D.Double(position.getPosition()[0]-PROJ_PLANE_W/2,
				position.getPosition()[1]-PROJ_PLANE_H / 2, PROJ_PLANE_W, PROJ_PLANE_H);
		
		move = new Point3D();
	}
	
	public static void setDelta(int[] axisDelta)
	{
		Point3D temp = new Point3D();
		temp.getPosition()[0] += axisDelta[0] + axisDelta[1];
		temp.getPosition()[1] += axisDelta[2] + axisDelta[3];
		temp.getPosition()[2] += axisDelta[4] + axisDelta[5];
		
		move = temp.multDouble(speed);
	}
	
	public void update()
	{
		position.add(move);
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
