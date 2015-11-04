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

		// Managing hover style
		SubmitView self = this;
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				self.setBackground(new Color(0xffa734));
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				self.setBackground(new Color(0xff9000));
			}
		});
	}

	public void update(Observable o, Object arg)
	{

	}
}
