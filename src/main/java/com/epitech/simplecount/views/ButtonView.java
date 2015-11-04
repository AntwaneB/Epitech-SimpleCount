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
		public static ButtonView make(String text, Calculator model)
		{
			ButtonView button = new ButtonView(text);
			button.addActionListener(new ButtonController(model));

			return (button);
		}
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
		int fontSize = this.getPreferredSize().width / 3;
		System.out.println(this.getText() + " = " + this.getPreferredSize().width + "px");

		this.setFont(new Font("Arial", Font.PLAIN, fontSize));
		this.setBackground(new Color(0x292929));
		this.setForeground(new Color(0x8e8d9b));
		this.setBorderPainted(false);
		this.setFocusPainted(false);

		// Managing hover style
		ButtonView self = this;
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				self.setBackground(new Color(0x333333));
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				self.setBackground(new Color(0x292929));
			}
		});
	}

	public void update(Observable o, Object arg)
	{

	}
}
