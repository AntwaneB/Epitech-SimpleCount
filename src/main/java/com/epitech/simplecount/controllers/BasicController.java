package com.epitech.simplecount.controllers;

import com.epitech.simplecount.models.Basic;
import com.epitech.simplecount.views.BasicView;

/**
 * Created by Antoine on 02/11/2015.
 */
public class BasicController
{
	public static void main(String[] args)
	{
		BasicView view = new BasicView(new Basic());
	}
}
