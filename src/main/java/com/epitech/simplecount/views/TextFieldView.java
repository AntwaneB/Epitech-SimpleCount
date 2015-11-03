package com.epitech.simplecount.views;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TextFieldView extends JTextField implements Observer
{
	public static class Factory
	{
		public static TextFieldView make(Observable model, GridBagConstraints constraints, int x, int y)
		{
			constraints.gridx = x;
			constraints.gridy = y;

			return (new TextFieldView(model));
		}
	}

	private Observable model;

	public TextFieldView(Observable model)
	{
		this.model = model;
		this.model.addObserver(this);

		this.setText(this.model.toString());
		this.setStyle();
	}

	private void setStyle()
	{
		this.setFont(new Font("Arial", Font.PLAIN, 40));
		this.setHorizontalAlignment(JTextField.RIGHT);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 10, 20, 10));
		this.setEditable(false);
		this.setBackground(new Color(0xf2f2f2));
	}

	public void update(Observable o, Object arg)
	{
		this.setText(this.model.toString());
	}
}
