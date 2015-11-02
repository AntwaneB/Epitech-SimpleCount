package com.epitech.simplecount;

import java.math.BigDecimal;

/**
 * Created by Antoine on 28/10/2015.
 */
public class Operand
{
	BigDecimal value;

	public Operand(BigDecimal value)
	{
		this.value = value;
	}

	public BigDecimal getValue()
	{
		return (this.value);
	}
}
