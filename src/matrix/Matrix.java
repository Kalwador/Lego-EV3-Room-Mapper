/*
Copyright 2017 Piotr Szpila - Kalwador

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package matrix;

/**
 * Class which allows build two dimmesnions arrays of generic type.
 *
 * @author Kalwador
 * @param <T> any kind of Referenced Type of object
 * @since 23.03.2017
 */
public class Matrix<T> extends AbstractMatrix {

    /**
     * New Matrix 100x100
     */
    public Matrix() {
        super();
    }

    /**
     * Copy Constructor
     *
     * @param matrix
     */
    public Matrix(T[][] matrix) {
        super(matrix);
    }

    /**
     * New Empty Matrix with specified dimension
     *
     * @param witdh requested width
     * @param height requested height
     */
    public Matrix(int witdh, int height) {
        super(witdh, height);
    }

    public void put(int x, int y, T object) {

        // Możliwe że te wartości trzeba tu zamienić :) sie okaze
        if (x >= super.getWidth()) {
            super.ExpadDown(y + 10);
        }
        if (x < 0) {
            super.ExpadUp(Math.abs(y));
        }
        if (y >= super.getHeight()) {
            super.ExpadRight(x + 10);
        }
        if (y < 0) {
            super.ExpadLeft(Math.abs(x));
        }
        super.putObject(x, y, object);
    }
}
