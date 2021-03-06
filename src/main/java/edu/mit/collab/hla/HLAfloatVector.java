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
package edu.mit.collab.hla;

import hla.rti1516e.encoding.ByteWrapper;
import hla.rti1516e.encoding.DataElement;
import hla.rti1516e.encoding.DataElementFactory;
import hla.rti1516e.encoding.DecoderException;
import hla.rti1516e.encoding.EncoderException;
import hla.rti1516e.encoding.EncoderFactory;
import hla.rti1516e.encoding.HLAfloat64BE;
import hla.rti1516e.encoding.HLAvariableArray;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

/**
 * <code>HLAfloatVector</code> is a wrapper around the HLAvariableArray class 
 * to provide improved functionality for storing real vectors (i.e. arrays with
 * 64-bit floating point elements) in HLA data types. In particular, it 
 * provides <code>getValue</code> and <code>setValue</code> functions to 
 * automatically transform data to and from the <code>RealVector</code> object 
 * classes.
 * 
 * @author Paul T. Grogan
 */
public class HLAfloatVector implements DataElement {
	private final HLAvariableArray<HLAfloat64BE> hlaArray;
	
	/**
	 * Instantiates a new HLAfloatVector object.
	 *
	 * @param encoderFactory the HLA encoder factory
	 */
	public HLAfloatVector(final EncoderFactory encoderFactory) {
		// initialize the underlying HLA data type, which is a
		// variable array of floating point values in this case
		hlaArray = encoderFactory.createHLAvariableArray(
				// define a data element factory to generate floating point
				// data elements on demand
				new DataElementFactory<HLAfloat64BE>() {
					@Override
					public HLAfloat64BE createElement(int index) {
						return encoderFactory.createHLAfloat64BE();
					}
				});
	}
	
	@Override
	public void decode(byte[] bytes) throws DecoderException {
		// access built-in function of underlying data type
		hlaArray.decode(bytes);
	}

	@Override
	public void decode(ByteWrapper byteWrapper) throws DecoderException {
		// access built-in function of underlying data type
		hlaArray.decode(byteWrapper);
	}

	@Override
	public void encode(ByteWrapper byteWrapper) throws EncoderException {
		// access built-in function of underlying data type
		hlaArray.encode(byteWrapper);
	}

	@Override
	public int getEncodedLength() {
		// access built-in function of underlying data type
		return hlaArray.getEncodedLength();
	}

	@Override
	public int getOctetBoundary() {
		// access built-in function of underlying data type
		return hlaArray.getOctetBoundary();
	}

	/**
	 * Gets the value as a <code>RealVector</code> object.
	 *
	 * @return the value
	 */
	public RealVector getValue() {
		// create a vector of real values with the same size as the
		// underlying HLA array variable
		RealVector vector = new ArrayRealVector(hlaArray.size());
		for(int i = 0; i < hlaArray.size(); i++) {
			// set each vector entry from the HLA array
			vector.setEntry(i, hlaArray.get(i).getValue());
		}
		return vector;
	}
	
	/**
	 * Sets the value as a <code>RealVector</code> object.
	 *
	 * @param vector the new value
	 */
	public void setValue(RealVector vector) {
		// resize the HLA array to match the vector size
		hlaArray.resize(vector.getDimension());
		for(int i = 0; i < vector.getDimension(); i++) {
			// set each array entry from the vector
			hlaArray.get(i).setValue(vector.getEntry(i));
		}
	}
	
	@Override
	public byte[] toByteArray() throws EncoderException {
		// access built-in function of underlying data type
		return hlaArray.toByteArray();
	}
}
