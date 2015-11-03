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
		EGAL
	}

	private static final HashMap<Character, Tokens> tokens = new HashMap<>();
	static {
		tokens.put('0', Tokens.ZERO);
		tokens.put('1', Tokens.ONE);
		tokens.put('2', Tokens.TWO);
		tokens.put('3', Tokens.THREE);
		tokens.put('4', Tokens.FOUR);
		tokens.put('5', Tokens.FIVE);
		tokens.put('6', Tokens.SIX);
		tokens.put('7', Tokens.SEVEN);
		tokens.put('8', Tokens.EIGHT);
		tokens.put('9', Tokens.NINE);
		tokens.put('.', Tokens.DOT);
		tokens.put('+', Tokens.PLUS);
		tokens.put('-', Tokens.MINUS);
		tokens.put('*', Tokens.MULT);
		tokens.put('/', Tokens.DIV);
		tokens.put('%', Tokens.MOD);
		tokens.put('=', Tokens.EGAL);
	}


	private final Tokens value;
	private final char charValue;

	public Token(char input)
	{
		Character value = new Character(input);

		if (!Token.tokens.containsKey(value))
			throw new RuntimeException("Invalid token");

		this.value = Token.tokens.get(value);
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

	public char getCharValue()
	{
		return (this.charValue);
	}

	public boolean is(Tokens token)
	{
		return (this.value == token);
	}
}
