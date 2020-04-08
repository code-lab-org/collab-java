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

import edu.mit.collab.core.Manager;

/**
 * <code>ManagerEvent</code> is used with <code>ManagerListener</code> 
 * listener to signal that a manager object has been modified.
 *
 * @see ManagerListener
 * 
 * @author Paul T. Grogan
 */
public class ManagerEvent extends EventObject {
	private static final long serialVersionUID = -389874206436130676L;
	
	private final Manager manager;
	
	/**
	 * Instantiates a new manager event.
	 *
	 * @param source the source
	 * @param manager the manager
	 */
	public ManagerEvent(Object source, Manager manager) {
		super(source);
		this.manager = manager;
	}

	/**
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	public Manager getManager() {
		return manager;
	}
}
