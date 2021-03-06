package com.epitech.simplecount.controllers;

import com.epitech.simplecount.models.Calculator;
import com.epitech.simplecount.models.Token;
import com.epitech.simplecount.models.Token.Tokens;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Vector;

public class OperationsController extends AControlsController
{
	protected static Vector<Token.Tokens> validTokens;
	static {
		Tokens[] values = {
			Tokens.PLUS,
			Tokens.MINUS,
			Tokens.MULT,
			Tokens.DIV,
			Tokens.MOD,
		};
		validTokens = new Vector<>(Arrays.asList(values));
	}

	public OperationsController(Calculator model)
	{
		this.model = model;
	}

	public void actionPerformed(ActionEvent event)
	{
		try {
			if (event.getID() == ActionEvent.ACTION_PERFORMED && Token.isValidToken(event.getActionCommand()))
			{
				Token token = new Token(event.getActionCommand());

				if (validTokens.contains(token.getValue()))
					this.model.pushOperator(token);
			}
		} catch (Exception e)
		{
			System.out.println("Error occurred: " + e.toString());
		}
	}
}
