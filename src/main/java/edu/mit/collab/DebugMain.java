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
package edu.mit.collab;

import java.awt.Point;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;

import edu.mit.collab.gui.DesignerFrame;
import edu.mit.collab.gui.ManagerFrame;

/**
 * The main class for debugging - launches one manager and three designer GUIs.
 * 
 * @author Paul T. Grogan
 */
public class DebugMain {
	private static Logger logger = Logger.getLogger(DebugMain.class);
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// set the look and feel to the jgoodies plastic 3d theme
		// (looks better across platforms)
		try {
			UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
		} catch (Exception e) {}
		
		// start up gui components in swing thread
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					// start manager frame and make visible
					ManagerFrame m = new ManagerFrame();
					m.pack();
					m.setVisible(true);
					
					// start three designer frames and make visible
					for(int i = 0; i < 3; i++) {
						DesignerFrame d = new DesignerFrame(i);
						d.pack();
						// position to the right of the manager frame
						d.setLocation(new Point(
								m.getLocation().x 
									+ m.getWidth() 
									+ i*d.getWidth(), 
								m.getLocation().y));
						d.setVisible(true);
					}
				} catch (Exception ex) {
					// show error message
					JOptionPane.showMessageDialog(null, 
							"An exception of type " + ex.getMessage() + 
							" occurred while starting. Please see the " +
							"stack trace for more details.", 
							"Error", 
							JOptionPane.ERROR_MESSAGE);
					logger.error(ex);
				}
			}
		});
	}
}
