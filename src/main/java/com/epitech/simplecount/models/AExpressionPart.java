package com.epitech.simplecount.models;

import java.util.Observable;

public abstract class AExpressionPart extends Observable
{
	public enum Type
	{
		OPERAND, OPERATION, FUNCTION, UNKNOWN
	}

	protected Type type = Type.UNKNOWN;

	public Type getType()
	{
		return (this.type);
	}

	public boolean is(Type type)
	{
		return (this.type == type);
	}
}
