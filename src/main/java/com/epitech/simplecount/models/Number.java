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

		this.buildFromString(value);
	}

	public Number(Number value)
	{
		this.type = Type.OPERAND;

		for (Token t: value.tokens)
			this.pushToken(t);
	}

	public Number(BigDecimal value)
	{
		this.type = Type.OPERAND;

		this.buildFromString(value.toString());
	}

	public Number(BigInteger value)
	{
		this.type = Type.OPERAND;

		this.buildFromString(value.toString());
	}

	private void buildFromString(String value)
	{
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

		strValue = strValue.replaceAll("^0+", "0");
		strValue = strValue.replaceAll("^0+(?=\\d+)", "");

		if (strValue.length() == 0)
			strValue = "0";

		return (strValue);
	}

	public String getEpured()
	{
		BigDecimal value = new BigDecimal(this.toString());

		if (value.scale() > Settings.asInt("max_decimals"))
			value = value.setScale(Settings.asInt("max_decimals"), RoundingMode.HALF_EVEN);

		if (value.precision() - (value.scale() >= 0 ? value.scale() : 0) > Settings.asInt("max_decimals"))
			value = value.round(new MathContext(Settings.asInt("max_decimals"), RoundingMode.HALF_EVEN));

		String result = value.toString();

		if (decimal)
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
