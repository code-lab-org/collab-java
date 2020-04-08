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

/**
 * A factory for creating InputPanel objects.
 * 
 * @author Paul T. Grogan
 */
public abstract class InputPanelFactory {
	
	/**
	 * Creates a new InputPanel object.
	 *
	 * @param designerIndex the designer index
	 * @param inputIndex the input index
	 * @param initialValue the initial value
	 * @param label the label
	 * @return the basic input panel
	 */
	public static BasicInputPanel createBasicInputPanelWithoutSolution(int designerIndex, 
			int inputIndex, double initialValue, String label) {
		return new BasicInputPanel(designerIndex, inputIndex, 
				initialValue, Double.MAX_VALUE, label);
	}

	/**
	 * Creates a new InputPanel object.
	 *
	 * @param designerIndex the designer index
	 * @param inputIndex the input index
	 * @param initialValue the initial value
	 * @param solutionValue the solution value
	 * @param label the label
	 * @return the basic input panel
	 */
	public static BasicInputPanel createBasicInputPanelWithSolution(int designerIndex, 
			int inputIndex, double initialValue, 
			double solutionValue, String label) {
		return new BasicInputPanel(designerIndex, inputIndex, 
				initialValue, solutionValue, label);
	}
}
