package com.epitech.simplecount.models;

import java.util.LinkedList;
import java.util.Observable;

public abstract class ACalculator extends Observable implements ICalculator
{
	protected LinkedList<Expression> history = new LinkedList<>();
	protected Expression expression = new Expression();
}
