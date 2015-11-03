package com.epitech.simplecount.models;

import java.util.List;
import java.util.Vector;

import com.epitech.simplecount.models.Token.Tokens;

public class Number extends AExpressionPart
{
	private List<Token> tokens = new Vector<>();
	private boolean decimal = false;

	public Number()
	{
		this.type = Type.OPERAND;
	}

	public Number(String value)
	{
		this.type = Type.OPERAND;

		for (char c : value.toCharArray())
			this.pushToken(new Token(c));
	}

	public void pushToken(Token token)
	{
		if (token.is(Tokens.DOT) && this.decimal)
			return;

		if (token.is(Tokens.DOT))
			this.decimal = true;

		if (token.is(Tokens.DOT) && this.tokens.size() == 0)
			this.tokens.add(new Token('0'));

		this.tokens.add(new Token(token));

		setChanged();
		notifyObservers();
	}

	public String toString()
	{
		String strValue = "";

		for (Token t: this.tokens)
			strValue += t.getCharValue();

		if (!strValue.equals("0"))
		{
			strValue = strValue.replaceFirst("^0+0(?!.[0-9]*)", "");
		}

		return (strValue);
	}

	public Number epur()
	{
		while (tokens.get(0).getValue() == Tokens.ZERO)
			tokens.remove(0);

		while (tokens.get(tokens.size() - 1).getValue() == Tokens.ZERO)
			tokens.remove(tokens.size() - 1);

		if (tokens.get(tokens.size() - 1).getValue() == Tokens.DOT)
			tokens.remove(tokens.size() - 1);

		if (tokens.size() == 0 || tokens.get(0).getValue() == Tokens.DOT)
			tokens.add(0, new Token('0'));

		return (this);
	}

	public boolean isDecimal()
	{
		return (decimal);
	}
}
