package com.nerdiful.graphics.Engine1.core;

import com.nerdiful.graphics.Engine1.objects.Camera;
import com.nerdiful.graphics.Engine1.objects.Point3D;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Screen extends JFrame
{
	private static final String TITLE = "3D Engine V_1";
	
	public static int width = 1080;
	public static int height = 720;
	
	private JPanel panel;
	private BufferedImage image;
	
	private int[] axisDelta;
	
	public Screen()
	{
		super(TITLE);
		
		panel = new JPanel() {
			public void paintComponent(Graphics g)
			{
				super.paintComponents(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.drawImage(image, 0, 0, null);
			}
		};
		add(panel);
		
		axisDelta = new int[]{0,0,0,0,0,0};
		keyBindings();
		
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
	
	private void keyBindings()
	{
		addAction("A", new int[]{0, 1});
		addAction("released A", new int[]{0, 0});
		addAction("D", new int[]{1, -1});
		addAction("released D", new int[]{1, 0});
		addAction("W", new int[]{2, 1});
		addAction("released W", new int[]{2, 0});
		addAction("S", new int[]{3, -1});
		addAction("released S", new int[]{3, 0});
		addAction("Q", new int[]{4, 1});
		addAction("released Q", new int[]{4, 0});
		addAction("E", new int[]{5, -1});
		addAction("released E", new int[]{5, 0});
	}
	
	private void addAction(String action, int[] axisMove)
	{
		CameraAction cameraAction = new CameraAction(action, axisMove);
		
		KeyStroke keyStroke = KeyStroke.getKeyStroke(action);
		InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(keyStroke, action);
		panel.getActionMap().put(action, cameraAction);
	}
	
	private class CameraAction extends AbstractAction implements ActionListener
	{
		private int[] axisMove;
		
		public CameraAction(String action, int[] axisMove)
		{
			super(action);
			this.axisMove = axisMove;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			axisDelta[axisMove[0]] = axisMove[1];
			Camera.setDelta(axisDelta);
		}
	}
}
