package com.epitech.simplecount.controllers;

import com.epitech.simplecount.models.Calculator;
import com.epitech.simplecount.models.Token;
import com.epitech.simplecount.models.Token.Tokens;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Vector;

public class NumberController extends AControlsController
{
	protected static Vector<Token.Tokens> validTokens;
	static {
		Tokens[] values = {
			Tokens.ZERO,
			Tokens.ONE,
			Tokens.TWO,
			Tokens.THREE,
			Tokens.FOUR,
			Tokens.FIVE,
			Tokens.SIX,
			Tokens.SEVEN,
			Tokens.EIGHT,
			Tokens.NINE,
			Tokens.DOT,
		};
		validTokens = new Vector<>(Arrays.asList(values));
	}

	public NumberController(Calculator model)
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
					this.model.pushNumber(token);
			}
		} catch (Exception e)
		{
			System.out.println("Error occurred: " + e.toString());
		}
	}
}
