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
package edu.mit.collab.event;

import java.util.EventObject;

/**
 * <code>InputEvent</code> is used with <code>InputListener</code> listener
 * to signal that a designer input has been modified.
 *
 * @author Paul T. Grogan
 * @see InputListener
 */
public class InputEvent extends EventObject {
	private static final long serialVersionUID = 3436106201961020297L;
	
	final int designerIndex, inputIndex;
	final double inputValue;

	/**
	 * Instantiates a new input event.
	 *
	 * @param source the source
	 * @param designerIndex the designer index
	 * @param inputIndex the input index
	 * @param inputValue the input value
	 */
	public InputEvent(Object source, int designerIndex, int inputIndex, 
			double inputValue) {
		super(source);
		this.designerIndex = designerIndex;
		this.inputIndex = inputIndex;
		this.inputValue = inputValue;
	}
}
