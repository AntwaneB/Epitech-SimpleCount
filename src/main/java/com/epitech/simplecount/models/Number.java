package com.epitech.simplecount.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
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

	public Number(Number number)
	{
		this.type = Type.OPERAND;

		for (Token t: number.tokens)
			this.pushToken(t);
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

		strValue = strValue.replaceAll("^0+", "0");
		strValue = strValue.replaceAll("^0+(?=\\d+)", "");

		if (strValue.length() == 0)
			strValue = "0";

		return (strValue);
	}

	public String getEpured()
	{
		String result = new BigDecimal(this.toString()).round(new MathContext(Settings.asInt("max_decimals") + 1, RoundingMode.HALF_EVEN)).toString();

		if (this.decimal)
		{
			while (result.length() > 1 && result.charAt(result.length() - 1) == '0')
				result = result.substring(0, result.length() - 1);
		}
		if (result.charAt(result.length() - 1) == '.')
			result = result.substring(0, result.length() - 1);

		return (result);
	}

	public boolean isDecimal()
	{
		return (decimal);
	}
}
