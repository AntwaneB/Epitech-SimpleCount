package com.epitech.simplecount.models.operations;

import com.epitech.simplecount.models.*;
import com.epitech.simplecount.models.Number;

import java.math.BigDecimal;

public class Division extends AOperation
{
	public com.epitech.simplecount.models.Number execute(Number leftOperand, Number rightOperand)
	{
		return (this.executeDecimal(leftOperand, rightOperand));
	}

	private Number executeDecimal(Number leftOperand, Number rightOperand)
	{
		BigDecimal left = new BigDecimal(leftOperand.toString());
		BigDecimal right = new BigDecimal(rightOperand.toString());

		return (new Number(left.divide(right, Settings.asInt("max_decimals") + 3, BigDecimal.ROUND_HALF_EVEN)));
	}

	public String toString()
	{
		return ("/");
	}
}
