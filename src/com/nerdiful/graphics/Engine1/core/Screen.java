package com.nerdiful.graphics.Engine1.core;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Screen extends JFrame
{
	private static final String TITLE = "3D Engine V_1";
	private static final int WINDOW_WIDTH = 1080;
	private static final int WINDOW_HEIGHT = 720;
	
	private JPanel canvas;
	private Graphics2D graphics;
	
	private BufferedImage image;
	
	public Screen()
	{
		super(TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocation(300, 150);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		graphics = (Graphics2D) g;
		graphics.drawImage(image, 0, 0, this);
	}
	
	public void setImage(BufferedImage image)
	{
		this.image = image;
	}
	
	public static int getWindowWidth()
	{
		return WINDOW_WIDTH;
	}
	
	public static int getWindowHeight()
	{
		return WINDOW_HEIGHT;
	}
	
	public JPanel getCanvas()
	{
		return canvas;
	}
}
