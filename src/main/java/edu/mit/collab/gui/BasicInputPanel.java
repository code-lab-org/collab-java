/******************************************************************************
 * Copyright 2020 Paul T. Grogan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *****************************************************************************/
package edu.mit.collab.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.mit.collab.event.InputEvent;
import edu.mit.collab.event.InputListener;
import edu.mit.collab.util.Utilities;

/**
 * A basic panel that presents designer inputs.
 * 
 * @author Paul T. Grogan
 */
public class BasicInputPanel extends InputPanel {
	private static final long serialVersionUID = -3934341529444058089L;
	private static final int sliderTicksPerUnit = 100;
	private static final double maxValue = 1d, minValue = -1d;
	private static final ImageIcon readyIcon = new ImageIcon(
			BasicInputPanel.class.getClassLoader().getResource(
					"resources/star.png"));
	
	private final int designerIndex, inputIndex; // immutable
	private final JSlider inputSlider; // mutable
	private final JLabel readyLabel; // mutable
	private boolean ready; // mutable
	
	/**
	 * Instantiates a new basic input panel.
	 *
	 * @param designerIndex the designer index
	 * @param inputIndex the input index
	 * @param initialValue the initial value
	 * @param solutionValue the solution value
	 */
	public BasicInputPanel(int designerIndex, int inputIndex, double initialValue, 
			double solutionValue, String label) {
		this.designerIndex = designerIndex;
		this.inputIndex = inputIndex;
		
		// set layout
		setLayout(new BorderLayout());
		
		// create raised border
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createBevelBorder(BevelBorder.RAISED), 
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		// create and add input slider to center
		inputSlider = createSlider(solutionValue);
		inputSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if(!inputSlider.getValueIsAdjusting()) {
					inputChanged();
				}
			}
		});
		inputSlider.setMajorTickSpacing(sliderTicksPerUnit/10);
		inputSlider.setOrientation(JSlider.VERTICAL);
		inputSlider.setEnabled(false);
		inputSlider.setOpaque(false);
		add(inputSlider, BorderLayout.CENTER);
		
		// create and add variable label to top
		if(label == null) {
			label = "<html>X<sub>" + (designerIndex+1) + ","
					+ (inputIndex+1) + "</sub></html>";
		}
		add(new JLabel(label, Utilities.getUserIcon(designerIndex), 
				JLabel.CENTER), BorderLayout.NORTH);
		
		// create and add ready label to bottom
		readyLabel = new JLabel();
		readyLabel.setPreferredSize(new Dimension(25,25));
		add(readyLabel, BorderLayout.SOUTH);
		
		// initialize the value of the slider
		setValue(initialValue);
	}
	
	/**
	 * Creates the slider.
	 *
	 * @param solutionValue the solution value
	 * @return the j slider
	 */
	private static JSlider createSlider(final double solutionValue) {
		if(Math.abs(solutionValue) <= 1) {
			return new JSlider((int)(sliderTicksPerUnit*minValue), 
					(int)(sliderTicksPerUnit*maxValue)) {
				private static final long serialVersionUID = -1430242296899154851L;
	
				/* (non-Javadoc)
				 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
				 */
				@Override
				public void paintComponent(Graphics g) {
					Graphics g2 = g.create();
					g2.setColor(Color.green);
					// subtract padding to left and right of slider bar, estimated at 10px
					int netHeight = getHeight() - 2*10;
					int targetOffset = (int) Math.round(solutionValue*sliderTicksPerUnit*netHeight/
							(getMaximum()-getMinimum()));
					int goalHeight = 2;
					g2.fillRect(0, getHeight()/2 - targetOffset - goalHeight/2, getWidth(), goalHeight);
					g2.dispose();
					super.paintComponent(g);
				}
			};
		} else {
			return new JSlider((int)(sliderTicksPerUnit*minValue), 
					(int)(sliderTicksPerUnit*maxValue));
		}
	}

	@Override
	public void bindKey(KeyStroke keyStroke, String name, Action action) {
		inputSlider.getInputMap().put(keyStroke, name);
		inputSlider.getActionMap().put(name, action);
	}

	/**
	 * Gets the slider component.
	 *
	 * @return the slider
	 */
	public JSlider getSlider() {
		return inputSlider;
	}

	@Override
	public double getValue() {
		return inputSlider.getValue()/((double)sliderTicksPerUnit);
	}
	
	/**
	 * Input changed.
	 */
	public void inputChanged() {
		// notify all listeners that the input has changed
		for(InputListener l : listenerList.getListeners(InputListener.class)) {
			l.inputChanged(new InputEvent(this, designerIndex, 
					inputIndex, inputSlider.getValue()/((double)sliderTicksPerUnit)));
		}
	}
	
	@Override
	public boolean isReady() {
		return ready;
	}
	
	@Override
	public void requestFocus() {
		inputSlider.requestFocus();
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		inputSlider.setEnabled(enabled);
	}

	@Override
	public void setReady(boolean ready) {
		readyLabel.setIcon(ready?readyIcon:null);
		readyLabel.setText(ready?"Ready!":"");
	}

	@Override
	public void setValue(double value) {
		inputSlider.setValue((int)(sliderTicksPerUnit*value));
	}
}
