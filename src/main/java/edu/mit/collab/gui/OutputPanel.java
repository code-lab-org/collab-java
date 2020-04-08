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

import javax.swing.JPanel;

/**
 * An abstract class that set requirements for panels with output parameters.
 * 
 * @author Paul T. Grogan
 */
public abstract class OutputPanel extends JPanel {
	private static final long serialVersionUID = 5549445039639583362L;

	public static final double ERROR_ALLOWED = 0.05;

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public abstract double getValue();
	
	/**
	 * Checks if is within range.
	 *
	 * @return true, if is within range
	 */
	public abstract boolean isWithinRange();
	
	@Override
	public abstract void setEnabled(boolean enabled);
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public abstract void setValue(double value);
}
