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

import java.util.EventListener;

/**
 * The listener interface for receiving designer events.
 * The class that is interested in processing a designer
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addDesignerListener<code> method. When
 * the designer event occurs, that object's appropriate
 * method is invoked.
 *
 * @author Paul T. Grogan
 * @see DesignerEvent
 */
public interface DesignerListener extends EventListener {
	
	/**
	 * Method to notify that a designer has joined the application.
	 *
	 * @param e the event
	 */
	public void designerAdded(DesignerEvent e);
	
	/**
	 * Method to notify that a designer input vector has been modified.
	 *
	 * @param e the event
	 */
	public void designerInputModified(DesignerEvent e);
	
	/**
	 * Method to notify that a designer has left the application.
	 *
	 * @param e the event
	 */
	public void designerRemoved(DesignerEvent e);
	
	/**
	 * Method to notify that a designer state (e.g. ready status) 
	 * has been modified.
	 *
	 * @param e the event
	 */
	public void designerStateModified(DesignerEvent e);
}
