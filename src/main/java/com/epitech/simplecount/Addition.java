package com.epitech.simplecount;

/**
 * Created by Antoine on 28/10/2015.
 */
public class Addition extends AOperator
{
	public Addition(Operand left, Operand right)
	{
		this.left = left;
		this.right = right;
	}

	public Operand execute()
	{
		return (new Operand(this.left.getValue().add(this.right.getValue())));
	}
}
