package com.epitech.simplecount.models.functions;

import com.epitech.simplecount.models.AFunction;
import com.epitech.simplecount.models.Number;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Square extends AFunction
{
	public Number execute(Number operand)
	{
		if (operand.isDecimal())
			return (this.executeDecimal(operand));
		else
			return (this.executeInteger(operand));
	}

	private Number executeDecimal(Number operand)
	{
		BigDecimal number = new BigDecimal(operand.toString());

		return (new Number(number.pow(2).toString()));
	}

	private Number executeInteger(Number operand)
	{
		BigInteger number = new BigInteger(operand.toString());

		return (new Number(number.pow(2).toString()));
	}

	public String toString()
	{
		return ("x^2");
	}
}
