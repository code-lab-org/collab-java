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

import edu.mit.collab.core.Designer;

/**
 * <code>DesignerEvent</code> is used with <code>DesignerListener</code> 
 * listener to signal that a designer object has been modified.
 *
 * @author Paul T. Grogan
 * @see DesignerListener
 */
public class DesignerEvent extends EventObject {
	private static final long serialVersionUID = -389874206436130676L;
	
	private final Designer designer;
	
	/**
	 * Instantiates a new designer event.
	 *
	 * @param source the source
	 * @param designer the designer
	 */
	public DesignerEvent(Object source, Designer designer) {
		super(source);
		this.designer = designer;
	}
	
	/**
	 * Gets the designer.
	 *
	 * @return the designer
	 */
	public Designer getDesigner() {
		return designer;
	}
}
