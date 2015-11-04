package com.epitech.simplecount.models.operations;

import com.epitech.simplecount.models.*;
import com.epitech.simplecount.models.Number;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Multiplication extends AOperation
{
	public com.epitech.simplecount.models.Number execute(Number leftOperand, Number rightOperand)
	{
		if (leftOperand.isDecimal() || rightOperand.isDecimal())
			return (this.executeDecimal(leftOperand, rightOperand));
		else
			return (this.executeInteger(leftOperand, rightOperand));
	}

	private Number executeDecimal(Number leftOperand, Number rightOperand)
	{
		BigDecimal left = new BigDecimal(leftOperand.toString());
		BigDecimal right = new BigDecimal(rightOperand.toString());

		return (new Number(left.multiply(right).toString()));
	}

	private Number executeInteger(Number leftOperand, Number rightOperand)
	{
		BigInteger left = new BigInteger(leftOperand.toString());
		BigInteger right = new BigInteger(rightOperand.toString());

		return (new Number(left.multiply(right).toString()));
	}

	public String toString()
	{
		return ("*");
	}
}
