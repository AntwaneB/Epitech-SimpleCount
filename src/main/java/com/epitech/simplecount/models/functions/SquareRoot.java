package com.epitech.simplecount.models.functions;

import com.epitech.simplecount.models.*;
import com.epitech.simplecount.models.Number;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SquareRoot extends AFunction
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
		return (new Number("0"));
	}

	private Number executeInteger(Number operand)
	{
		return (new Number("0"));
	}

	public String toString()
	{
		return ("\u221A");
	}
}
