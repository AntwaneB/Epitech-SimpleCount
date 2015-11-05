package com.epitech.simplecount.models.functions;

import com.epitech.simplecount.models.*;
import com.epitech.simplecount.models.Number;

import java.math.BigDecimal;

public class Cosine extends AFunction
{
	public Number execute(Number operand)
	{
		return (this.executeDecimal(operand));
	}

	private Number executeDecimal(Number operand)
	{
		BigDecimal modOperand = new BigDecimal(operand.toString()).remainder(new BigDecimal(360));

		double result = Math.cos(modOperand.doubleValue() * Math.PI / 180.0);

		return (new Number(Double.toString(result)));
	}

	public String toString()
	{
		return ("cos(x)");
	}
}
