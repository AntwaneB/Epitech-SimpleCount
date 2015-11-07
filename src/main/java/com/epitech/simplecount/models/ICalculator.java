package com.epitech.simplecount.models;

public interface ICalculator
{
	void pushOperator(Token token);
	void pushFunction(Token token);
	void pushNumber(Token token);
	void compute();
	Expression getExpression();
}
