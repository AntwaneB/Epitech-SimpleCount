package com.epitech.simplecount;

/**
 * Created by Antoine on 28/10/2015.
 */

public class Multiplication extends AOperator
{
	public Multiplication(Operand left, Operand right)
	{
		this.left = left;
		this.right = right;
	}

	public Operand execute()
	{
		return (new Operand(this.left.getValue().multiply(this.right.getValue())));
	}
}
