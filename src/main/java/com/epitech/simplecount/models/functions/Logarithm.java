package com.epitech.simplecount.models.functions;

import com.epitech.simplecount.models.*;
import com.epitech.simplecount.models.Number;
import utils.BigDecimalUtils;

import java.math.BigDecimal;

public class Logarithm extends AFunction
{
	private static final BigDecimal divisor = BigDecimalUtils.ln(new BigDecimal(10), Settings.asInt("max_decimals") + 3);

	public Number execute(Number operand)
	{
		return (this.executeDecimal(operand));
	}

	private Number executeDecimal(Number operand)
	{
		BigDecimal number = new BigDecimal(operand.toString());

		if (number.compareTo(BigDecimal.ZERO) < 0)
			throw new RuntimeException("Invalid operand");

		BigDecimal dividend = BigDecimalUtils.ln(number, Settings.asInt("max_decimals") + 3);

		BigDecimal result = dividend.divide(this.divisor, Settings.asInt("max_decimals") + 3, BigDecimal.ROUND_HALF_EVEN);

		return (new Number(result));
	}

	public String toString()
	{
		return ("log(x)");
	}
}
