package com.nerdiful.graphics.Engine1.core;

import com.nerdiful.graphics.Engine1.Engine;
import com.nerdiful.graphics.Engine1.objects.Camera;
import com.nerdiful.graphics.Engine1.objects.Mesh;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Render
{
	private Screen screen;
	private Update update;
	
	private Camera camera;	
	private Graphics2D graphics;
	private BufferedImage image;
	
	private int[] pixels;
	
	public Render(Engine engine)
	{
		screen = new Screen();
		update = engine.getUpdate();
		camera = update.getCamera();
		
		image = new BufferedImage(screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = image.createGraphics();
		
		pixels = new int[screen.getWidth() * screen.getHeight()];
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
		graphics.setPaint(Color.DARK_GRAY);
		graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
	}
	
	private void drawPoints()
	{
		ArrayList<Mesh> meshes = update.getMeshes();
	}
}
