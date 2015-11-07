package com.epitech.simplecount.views;

import com.epitech.simplecount.controllers.ButtonController;
import com.epitech.simplecount.models.Calculator;
import com.epitech.simplecount.models.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Observer;
import java.util.Observable;

public class CalculatorView extends JFrame implements Observer
{
	private Calculator model;

	public CalculatorView(Calculator model)
	{
		this.model = model;
		this.model.addObserver(this);

		this.setStyle();
		this.setLayout();
		this.handleKeys();

		pack();
		setVisible(true);
	}

	private void handleKeys()
	{
		ButtonController keyHandler = new ButtonController(model);
		CalculatorView self = this;

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_TYPED)
				{
					keyHandler.actionPerformed(new ActionEvent(self, ActionEvent.ACTION_PERFORMED, Character.toString(e.getKeyChar())));
				}
				return (false);
			}
		});
	}

	private void setStyle()
	{
		// Managing style
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle(Settings.get("application_title"));
		this.setPreferredSize(new Dimension(Settings.asInt("application_width"), Settings.asInt("application_height")));
		this.setResizable(false);
		getContentPane().setBackground(new Color(Settings.asInt("application_background", 16)));

		// Setting start position
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocation(screenSize.width / 2 - 450, screenSize.height / 2 - 600 / 2);
	}

	private void setLayout()
	{
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(new Color(Settings.asInt("application_background", 16)));
		mainPanel.setPreferredSize(new Dimension(Settings.asInt("application_width"), Settings.asInt("application_height") - 31));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;

		gbc.weightx = 0.75;
		gbc.weighty = 0.15;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		mainPanel.add(makeResultPanel(), gbc);

		gbc.weightx = 0.25;
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		mainPanel.add(makeSubmitPanel(), gbc);

		gbc.gridy = 1;
		gbc.weighty = 0.15;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		makeControlsPanel(mainPanel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 0.15;
		gbc.weightx = 0.75;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		mainPanel.add(makeFunctionsPanel(), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 0.15;
		gbc.weightx = 0.25;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		mainPanel.add(makeButtonPanel("7", this.model, gbc, 0, 2), gbc);
		mainPanel.add(makeButtonPanel("8", this.model, gbc, 1, 2), gbc);
		mainPanel.add(makeButtonPanel("9", this.model, gbc, 2, 2), gbc);

		mainPanel.add(makeButtonPanel("4", this.model, gbc, 0, 3), gbc);
		mainPanel.add(makeButtonPanel("5", this.model, gbc, 1, 3), gbc);
		mainPanel.add(makeButtonPanel("6", this.model, gbc, 2, 3), gbc);

		mainPanel.add(makeButtonPanel("1", this.model, gbc, 0, 4), gbc);
		mainPanel.add(makeButtonPanel("2", this.model, gbc, 1, 4), gbc);
		mainPanel.add(makeButtonPanel("3", this.model, gbc, 2, 4), gbc);

		mainPanel.add(makeButtonPanel(".", this.model, gbc, 2, 5), gbc);
		gbc.gridwidth = 2;
		mainPanel.add(makeButtonPanel("0", this.model, gbc, 0, 5), gbc);

		this.add(mainPanel);
	}

	private Component makeResultPanel()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(new Color(Settings.asInt("result_background", 16)));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;

		gbc.weighty = 0.8;
		panel.add(TextFieldView.Factory.make(this.model, gbc, 0, 1), gbc);

		TextFieldView.Factory.fontSize = 12;
		TextFieldView.Factory.dynamicFontSize = false;
		TextFieldView.Factory.background = new Color(Settings.asInt("expression_background", 16));
		TextFieldView.Factory.foreground = new Color(Settings.asInt("expression_foreground", 16));
		gbc.weighty = 0.2;
		panel.add(TextFieldView.Factory.make(this.model.getExpression(), gbc, 0, 0), gbc);
		TextFieldView.Factory.reset();

		return (panel);
	}

	private Component makeSubmitPanel()
	{
		JPanel panel = new JPanel(new GridLayout(1, 1));

		ButtonView.Factory.background = new Color(Settings.asInt("submit_background", 16));
		ButtonView.Factory.foreground = new Color(Settings.asInt("submit_foreground", 16));
		ButtonView.Factory.hover = new Color(Settings.asInt("submit_hover", 16));
		ButtonView.Factory.focus = new Color(Settings.asInt("submit_focus", 16));

		panel.add(ButtonView.Factory.make("=", this.model));

		ButtonView.Factory.reset();

		return (panel);
	}

	private void makeControlsPanel(JPanel mainPanel, GridBagConstraints gbc)
	{
		ButtonView.Factory.background = new Color(Settings.asInt("controls_background", 16));
		ButtonView.Factory.foreground = new Color(Settings.asInt("controls_foreground", 16));

		mainPanel.add(makeButtonPanel("+", this.model, gbc, 3, 1), gbc);
		mainPanel.add(makeButtonPanel("-", this.model, gbc, 3, 2), gbc);
		mainPanel.add(makeButtonPanel("*", this.model, gbc, 3, 3), gbc);
		mainPanel.add(makeButtonPanel("/", this.model, gbc, 3, 4), gbc);
		mainPanel.add(makeButtonPanel("%", this.model, gbc, 3, 5), gbc);

		ButtonView.Factory.reset();
	}

	private Component makeFunctionsPanel()
	{
		ButtonView.Factory.background = new Color(Settings.asInt("functions_background", 16));
		ButtonView.Factory.foreground = new Color(Settings.asInt("functions_foreground", 16));

		JPanel panel = new JPanel(new GridLayout(2, 4));
		panel.setBackground(ButtonView.Factory.background);

		ButtonView.Factory.fontSize = 12;
		panel.add(ButtonView.Factory.make("<html>x<sup>2</sup></html>", this.model));
		panel.add(ButtonView.Factory.make("<html>x<sup>3</sup></html>", this.model));
		panel.add(ButtonView.Factory.make("\u221A", this.model));
		panel.add(ButtonView.Factory.make("<html>e<sup>x</sup></html>", this.model));

		panel.add(ButtonView.Factory.make("cos", this.model));
		panel.add(ButtonView.Factory.make("sin", this.model));
		panel.add(ButtonView.Factory.make("tan", this.model));
		panel.add(ButtonView.Factory.make("log", this.model));

		ButtonView.Factory.reset();

		return (panel);
	}

	private Component makeButtonPanel(String text, Calculator model, GridBagConstraints ggbc, int x, int y)
	{
		JPanel panel = new JPanel(new GridBagLayout());

		ggbc.gridx = x;
		ggbc.gridy = y;

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;

		ButtonView.Factory.fontSize = 25;
		panel.add(ButtonView.Factory.make(text, model), gbc);

		return (panel);
	}

	public void update(Observable o, Object arg)
	{

	}
}
