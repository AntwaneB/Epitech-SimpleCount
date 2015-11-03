package com.epitech.simplecount.models;

import com.epitech.simplecount.models.AExpressionPart.Type;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class Calculator extends Observable
{
	private List<ArrayList<AExpressionPart>> history = new LinkedList<ArrayList<AExpressionPart>>();
	private List<AExpressionPart> expression = new ArrayList<AExpressionPart>();

	private Number result = null;


	public Calculator()
	{
	}

	public void pushOperator(Token token)
	{
		if (expression.size() == 0 && result != null)
		{
			expression.add(result);
		}
		if (expression.size() == 1 && expression.get(0).is(Type.OPERAND))
		{
			expression.add(AOperation.Factory.make(token));
		}

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

	public void compute()
	{
		if (expression.size() == 3
			&& expression.get(0).is(Type.OPERAND)
			&& expression.get(1).is(Type.OPERATION)
			&& expression.get(2).is(Type.OPERAND))
		{
			Number leftOperand = (Number)expression.get(0);
			Number rightOperand = (Number)expression.get(2);

			IOperation operation = (AOperation)expression.get(1);

			result = operation.execute(leftOperand, rightOperand);

			history.add(new ArrayList<>(expression));
			expression.clear();
		}

		this.setChanged();
		this.notifyObservers();
	}

	public String toString()
	{
		if (result != null)
			return (result.epur().toString());

		if (expression.size() != 0)
			return (expression.get(expression.size() - 1).toString());
		else
			return ("0");
	}
}
