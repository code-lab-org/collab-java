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

import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import edu.mit.collab.event.InputListener;

/**
 * An abstract class that set requirements for panels with input parameters.
 * 
 * @author Paul T. Grogan
 */
public abstract class InputPanel extends JPanel {
	private static final long serialVersionUID = 4677941323688111822L;

	/**
	 * Adds the input listener.
	 *
	 * @param listener the listener
	 */
	public void addInputListener(InputListener listener) {
		listenerList.add(InputListener.class, listener);
	}
	
	/**
	 * Bind key.
	 *
	 * @param keyStroke the key stroke
	 * @param name the name
	 * @param action the action
	 */
	public abstract void bindKey(KeyStroke keyStroke, String name, 
			Action action);
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public abstract double getValue();
	
	/**
	 * Checks if is ready.
	 *
	 * @return true, if is ready
	 */
	public abstract boolean isReady();
	
	/**
	 * Removes the input listener.
	 *
	 * @param listener the listener
	 */
	public void removeInputListener(InputListener listener) {
		listenerList.remove(InputListener.class, listener);
	}
	
	@Override
	public abstract void requestFocus();

	
	@Override
	public abstract void setEnabled(boolean enabled);
	
	/**
	 * Sets the ready.
	 *
	 * @param ready the new ready
	 */
	public abstract void setReady(boolean ready);
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public abstract void setValue(double value);
}
