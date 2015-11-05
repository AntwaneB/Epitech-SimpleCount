package com.epitech.simplecount.models.functions;

import com.epitech.simplecount.models.*;
import com.epitech.simplecount.models.Number;
import utils.BigDecimalUtils;

import java.math.BigDecimal;

public class SquareRoot extends AFunction
{
	public Number execute(Number operand)
	{
		return (this.executeDecimal(operand));
	}

	private Number executeDecimal(Number operand)
	{
		BigDecimal number = new BigDecimal(operand.toString());

		if (number.compareTo(BigDecimal.ZERO) < 0)
			throw new RuntimeException("Invalid operand");

		BigDecimal result = BigDecimalUtils.sqrt(number, Settings.asInt("max_decimals") + 3);

		return (new Number(result));
	}

	public String toString()
	{
		return ("\u221Ax");
	}
}
