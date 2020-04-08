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
 * A factory for creating OutputPanel objects.
 * 
 * @author Paul T. Grogan
 */
public abstract class OutputPanelFactory {
	
	/**
	 * Creates a new OutputPanel object.
	 *
	 * @param designerIndex the designer index
	 * @param outputIndex the output index
	 * @param targetOutput the target output
	 * @param outputValue the output value
	 * @param label the label
	 * @return the basic output panel
	 */
	public static BasicOutputPanel createBasicOutputPanel(int designerIndex, 
			int outputIndex, double targetOutput, double outputValue, 
			String label) {
		return new BasicOutputPanel(designerIndex, outputIndex, 
				targetOutput, outputValue, label);
	}

	/**
	 * Creates a new OutputPanel object.
	 *
	 * @param designerIndex the designer index
	 * @param outputIndex the output index
	 * @param targetOutput the target output
	 * @param outputValue the output value
	 * @param label the label
	 * @return the quantitative output panel
	 */
	public static QuantitativeOutputPanel createQuantitativeOutputPanel(int designerIndex, 
			int outputIndex, double targetOutput, double outputValue, 
			String label) {
		return new QuantitativeOutputPanel(designerIndex, outputIndex, 
				targetOutput, outputValue, label);
	}

	/**
	 * Creates a new OutputPanel object.
	 *
	 * @param designerIndex the designer index
	 * @param outputIndex the output index
	 * @param targetOutput the target output
	 * @param outputValue the output value
	 * @param label the label
	 * @return the manual quantitative output panel
	 */
	public static ManualQuantitativeOutputPanel createManualQuantitativeOutputPanel(
			int designerIndex, int outputIndex, double targetOutput, 
			double outputValue, String label) {
		return new ManualQuantitativeOutputPanel(designerIndex, outputIndex, 
				targetOutput, outputValue, label);
	}
}
