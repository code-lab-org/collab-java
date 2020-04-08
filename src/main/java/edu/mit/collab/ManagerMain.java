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

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;

import edu.mit.collab.gui.ManagerFrame;
import hla.rti1516e.exceptions.RTIinternalError;

/**
 * The main class to launch a manager GUI.
 * 
 * @author Paul T. Grogan
 */
public class ManagerMain {
	private static Logger logger = Logger.getLogger(ManagerMain.class);
	
	/**
	 * The main method to launch the manager application.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		BasicConfigurator.configure();
		
		// set jgoodies plastic 3d look and feel for better 
		// cross-platform support
		try {
			UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			logger.error(e);
		}

		// start manager frame in java swing thread
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					// create frame, pack, and make visible
					ManagerFrame f = new ManagerFrame();
					f.pack();
					f.setVisible(true);
				} catch (RTIinternalError ex) {
					logger.error(ex);
				}
			}
		});
	}
}
