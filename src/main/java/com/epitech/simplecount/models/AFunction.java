package com.epitech.simplecount.models;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public abstract class AFunction extends AExpressionPart implements IFunction
{
	public static class Factory
	{
		private static final Map<Token.Tokens, String> types = new HashMap<>();
		static {
			types.put(Token.Tokens.SQUARE, "com.epitech.simplecount.models.functions.Square");
			types.put(Token.Tokens.CUBE, "com.epitech.simplecount.models.functions.Cube");
			types.put(Token.Tokens.SQRT, "com.epitech.simplecount.models.functions.SquareRoot");
			types.put(Token.Tokens.EXP, "com.epitech.simplecount.models.functions.Exponential");
			types.put(Token.Tokens.COS, "com.epitech.simplecount.models.functions.Cosine");
			types.put(Token.Tokens.SIN, "com.epitech.simplecount.models.functions.Sine");
			types.put(Token.Tokens.TAN, "com.epitech.simplecount.models.functions.Tangent");
			types.put(Token.Tokens.LOG, "com.epitech.simplecount.models.functions.Logarithm");
		}

		public static AFunction make(Token token)
		{
			String className = types.get(token.getValue());

			if (className == null)
				throw new RuntimeException("Invalid operation");

			try {
				Class<?> functionClass = Class.forName(className);
				Constructor<?> ctor = functionClass.getConstructor();
				Object function = ctor.newInstance();

				if (function instanceof AFunction)
					return ((AFunction)function);
			} catch (Exception e) {
				System.out.println(e.toString());
				throw new RuntimeException("Invalid operation");
			}
			return (null);
		}
	}

	public AFunction()
	{
		this.type = Type.FUNCTION;
	}
}
