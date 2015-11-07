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
		public static Color hover;
		public static Color focus;
		public static int fontSize;
		static {
			Factory.reset();
		}

		public static ButtonView make(String text, Calculator model)
		{
			ButtonView button = new ButtonView(text, Factory.fontSize, Factory.background, Factory.foreground, Factory.hover, Factory.focus);
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
			Factory.hover = null;
			Factory.focus = null;
			Factory.fontSize = 25;
		}
	}

	public Color background;
	public Color foreground;
	public Color hover;
	public Color focus;

	public ButtonView(String text, int fontSize, Color background, Color foreground, Color hover, Color focus)
	{
		this.background = background;
		this.foreground = foreground;
		this.hover = hover;
		this.focus = focus;

		this.setText(text);

		this.setStyle(fontSize);
	}

	private void setStyle(int fontSize)
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
			g.setColor(focus == null ? getBackground().darker() : focus);
		else if (getModel().isRollover())
			g.setColor(hover == null ? getBackground().brighter() : hover);
		else
			g.setColor(background);

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
