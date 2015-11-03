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

	private void setLayout()
	{
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;

		c.gridwidth = 4;
		c.gridheight = 1;
		this.add(TextFieldView.Factory.make(this.model, c, 0, 0), c);

		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(ButtonView.Factory.make("7", this.model, c, 0, 2), c);
		this.add(ButtonView.Factory.make("8", this.model, c, 1, 2), c);
		this.add(ButtonView.Factory.make("9", this.model, c, 2, 2), c);

		this.add(ButtonView.Factory.make("4", this.model, c, 0, 3), c);
		this.add(ButtonView.Factory.make("5", this.model, c, 1, 3), c);
		this.add(ButtonView.Factory.make("6", this.model, c, 2, 3), c);

		this.add(ButtonView.Factory.make("1", this.model, c, 0, 4), c);
		this.add(ButtonView.Factory.make("2", this.model, c, 1, 4), c);
		this.add(ButtonView.Factory.make("3", this.model, c, 2, 4), c);

		this.add(ButtonView.Factory.make("0", this.model, c, 0, 5), c);
		this.add(ButtonView.Factory.make(".", this.model, c, 1, 5), c);
		this.add(ButtonView.Factory.make("=", this.model, c, 2, 5), c);

		this.add(ButtonView.Factory.make("+", this.model, c, 3, 1), c);
		this.add(ButtonView.Factory.make("-", this.model, c, 3, 2), c);
		this.add(ButtonView.Factory.make("*", this.model, c, 3, 3), c);
		this.add(ButtonView.Factory.make("/", this.model, c, 3, 4), c);
		this.add(ButtonView.Factory.make("%", this.model, c, 3, 5), c);
	}

	private void setStyle()
	{
		// Managing style
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculatator");
		this.setPreferredSize(new Dimension(370, 600));
		this.setResizable(false);
		this.setLayout(new GridBagLayout());
		getContentPane().setBackground(new Color(0xf2f2f2));

		// Setting start position
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocation(screenSize.width / 2 - 450, screenSize.height / 2 - 600 / 2);
	}

	public void update(Observable o, Object arg)
	{

	}
}
