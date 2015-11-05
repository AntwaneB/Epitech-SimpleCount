package com.epitech.simplecount.models.functions;

import com.epitech.simplecount.models.*;
import com.epitech.simplecount.models.Number;
import utils.BigDecimalUtils;

import java.math.BigDecimal;

public class Exponential extends AFunction
{
	public Number execute(Number operand)
	{
		return (this.executeDecimal(operand));
	}

	private Number executeDecimal(Number operand)
	{
		BigDecimal result = BigDecimalUtils.exp(new BigDecimal(operand.toString()), Settings.asInt("max_decimals") + 3);

		return (new Number(result));
	}

	public String toString()
	{
		return ("e^x");
	}
}
