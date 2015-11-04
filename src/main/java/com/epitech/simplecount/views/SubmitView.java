package com.epitech.simplecount.views;

import com.epitech.simplecount.controllers.ButtonController;
import com.epitech.simplecount.models.Calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SubmitView extends JButton implements Observer
{
	public static class Factory
	{
		public static SubmitView make(String text, Calculator model)
		{
			SubmitView button = new SubmitView(text);
			button.addActionListener(new ButtonController(model));

			return (button);
		}

		public static SubmitView make(String text, Calculator model, GridBagConstraints constraints, int x, int y)
		{
			constraints.gridx = x;
			constraints.gridy = y;

			SubmitView button = new SubmitView(text);
			button.addActionListener(new ButtonController(model));

			return (button);
		}
	}

	public SubmitView(String text)
	{
		this.setText(text);

		this.setStyle();
	}

	private void setStyle()
	{
		// Managing style
		this.setFont(new Font("Arial", Font.PLAIN, 25));
		this.setBackground(new Color(0xff9000));
		this.setForeground(Color.WHITE);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		super.setContentAreaFilled(false);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		if (getModel().isPressed())
			g.setColor(new Color(0xd67900));
		else if (getModel().isRollover())
			g.setColor(new Color(0xfba433));
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
