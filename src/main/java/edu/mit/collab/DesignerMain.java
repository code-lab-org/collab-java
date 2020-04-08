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

import edu.mit.collab.gui.DesignerFrame;
import hla.rti1516e.exceptions.RTIinternalError;

/**
 * The main class to launch a designer GUI. Expects one argument that specifies
 * the designer index (base 0).
 * 
 * @author Paul T. Grogan
 */
public class DesignerMain {
	private static Logger logger = Logger.getLogger(DesignerMain.class);
	
	/**
	 * The main method to launch the designer application.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		BasicConfigurator.configure();
		
		final int designerIndex;
		// validate designer index
		if(args.length < 1 || Integer.parseInt(args[0]) < 0) {
			throw new IllegalArgumentException(
					"Non-negative designer index must be specified in args[0].");
		} else {
			designerIndex = Integer.parseInt(args[0]);
		}

		// set jgoodies plastic 3d look and feel for better 
		// cross-platform support
		try {
			UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			logger.error(e);
		}

		// start designer frame in java swing thread
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					// create frame, pack, and make visible
					DesignerFrame f = new DesignerFrame(designerIndex);
					f.pack();
					f.setVisible(true);
				} catch (RTIinternalError ex) {
					logger.error(ex);
				}
			}
		});
	}
}
