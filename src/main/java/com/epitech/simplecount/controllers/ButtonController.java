package com.epitech.simplecount.controllers;

import com.epitech.simplecount.models.Calculator;
import com.epitech.simplecount.models.Token;
import com.epitech.simplecount.models.Token.Tokens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class ButtonController implements ActionListener
{
	private Calculator model;

	public ButtonController(Calculator model)
	{
		this.model = model;
	}

	public void actionPerformed(ActionEvent event)
	{
		if (event.getID() == ActionEvent.ACTION_PERFORMED)
		{
			Token token = new Token(event.getActionCommand().charAt(0));
			System.out.println("Button pressed : " + token.getCharValue());

			switch (token.getValue())
			{
				case EGAL:
					this.model.compute();
					break;

				case ZERO:
				case ONE:
				case TWO:
				case THREE:
				case FOUR:
				case FIVE:
				case SIX:
				case SEVEN:
				case EIGHT:
				case NINE:
				case DOT:
					this.model.pushNumber(token);
					break;

				case PLUS:
				case MINUS:
				case MULT:
				case DIV:
				case MOD:
					this.model.pushOperator(token);
					break;

				default:
					throw new RuntimeException("Invalid action");
			}
		}
	}
}
