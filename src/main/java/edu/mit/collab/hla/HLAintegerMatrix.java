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
import hla.rti1516e.encoding.HLAvariableArray;

/**
 * <code>HLAfloatVector</code> is a wrapper around the HLAvariableArray class 
 * to provide improved functionality for storing integer matrices in HLA data 
 * types. In particular, it provides <code>getValue</code> and 
 * <code>setValue </code> functions to automatically transform data to and 
 * from the <code>int[][]</code> object classes.
 * 
 * @author Paul T. Grogan
 */
public class HLAintegerMatrix implements DataElement {
	private final HLAvariableArray<HLAintegerVector> intMatrix;
	
	/**
	 * Instantiates a new HLAintegerMatrix object.
	 *
	 * @param encoderFactory the HLA encoder factory
	 */
	public HLAintegerMatrix(final EncoderFactory encoderFactory) {
		// initialize the underlying HLA data type, which is a
		// variable array of integer vectors in this case
		intMatrix = encoderFactory.createHLAvariableArray(
				new DataElementFactory<HLAintegerVector>() {
					@Override
					public HLAintegerVector createElement(int index) {
						return new HLAintegerVector(encoderFactory);
					}
				});
	}
	
	@Override
	public void decode(byte[] bytes) throws DecoderException {
		// access built-in function of underlying data type
		intMatrix.decode(bytes);
	}

	@Override
	public void decode(ByteWrapper byteWrapper) throws DecoderException {
		// access built-in function of underlying data type
		intMatrix.decode(byteWrapper);
	}

	@Override
	public void encode(ByteWrapper byteWrapper) throws EncoderException {
		// access built-in function of underlying data type
		intMatrix.encode(byteWrapper);
	}

	@Override
	public int getEncodedLength() {
		// access built-in function of underlying data type
		return intMatrix.getEncodedLength();
	}

	@Override
	public int getOctetBoundary() {
		// access built-in function of underlying data type
		return intMatrix.getOctetBoundary();
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int[][] getValue() {
		// create an integer matrix with the same size as the
		// underlying HLA array variable
		int[][] matrix = new int[intMatrix.size()][];
		for(int i = 0; i < intMatrix.size(); i++) {
			// set each vector entry from the HLA array
			matrix[i] = intMatrix.get(i).getValue();
		}
		return matrix;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param matrix the new value
	 */
	public void setValue(int[][] matrix) {
		// resize the HLA array to match the matrix size
		intMatrix.resize(matrix.length);
		for(int i = 0; i < matrix.length; i++) {
			// set each array entry from the matrix
			intMatrix.get(i).setValue(matrix[i]);
		}
	}
	
	@Override
	public byte[] toByteArray() throws EncoderException {
		// access built-in function of underlying data type
		return intMatrix.toByteArray();
	}
}
