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
package edu.mit.collab.core;

import org.apache.commons.math3.linear.RealVector;

/**
 * The Designer class is used for a manager to maintain
 * data on remote designers. It must be initialized with
 * an immutable instance name (upon discovery in the HLA ambassador)
 * however the other data members (input vector, index number, 
 * and ready status) can be modified.
 * 
 * @author Paul T. Grogan
 */
public class Designer {
	private final String instanceName; // immutable
	
	private RealVector input; // mutable
	private int index; // mutable, though should only be set once
	private boolean ready; // mutable
	
	/**
	 * Instantiates a new designer with the provided instance name.
	 *
	 * @param instanceName the instance name
	 */
	public Designer(String instanceName) {
		this.instanceName = instanceName;
		index = -1;
	}

	@Override
	public synchronized boolean equals(Object o) {
		// designers are equal if they have the same instance name
		return (o instanceof Designer) 
				&& instanceName.equals(((Designer)o).getInstanceName());
	}

	/**
	 * Gets the zero-based designer index, which specifies the design 
	 * variables under control.
	 *
	 * @return the index
	 */
	public synchronized int getIndex() {
		return index;
	}
	
	/**
	 * Gets the input vector.
	 *
	 * @return the input vector
	 */
	public synchronized RealVector getInputVector() {
		// return copy of input vector to protect 
		// against unexpected modification
		return input.copy();
	}
	
	/**
	 * Gets the instance name.
	 *
	 * @return the instance name
	 */
	public synchronized String getInstanceName() {
		return instanceName;
	}

	@Override
	public synchronized int hashCode() {
		// provide new hashcode function to conform to equals method
		return instanceName.hashCode();
	}
	
	/**
	 * Checks if is ready. A designer is ready if input values have 
	 * been confirmed and he/she is ready to receive new output values.
	 *
	 * @return true, if is ready
	 */
	public synchronized boolean isReady() {
		return ready;
	}
	
	/**
	 * Sets the zero-based designer index, which specifies the design 
	 * variables under control.
	 *
	 * @param index the new index
	 */
	public synchronized void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Sets the input value.
	 *
	 * @param inputValue the new input value
	 */
	public synchronized void setInputVector(RealVector inputValue) {
		// set a copy of the specified value to protect
		// against unexpected modification
		this.input = inputValue.copy();
	}
	
	/**
	 * Sets the ready state. A designer is ready if input values have 
	 * been confirmed and he/she is ready to receive new output values.
	 *
	 * @param ready the new ready
	 */
	public synchronized void setReady(boolean ready) {
		this.ready = ready;
	}

	@Override
	public synchronized String toString() {
		return "Designer " + index + " (ready: " + ready + 
				", input: " + input + ")";
	}
}
