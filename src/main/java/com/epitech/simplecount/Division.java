package com.epitech.simplecount;

/**
 * Created by Antoine on 28/10/2015.
 */

public class Division extends AOperator
{
	public Division(Operand left, Operand right)
	{
		this.left = left;
		this.right = right;
	}

	public Operand execute()
	{
		return (new Operand(this.left.getValue().divide(this.right.getValue())));
	}
}
