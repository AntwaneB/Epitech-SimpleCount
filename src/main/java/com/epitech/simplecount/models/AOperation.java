package com.epitech.simplecount.models;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public abstract class AOperation extends AExpressionPart implements IOperation
{
	public static class Factory
	{
		private static final Map<Token.Tokens, String> types = new HashMap<>();
		static {
			types.put(Token.Tokens.PLUS, "com.epitech.simplecount.models.Addition");
			types.put(Token.Tokens.MINUS, "com.epitech.simplecount.models.Subtraction");
			types.put(Token.Tokens.MULT, "com.epitech.simplecount.models.Multiplication");
			types.put(Token.Tokens.DIV, "com.epitech.simplecount.models.Division");
			types.put(Token.Tokens.MOD, "com.epitech.simplecount.models.Modulo");
		}

		public static AOperation make(Token token)
		{
			String className = types.get(token.getValue());

			if (className == null)
				throw new RuntimeException("Invalid operation");

			try {
				Class<?> operationClass = Class.forName(className);
				Constructor<?> ctor = operationClass.getConstructor();
				Object operation = ctor.newInstance();

				if (operation instanceof AOperation)
					return ((AOperation)operation);
			} catch (Exception e) {
				System.out.println(e.toString());
				throw new RuntimeException("Invalid operation");
			}
			return (null);
		}
	}

	public AOperation()
	{
		this.type = Type.OPERATION;
	}
}
