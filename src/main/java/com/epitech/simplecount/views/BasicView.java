package com.epitech.simplecount.views;

import com.epitech.simplecount.models.Basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Observer;
import java.util.Observable;

public class BasicView extends JFrame implements Observer
{
	private Basic model;

	public BasicView(Basic model)
	{
		this.model = model;
		this.model.addObserver(this);

		// Catching keys pressed
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
			.addKeyEventDispatcher(new KeyEventDispatcher() {
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					if (e.getID() == KeyEvent.KEY_TYPED)
						System.out.println("Got key event!" + e.getKeyChar());
					return false;
				}
			});

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

		// Managing elements
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;

		c.gridwidth = 4;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		this.add(new TextFieldView(), c);

		c.gridwidth = 1;
		c.gridheight = 1;

		c.gridy = 2;
		c.gridx = 0;
		this.add(new ButtonView("7"), c);
		c.gridx = 1;
		this.add(new ButtonView("8"), c);
		c.gridx = 2;
		this.add(new ButtonView("9"), c);

		c.gridy = 3;
		c.gridx = 0;
		this.add(new ButtonView("4"), c);
		c.gridx = 1;
		this.add(new ButtonView("5"), c);
		c.gridx = 2;
		this.add(new ButtonView("6"), c);

		c.gridy = 4;
		c.gridx = 0;
		this.add(new ButtonView("1"), c);
		c.gridx = 1;
		this.add(new ButtonView("2"), c);
		c.gridx = 2;
		this.add(new ButtonView("3"), c);

		c.gridy = 5;
		c.gridx = 0;
		this.add(new ButtonView("0"), c);
		c.gridx = 1;
		this.add(new ButtonView(","), c);
		c.gridx = 2;
		this.add(new ButtonView("="), c);

		c.gridx = 3;
		c.gridy = 1;
		this.add(new ButtonView("+"), c);
		c.gridy = 2;
		this.add(new ButtonView("-"), c);
		c.gridy = 3;
		this.add(new ButtonView("*"), c);
		c.gridy = 4;
		this.add(new ButtonView("/"), c);
		c.gridy = 5;
		this.add(new ButtonView("%"), c);

		pack();
		setVisible(true);
	}

	public void update(Observable o, Object arg)
	{

	}
}
