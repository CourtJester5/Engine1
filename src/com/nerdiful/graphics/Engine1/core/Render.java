package com.nerdiful.graphics.Engine1.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Render
{
	private Screen screen;
	
	Graphics2D graphics;
	BufferedImage image;
	
	public Render()
	{
		screen = new Screen();
		
		image = new BufferedImage(screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = image.createGraphics();
		
		screen.setImage(image);
	}
	
	
	private void flush()
	{
		graphics.setPaint(Color.WHITE);
		graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
	}
	
	public void render()
	{
		flush();
		
		graphics.setPaint(Color.black);
		
		screen.setImage(image);
		screen.repaint();
		
		screen.repaint();
	}
}
