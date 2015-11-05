package com.epitech.simplecount.models;

import java.util.LinkedList;
import java.util.Observable;

public class Expression extends Observable
{
	private LinkedList<AExpressionPart> expression = new LinkedList<>();
	private Number result = null;

	public Expression()
	{
	}

	public Expression(Expression other)
	{
		expression = new LinkedList<>(other.expression);
		result = new Number(other.result);
	}

	public void clear()
	{
		expression.clear();
		result = null;
	}

	public void pushOperator(Token token)
	{
		if (expression.size() == 0 && result != null)
		{
			expression.add(result);
		}
		if (expression.size() == 1 && expression.get(0).is(AExpressionPart.Type.OPERAND))
		{
			expression.add(AOperation.Factory.make(token));
		}

		result = null;

		this.setChanged();
		this.notifyObservers();
	}

	public void pushFunction(Token token)
	{
		if (expression.size() == 0 && result != null)
		{
			expression.add(result);
		}
		if (expression.size() == 1 && expression.get(0).is(AExpressionPart.Type.OPERAND))
		{
			expression.add(AFunction.Factory.make(token));
		}

		result = null;

		this.setChanged();
		this.notifyObservers();
	}

	public void pushNumber(Token token)
	{
		if (expression.size() == 0 || expression.get(expression.size() - 1).is(AExpressionPart.Type.OPERATION))
		{
			Number number = new Number();
			number.pushToken(token);

			expression.add(number);
		}
		else if (expression.get(expression.size() - 1).is(AExpressionPart.Type.OPERAND))
		{
			Number number = (Number)(expression.get(expression.size() - 1));
			number.pushToken(token);
		}

		result = null;

		this.setChanged();
		this.notifyObservers();
	}

	public void pushNumber(Number number)
	{
		if (expression.size() == 0 || expression.getLast().is(AExpressionPart.Type.OPERATION))
		{
			expression.add(new Number(number));
		}

		result = null;

		this.setChanged();
		this.notifyObservers();
	}

	public boolean compute()
	{
		boolean success = false;

		if (expression.size() == 3
			&& expression.get(0).is(AExpressionPart.Type.OPERAND)
			&& expression.get(1).is(AExpressionPart.Type.OPERATION)
			&& expression.get(2).is(AExpressionPart.Type.OPERAND))
		{
			Number leftOperand = (Number)expression.get(0);
			Number rightOperand = (Number)expression.get(2);

			IOperation operation = (AOperation)expression.get(1);

			result = operation.execute(leftOperand, rightOperand);

			success = true;
		}
		else if (expression.size() == 2
				&& expression.get(0).is(AExpressionPart.Type.OPERAND)
				&& expression.get(1).is(AExpressionPart.Type.FUNCTION))
		{
			Number operand = (Number)expression.get(0);

			IFunction function = (AFunction)expression.get(1);

			result = function.execute(operand);

			success = true;
		}

		this.setChanged();
		this.notifyObservers();

		return (success);
	}

	public int size()
	{
		return (expression.size());
	}

	public Number getResult()
	{
		return (result);
	}

	public String currentElementToString()
	{
		if (result != null)
			return (result.epur().toString());

		if (expression.size() != 0)
			return (expression.getLast().toString());
		else
			return ("0");
	}

	public String toString()
	{
		String str = "";

		for (AExpressionPart part: expression)
			str += part.toString() + " ";

		return (str);
	}
}
