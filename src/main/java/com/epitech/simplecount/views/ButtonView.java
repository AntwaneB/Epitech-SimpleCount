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
		public static ButtonView make(String text, Calculator model, GridBagConstraints constraints, int x, int y)
		{
			constraints.gridx = x;
			constraints.gridy = y;

			ButtonView button = new ButtonView(text);
			button.addActionListener(new ButtonController(model));

			return (button);
		}
	}

	public ButtonView(String text)
	{
		this.setText(text);

		this.setStyle();
	}

	private void setStyle()
	{
		// Managing style
		this.setFont(new Font("Arial", Font.PLAIN, 25));
		this.setBackground(new Color(0xe6e6e6));
		this.setForeground(Color.BLACK);
		this.setBorderPainted(false);
		this.setFocusPainted(false);

		// Managing hover style
		ButtonView self = this;
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				self.setBackground(new Color(0xcfcfcf));
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				self.setBackground(new Color(0xe6e6e6));
			}
		});
	}

	public void update(Observable o, Object arg)
	{

	}
}
