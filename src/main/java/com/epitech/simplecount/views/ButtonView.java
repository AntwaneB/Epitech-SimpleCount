package com.epitech.simplecount.views;

import com.epitech.simplecount.controllers.ButtonController;
import com.epitech.simplecount.models.Calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ButtonView extends JButton implements Observer
{
	public static class Factory
	{
		public static ButtonView make(String text, Calculator model, int fontSize)
		{
			ButtonView button = new ButtonView(text, fontSize);
			button.addActionListener(new ButtonController(model));

			return (button);
		}
		public static ButtonView make(String text, Calculator model, GridBagConstraints constraints, int x, int y, int fontSize)
		{
			constraints.gridx = x;
			constraints.gridy = y;

			ButtonView button = new ButtonView(text, fontSize);
			button.addActionListener(new ButtonController(model));

			return (button);
		}
	}

	public ButtonView(String text, int fontSize)
	{
		this.setText(text);

		this.setStyle(fontSize);
	}

	private void setStyle(int fontSize)
	{
		// Managing style
		this.setFont(new Font("Arial", Font.PLAIN, fontSize));
		this.setBackground(new Color(0x292929));
		this.setForeground(new Color(0x8e8d9b));
		this.setBorderPainted(false);
		this.setFocusPainted(false);
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
