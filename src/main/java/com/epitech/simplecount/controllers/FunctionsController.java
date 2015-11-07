package com.epitech.simplecount.controllers;

import com.epitech.simplecount.models.Calculator;
import com.epitech.simplecount.models.Token;
import com.epitech.simplecount.models.Token.Tokens;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Vector;

public class FunctionsController extends AControlsController
{
	protected static Vector<Token.Tokens> validTokens;
	static {
		Tokens[] values = {
			Tokens.SQUARE,
			Tokens.CUBE,
			Tokens.SQRT,
			Tokens.COS,
			Tokens.SIN,
			Tokens.TAN,
			Tokens.LOG,
			Tokens.EXP
		};
		validTokens = new Vector<>(Arrays.asList(values));
	}

	public FunctionsController(Calculator model)
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
					this.model.pushFunction(token);
			}
		} catch (Exception e)
		{
			System.out.println("Error occurred: " + e.toString());
		}
	}
}
