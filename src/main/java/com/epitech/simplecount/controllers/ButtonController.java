package com.epitech.simplecount.controllers;

import com.epitech.simplecount.models.Calculator;
import com.epitech.simplecount.models.Token;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener
{
	private Calculator model;

	public ButtonController(Calculator model)
	{
		this.model = model;
	}

	public void actionPerformed(ActionEvent event)
	{
		try {
			if (event.getID() == ActionEvent.ACTION_PERFORMED && Token.isValidToken(event.getActionCommand()))
			{
				Token token = new Token(event.getActionCommand());

				switch (token.getValue()) {
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

					case SQUARE:
					case CUBE:
					case SQRT:
					case COS:
					case SIN:
					case TAN:
					case LOG:
					case EXP:
						this.model.pushFunction(token);
						break;

					default:
						break;
				}
			}
		} catch (Exception e)
		{
			System.out.println("Error occurred: " + e.toString());
		}
	}
}
