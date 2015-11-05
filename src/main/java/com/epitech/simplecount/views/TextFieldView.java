package com.epitech.simplecount.views;

import com.epitech.simplecount.models.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TextFieldView extends JTextField implements Observer
{
	public static class Factory
	{
		public static Color background;
		public static Color foreground;
		public static int fontSize;
		static {
			Factory.reset();
		}

		public static TextFieldView make(Observable model)
		{
			return (new TextFieldView(model, Factory.fontSize, Factory.background, Factory.foreground));
		}

		public static TextFieldView make(Observable model, GridBagConstraints constraints, int x, int y)
		{
			constraints.gridx = x;
			constraints.gridy = y;

			return (Factory.make(model));
		}

		public static void reset()
		{
			Factory.background = new Color(Settings.asInt("result_background", 16));
			Factory.foreground = new Color(Settings.asInt("result_foreground", 16));
			Factory.fontSize = 40;
		}
	}

	private Observable model;
	private int baseFontSize;

	public TextFieldView(Observable model, int fontSize, Color background, Color foreground)
	{
		this.model = model;
		this.model.addObserver(this);

		this.baseFontSize = fontSize;

		this.setText(this.model.toString());
		this.setStyle(fontSize, background, foreground);
	}

	private void setStyle(int fontSize, Color background, Color foreground)
	{
		this.setFont(new Font("Arial", Font.PLAIN, fontSize));
		this.setBackground(background);
		this.setForeground(foreground);
		this.setHorizontalAlignment(JTextField.LEFT);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
		this.setEditable(false);
	}

	public void update(Observable o, Object arg)
	{
		String newText = this.model.toString();
		this.setText(newText);

		if (newText.length() > 8)
			this.setFont(new Font("Arial", Font.PLAIN, this.baseFontSize - (newText.length() > 28 ? 28 : newText.length())));
		else if (this.getFont().getSize() < this.baseFontSize)
			this.setFont(new Font("Arial", Font.PLAIN, this.baseFontSize));
	}
}
