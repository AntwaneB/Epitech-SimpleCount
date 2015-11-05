package com.epitech.simplecount.controllers;

import com.epitech.simplecount.models.Calculator;
import com.epitech.simplecount.views.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener
{
	private Calculator model;

	public CalculatorController()
	{
		this.model = new Calculator();

		CalculatorView view = new CalculatorView(this.model);
	}

	public void actionPerformed(ActionEvent event)
	{
		if (event.getID() == ActionEvent.ACTION_PERFORMED)
		{
			System.out.println(event.getActionCommand());
		}
	}
}
