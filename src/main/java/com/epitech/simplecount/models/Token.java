package com.epitech.simplecount.models;

import java.util.HashMap;

public class Token
{
	public enum Tokens
	{
		ZERO,
		ONE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		DOT,
		PLUS,
		MINUS,
		MULT,
		DIV,
		MOD,
		EGAL,

		SQUARE,
		CUBE,
		SQRT,
		COS,
		SIN,
		TAN,
		LOG,
		EXP
	}

	private static final HashMap<String, Tokens> tokens = new HashMap<>();
	static {
		tokens.put("0", Tokens.ZERO);
		tokens.put("1", Tokens.ONE);
		tokens.put("2", Tokens.TWO);
		tokens.put("3", Tokens.THREE);
		tokens.put("4", Tokens.FOUR);
		tokens.put("5", Tokens.FIVE);
		tokens.put("6", Tokens.SIX);
		tokens.put("7", Tokens.SEVEN);
		tokens.put("8", Tokens.EIGHT);
		tokens.put("9", Tokens.NINE);
		tokens.put(".", Tokens.DOT);

		tokens.put("-", Tokens.MINUS);

		tokens.put("+", Tokens.PLUS);
		tokens.put("*", Tokens.MULT);
		tokens.put("/", Tokens.DIV);
		tokens.put("%", Tokens.MOD);
		tokens.put("=", Tokens.EGAL);
		tokens.put("\n", Tokens.EGAL);

		tokens.put("<html>x<sup>2</sup></html>", Tokens.SQUARE);
		tokens.put("<html>x<sup>3</sup></html>", Tokens.CUBE);
		tokens.put("\u221A", Tokens.SQRT);
		tokens.put("<html>e<sup>x</sup></html>", Tokens.EXP);
		tokens.put("cos", Tokens.COS);
		tokens.put("sin", Tokens.SIN);
		tokens.put("tan", Tokens.TAN);
		tokens.put("log", Tokens.LOG);
	}

	private final Tokens value;
	private final String charValue;

	public Token(char input)
	{
		if (!Token.tokens.containsKey(Character.toString(input)))
			throw new RuntimeException("Invalid token : " + Character.toString(input));

		this.value = Token.tokens.get(Character.toString(input));
		this.charValue = Character.toString(input);
	}

	public Token(String input)
	{
		if (!Token.tokens.containsKey(input))
			throw new RuntimeException("Invalid token : " + input);

		this.value = Token.tokens.get(input);
		this.charValue = input;
	}

	public Token(Token input)
	{
		this.value = input.value;
		this.charValue = input.charValue;
	}

	public Tokens getValue()
	{
		return (this.value);
	}

	public String getCharValue()
	{
		return (this.charValue);
	}

	public boolean is(Tokens token)
	{
		return (this.value == token);
	}

	public static boolean isValidToken(String value)
	{
		return (Token.tokens.containsKey(value));
	}

}
