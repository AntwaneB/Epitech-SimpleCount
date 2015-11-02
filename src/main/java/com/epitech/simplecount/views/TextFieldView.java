package com.epitech.simplecount.views;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TextFieldView extends JTextField implements Observer
{
	public TextFieldView()
	{
		this.setText("0");

		this.setFont(new Font("Arial", Font.PLAIN, 40));
		this.setHorizontalAlignment(JTextField.RIGHT);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 10, 20, 10));
		this.setEditable(false);
		this.setBackground(new Color(0xf2f2f2));
	}

	public void update(Observable o, Object arg)
	{

	}
}
