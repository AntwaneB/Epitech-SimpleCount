package com.epitech.simplecount.models;

public class Calculator extends ACalculator
{
	public Calculator()
	{
	}

	public void pushOperator(Token token)
	{
		if (expression.size() == 0 && history.size() > 0  && history.getLast().getResult() != null)
			expression.pushNumber(history.getLast().getResult());

		expression.pushOperator(token);

		this.setChanged();
		this.notifyObservers();
	}

	public void pushFunction(Token token)
	{
		if (expression.size() == 0 && history.size() > 0 && history.getLast().getResult() != null)
			expression.pushNumber(history.getLast().getResult());

		expression.pushFunction(token);

		this.setChanged();
		this.notifyObservers();
	}

	public void pushNumber(Token token)
	{
		expression.pushNumber(token);

		this.setChanged();
		this.notifyObservers();
	}

	public void compute()
	{
		if (expression.compute())
		{
			history.add(new Expression(expression));
			expression.clear();
		}

		this.setChanged();
		this.notifyObservers();
	}

	public String toString()
	{
		if (expression.size() == 0 && history.size() != 0)
			return (history.getLast().currentElementToString());
		else
			return (expression.currentElementToString());
	}

	public Expression getExpression()
	{
		return (expression);
	}
}
