package com.epitech.simplecount.models;

import com.epitech.simplecount.models.AExpressionPart.Type;

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
			expression.add(result);

		if (expression.size() == 2
			&& (expression.get(1).is(Type.FUNCTION) || expression.get(1).is(Type.OPERATION)))
			expression.remove(1);

		if (expression.size() == 1 && expression.get(0).is(Type.OPERAND))
			expression.add(AOperation.Factory.make(token));

		result = null;

		this.setChanged();
		this.notifyObservers();
	}

	public void pushFunction(Token token)
	{
		if (expression.size() == 0 && result != null)
			expression.add(result);

		if (expression.size() == 2
			&& (expression.get(1).is(Type.FUNCTION) || expression.get(1).is(Type.OPERATION)))
			expression.remove(1);

		if (expression.size() == 1 && expression.get(0).is(Type.OPERAND))
			expression.add(AFunction.Factory.make(token));

		result = null;

		this.setChanged();
		this.notifyObservers();
	}

	public void pushNumber(Token token)
	{
		if (expression.size() == 0 || expression.get(expression.size() - 1).is(Type.OPERATION))
		{
			Number number = new Number();
			number.pushToken(token);

			expression.add(number);
		}
		else if (expression.get(expression.size() - 1).is(Type.OPERAND))
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
		if (expression.size() == 0 || expression.getLast().is(Type.OPERATION))
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
			&& expression.get(0).is(Type.OPERAND)
			&& expression.get(1).is(Type.OPERATION)
			&& expression.get(2).is(Type.OPERAND))
		{
			success = this.computeOperation();
		}
		else if (expression.size() == 2
				&& expression.get(0).is(Type.OPERAND)
				&& expression.get(1).is(Type.FUNCTION))
		{
			success = this.computeFunction();
		}

		this.setChanged();
		this.notifyObservers();

		return (success);
	}

	private boolean computeFunction()
	{
		Number operand = (Number)expression.get(0);

		IFunction function = (AFunction)expression.get(1);

		try
		{
			result = function.execute(operand);
		}
		catch (RuntimeException e)
		{
			return (false);
		}
		return (true);
	}

	private boolean computeOperation()
	{
		Number leftOperand = (Number)expression.get(0);
		Number rightOperand = (Number)expression.get(2);

		IOperation operation = (AOperation)expression.get(1);

		try
		{
			result = operation.execute(leftOperand, rightOperand);
		}
		catch (RuntimeException e)
		{
			return (false);
		}
		return (true);
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
			return (result.getEpured());

		if (expression.size() != 0)
			return (expression.getLast().toString());
		else
			return ("0");
	}

	public String toString()
	{
		String str = "";

		if (expression.size() > 1)
		{
			if (expression.size() == 2 && expression.get(1).is(Type.FUNCTION))
			{
				if (expression.get(0) instanceof Number)
					str += expression.get(1).toString().replaceFirst("x", ((Number)(expression.get(0))).getEpured().toString());
				else
					str += expression.get(1).toString().replaceFirst("x", expression.get(0).toString());
			}
			else
			{
				for (AExpressionPart part : expression)
				{
					if (part instanceof Number)
						str += ((Number)(part)).getEpured() + " ";
					else
						str += part.toString() + " ";
				}
			}

		}

		return (str);
	}
}
