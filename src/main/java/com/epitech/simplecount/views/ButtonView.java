package com.epitech.simplecount.views;

import com.epitech.simplecount.controllers.ButtonController;
import com.epitech.simplecount.models.Calculator;
import com.epitech.simplecount.models.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ButtonView extends JButton implements Observer
{
	public static class Factory
	{
		public static Color background;
		public static Color foreground;
		public static int fontSize;
		static {
			Factory.reset();
		}

		public static ButtonView make(String text, Calculator model)
		{
			ButtonView button = new ButtonView(text, Factory.fontSize, Factory.background, Factory.foreground);
			button.addActionListener(new ButtonController(model));

			return (button);
		}

		public static ButtonView make(String text, Calculator model, GridBagConstraints constraints, int x, int y)
		{
			constraints.gridx = x;
			constraints.gridy = y;

			return (make(text, model));
		}

		public static void reset()
		{
			Factory.background = new Color(Settings.asInt("default_button_background", 16));
			Factory.foreground = new Color(Settings.asInt("default_button_foreground", 16));
			Factory.fontSize = 25;
		}
	}

	public ButtonView(String text, int fontSize, Color background, Color foreground)
	{
		this.setText(text);

		this.setStyle(fontSize, background, foreground);
	}

	private void setStyle(int fontSize, Color background, Color foreground)
	{
		// Managing style
		this.setFont(new Font("Arial", Font.PLAIN, fontSize));
		this.setBackground(background);
		this.setForeground(foreground);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setOpaque(false);
		super.setContentAreaFilled(false);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		if (getModel().isPressed())
			g.setColor(getBackground().darker());
		else if (getModel().isRollover())
			g.setColor(getBackground().brighter());
		else
			g.setColor(getBackground());

		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

	@Override
	public void setContentAreaFilled(boolean b)
	{
	}

	public void update(Observable o, Object arg)
	{

	}
}
