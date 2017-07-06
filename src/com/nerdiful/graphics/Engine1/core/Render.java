package com.nerdiful.graphics.Engine1.core;

import com.nerdiful.graphics.Engine1.Engine;
import com.nerdiful.graphics.Engine1.objects.Camera;
import com.nerdiful.graphics.Engine1.objects.Mesh;
import com.nerdiful.graphics.Engine1.objects.Point3D;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Render
{
	private Screen screen;
	private Update update;
	
	private Camera camera;	
	private Graphics2D graphics;
	private BufferedImage image;
	
	public Render(Engine engine)
	{
		screen = new Screen();
		update = engine.getUpdate();
		camera = update.getCamera();
		
		image = new BufferedImage(screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = image.createGraphics();
	}
	
	public void render()
	{
		flush();
		drawPoints();
		screen.setImage(image);
		screen.repaint();
	}
	
	private void flush()
	{
		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
	}
	
	private void drawPoints()
	{
		ArrayList<Mesh> meshes = update.getMeshes();
		for(int i=0; i<meshes.size(); i++)
		{
			graphics.setColor(meshes.get(i).getColor());
			Point3D[] meshPoints = meshes.get(i).getPoints();
			for(int j=0; j<meshPoints.length; j++)
			{
				//tempProjPlane = (Plane W, Plane H, Plane Dist to Camera)
				Rectangle2D projPlane = camera.getProjPlane();
				double positionRatio = camera.getProjPlaneDist() / (meshPoints[j].getPosition()[2] - camera.getZPos());
				
				double pixelXPos = (meshPoints[j].getPosition()[0] - camera.getXPos()) * positionRatio;
				double pixelYPos = (meshPoints[j].getPosition()[1] + camera.getYPos()) * positionRatio;
				pixelXPos = (pixelXPos / (projPlane.getWidth()/2)) * Screen.width/2 + Screen.width/2;
				pixelYPos = (pixelYPos / (projPlane.getHeight()/2)) * Screen.height/2 + Screen.height/2;
				
				graphics.fillRect((int)pixelXPos, (int)pixelYPos, 3, 3);
			}
		}
	}
}
