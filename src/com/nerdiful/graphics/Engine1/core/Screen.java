package com.nerdiful.graphics.Engine1.core;

import com.nerdiful.graphics.Engine1.objects.Camera;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Screen extends JFrame
{
	private static final String TITLE = "3D Engine V_1";
	
	public static int width = 1080;
	public static int height = 720;
	
	private BufferedImage image;
	
	public Screen()
	{
		super(TITLE);
		
		add(new JPanel() {
			public void paintComponent(Graphics g)
			{
				super.paintComponents(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.drawImage(image, 0, 0, null);
			}
		});
		
		setLocation(300, 150);
		setSize(width, height);
		setResizable(false);
		setVisible(true);
		/* Full Screen, Decorated
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		width = getWidth();
		height = getHeight();
		*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setImage(BufferedImage image)
	{
		this.image = image;
	}
}
