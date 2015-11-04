package com.epitech.simplecount.views;

import com.epitech.simplecount.models.Calculator;

import javax.swing.*;
import java.awt.*;
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

		// Catching keys pressed
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_TYPED)
					System.out.println("Got key event!" + e.getKeyChar());
				return (false);
			}
		});

		this.setLayout();

		pack();
		setVisible(true);
	}

	private void setStyle()
	{
		// Managing style
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculatator");
		this.setPreferredSize(new Dimension(320, 550));
		this.setResizable(false);
		getContentPane().setBackground(new Color(0x292929));

		// Setting start position
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocation(screenSize.width / 2 - 450, screenSize.height / 2 - 600 / 2);
	}

	private void setLayout()
	{
		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(new Color(0x292929));

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
		mainPanel.add(makeButtonPanel("+", this.model, gbc, 3, 1), gbc);
		mainPanel.add(makeButtonPanel("-", this.model, gbc, 3, 2), gbc);
		mainPanel.add(makeButtonPanel("*", this.model, gbc, 3, 3), gbc);
		mainPanel.add(makeButtonPanel("/", this.model, gbc, 3, 4), gbc);
		mainPanel.add(makeButtonPanel("%", this.model, gbc, 3, 5), gbc);

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

		mainPanel.add(makeButtonPanel("0", this.model, gbc, 0, 5), gbc);
		mainPanel.add(makeButtonPanel(".", this.model, gbc, 1, 5), gbc);

		this.add(mainPanel);
	}

	private Component makeResultPanel()
	{
		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.setBackground(new Color(0x1e1e1e));

		panel.add(new TextFieldView(this.model));

		return (panel);
	}

	private Component makeSubmitPanel()
	{
		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.setBackground(new Color(0xff9000));

		panel.add(SubmitView.Factory.make("=", this.model));

		return (panel);
	}

	private Component makeFunctionsPanel()
	{
		JPanel panel = new JPanel(new GridLayout(2, 4));
		panel.setOpaque(false);
		panel.setBackground(new Color(0x212121));

		panel.add(ButtonView.Factory.make("<html>x<sup>2</sup></html>", this.model, 12));
		panel.add(ButtonView.Factory.make("<html>x<sup>3</sup></html>", this.model, 12));
		panel.add(ButtonView.Factory.make("\u221A", this.model, 12));
		panel.add(ButtonView.Factory.make("<html>e<sup>x</sup></html>", this.model, 12));

		panel.add(ButtonView.Factory.make("cos", this.model, 12));
		panel.add(ButtonView.Factory.make("sin", this.model, 12));
		panel.add(ButtonView.Factory.make("tan", this.model, 12));
		panel.add(ButtonView.Factory.make("log", this.model, 12));

		return (panel);
	}

	private Component makeButtonPanel(String text, Calculator model, GridBagConstraints ggbc, int x, int y)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(new Color(0x212121));

		ggbc.gridx = x;
		ggbc.gridy = y;

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;

		panel.add(ButtonView.Factory.make(text, model, 25), gbc);

		return (panel);
	}

	public void update(Observable o, Object arg)
	{

	}
}
