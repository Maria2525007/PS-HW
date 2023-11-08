import java.util.Arrays;
import java.util.Vector;

import static java.lang.Math.*;

public class Matrices {
    static <T> T todo() {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    /**
     * Вектор длины n
     */
    public static class Vector {
        private final int[] items;

        /**
         * Создает нулевой вектор длины n
         */
        public Vector(int n) {
            this.items = new int[n];
        }

        /**
         * Создает вектор c заданными элементами.
         */
        public Vector(int[] items) {
            this.items = items;
        }

        /**
         * Складывает данный вектор с другим вектором.
         *
         * @param other вектор, который должен быть сложен с данным вектором; должен
         *              иметь ту же длину, что и данный вектор
         * @return новый вектор, представляющий сумму данного и другого векторов
         */
        public Vector add(Vector other) {
            int[] result = new int[this.items.length];
            if (items.length== other.items.length) {
                for (int i = 0; i < items.length; i++) {
                    result[i] = this.items[i] + other.items[i];
                }
            }
            else throw new IllegalArgumentException("Длины векторов не совпадают");
            return new Vector(result);
        }

        /**
         * Вычитает другой вектор из данного вектора.
         *
         * @param other вектор, который должен быть вычтен из данного вектора; должен
         *              иметь ту же длину, что и данный вектор
         * @return новый вектор, представляющий разность данного и другого векторов
         */
        public Vector subtract(Vector other) {
            int[] result = new int[this.items.length];
            if (this.items.length == other.items.length) {
                for (int i = 0; i < items.length; i++) {
                    result[i] = this.items[i] - other.items[i];
                }
            }
            else throw new IllegalArgumentException("Длины векторов не совпадают");
            return new Vector(result);
        }

        /**
         * Вычисляет скалярное произведение данного вектора с другим вектором.
         *
         * @param other вектор, с которым должно быть вычислено скалярное произведение;
         *              должен иметь ту же длину, что и данный вектор
         * @return скалярное произведение данного и другого векторов
         */
        public int dotProduct(Vector other) {
            int result = 0;
            if (items.length == other.items.length) {
                for (int i = 0; i < items.length; i++) {
                    result += this.items[i] * other.items[i];
                }
            }
            else throw new IllegalArgumentException("Длины векторов не совпадают");
            return result;
        }

        /**
         * Умножает данный вектор на скаляр.
         *
         * @param scalar скалярное значение, на которое должен быть умножен данный вектор
         * @return новый вектор, представляющий результат умножения данного вектора на скаляр
         */
        public Vector scalarMultiply(int scalar) {
            int[] result = new int[items.length];
            for (int i = 0; i < items.length; i++) {
                result[i] = this.items[i] * scalar;
            }
            return new Vector(result);
        }

        /**
         * Вычисляет длину (норму) данного вектора.
         */
        public double length() {
            double result = 0;
            for (int i = 0; i < items.length; i++) {
                result += pow(items[i], 2);
            }
            return (sqrt(result));
        }

        @Override
        public String toString() {
            return Arrays.toString(items);
        }
    }

    /**
     * Представляет матрицу (m x n)
     */
    public static class Matrix {
        private final int nRows;
        private final int nCols;
        private final int[][] rows;

        /**
         * Создает матрицу (nRows x nCols)
         */
        public Matrix(int nRows, int nCols) {
            this.nRows = nRows;
            this.nCols = nCols;
            this.rows = new int[nRows][nCols];
        }

        /**
         * Выводит матрицу в консоль построчно с правым выравниванием чисел по столбцам.
         */
        @Override
        public String toString() {
            int[] colWidths = new int[nCols];
            for (int col = 0; col < nCols; col++) {
                int maxWidth = 0;
                for (int row = 0; row < nRows; row++) {
                    int width = Integer.toString(rows[row][col]).length();
                    maxWidth = Math.max(maxWidth, width);
                }
                colWidths[col] = maxWidth;
            }

            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < nRows; row++) {
                for (int col = 0; col < nCols; col++) {
                    String cell = String.format("%" + colWidths[col] + "d", rows[row][col]);
                    sb.append(cell);
                    if (col < nCols - 1) {
                        sb.append(" ");
                    }
                }
                if (row < nRows - 1) {
                    sb.append("\n");
                }
            }
            return sb.toString();
        }

        /**
         * Складывает текущую матрицу с другой матрицей.
         *
         * @param other другая матрица, должна иметь такую же размерность, как и
         *              текущая матрица
         * @return новая матрица, являющаяся результатом сложения
         */
        public Matrix add(Matrix other) {
            Matrix result = new Matrix(this.nRows, this.nCols);
            if (this.nRows == other.nRows & this.nCols == other.nCols) {
                for (int r = 0; r < this.nRows; r++) {
                    for (int c = 0; c < this.nCols; c++) {
                        result.rows[r][c] = this.rows[r][c] + other.rows[r][c];
                   }
                }
            }
            else {
                throw new IllegalArgumentException("Размерности складываемых матриц не совпадают");
            }
            return result;
        }


        /**
         * Вычитает другую матрицу из текущей матрицы.
         *
         * @param other другая матрица, должна иметь такую же размерность, как и
         *              текущая матрица
         * @return новая матрица, являющаяся результатом вычитания
         */
        public Matrix subtract(Matrix other) {
            Matrix result = new Matrix(this.nRows, this.nCols);
            if (this.nRows == other.nRows & this.nCols == other.nCols) {
                for (int r = 0; r < this.nRows; r++) {
                    for (int c = 0; c < this.nCols; c++) {
                        result.rows[r][c] = this.rows[r][c] - other.rows[r][c];
                    }
                }
            }
            else {
                throw new IllegalArgumentException("Размерности вычитаемых матриц не совпадают");
            }
            return result;
        }

        /**
         * Умножает текущую матрицу на другую матрицу.
         *
         * @param other другая матрица, количество строк которой должно быть равно
         *              количеству столбцов текущей матрицы
         * @return новая матрица, являющаяся результатом умножения
         */
        public Matrix multiply(Matrix other) {
            Matrix result = new Matrix(this.nRows, other.nCols);
            if (this.nCols == other.nRows) {
                for (int r = 0; r < this.nRows; r++) {
                    for (int c = 0; c < other.nCols; c++) {
                        int sum = 0;
                        for (int k = 0; k < this.nCols; k++) {
                            sum += this.rows[r][k] * other.rows[k][c];
                        }
                        result.rows[r][c] = sum;
                    }
                }
                return result;
            }
            else {
                throw new IllegalArgumentException("Размерности умножаемых матриц не подходят");
            }
        }

        /**
         * Умножает текущую матрицу на скаляр.
         *
         * @param scalar скалярное значение для умножения матрицы
         * @return новая матрица, являющаяся результатом умножения на скаляр
         */
        public Matrix scalarMultiply(int scalar) {
            Matrix result = new Matrix(this.nRows, this.nCols);
                for (int r = 0; r < this.nRows; r++) {
                    for (int c = 0; c < this.nCols; c++) {
                        result.rows[r][c] = this.rows[r][c] * scalar;
                    }
                }
            return result;
        }

        /**
         * Транспонирует текущую матрицу.
         *
         * @return новая матрица, являющаяся транспонированной версией текущей матрицы
         */
        public Matrix transpose() {
            Matrix result = new Matrix(this.nCols, this.nRows);
            for (int r = 0; r < this.nRows; r++) {
                for (int c = 0; c < this.nCols; c++) {
                    result.rows[r][c] = this.rows[c][r];
                }
            }
            return result;
        }

        /**
         * Вычисляет определитель текущей матрицы.
         *
         * @return значение определителя матрицы
         */
        public int determinant() {
            if (this.nCols != 3 || this.nRows != 3) {
                throw new IllegalArgumentException("Матрица должна быть размером 3x3.");
            }

            int a = rows[0][0];
            int b = rows[0][1];
            int c = rows[0][2];
            int d = rows[1][0];
            int e = rows[1][1];
            int f = rows[1][2];
            int g = rows[2][0];
            int h = rows[2][1];
            int i = rows[2][2];


            return a*e*i + b*f*g + c*d*h - c*e*g - a*f*h - b*d*i;
        }

        /**
         * Рекурсивно вычисляет определитель матрицы matrix.
         * Алгоритм использует разложение по первой строке матрицы.
         *
         * @param matrix квадратная матрица, для которой нужно вычислить определитель
         * @return определитель матрицы matrix
         */
        private static int determinant(int[][] matrix) {
            // Базовый случай для матрицы 1x1
            if (matrix.length == 1) {
                return matrix[0][0];
            }

            // Базовый случай для матрицы 2x2
            if (matrix.length == 2) {
                int a = matrix[0][0];
                int b = matrix[0][1];
                int c = matrix[1][0];
                int d = matrix[1][1];

                return a * d - b * c;

            }

            int result = 0;
            // Итерация по элементам первой строки матрицы
            for (int i = 0; i < matrix.length; i++) {
                // Создание матрицы для поддетерминанта
                int[][] smallerMatrix = new int[matrix.length - 1][matrix.length - 1];
                 // Заполнение smallerMatrix нужными значениями из matrix
                for (int j = 1; j < matrix.length; j++) {
                    for (int k = 0, index = 0; k < matrix.length; k++) {
                        if (k != i) {
                            smallerMatrix[j - 1][index] = matrix[j][k];
                            index++;
                        }
                    }
                }

                // Вычисление поддетерминанта рекурсивным вызовом
                int subDeterminant = determinant(smallerMatrix);

                // Определение знака для элемента i разложения
                int sign = (i % 2 == 0) ? 1 : -1;

                // Обновление результата с учетом элемента i разложения, его знака и поддетерминанта
                result += sign * matrix[0][i] * subDeterminant;
            }
            return result;
        }

    }

    public static void main(String[] args) {
        // Пример создания нулевого вектора длины 3
        Vector zeroVector = new Vector(3);
        System.out.println("Нулевой вектор длины 3: " + zeroVector);

        // Пример создания вектора с заданными элементами
        int[] items = {1, 2, 3};
        Vector vectorA = new Vector(items);
        System.out.println("Вектор A: " + vectorA);

        // Пример сложения двух векторов
        int[] itemsB = {4, 5, 6};
        Vector vectorB = new Vector(itemsB);
        System.out.println("Вектор B: " + vectorB);
        Vector sumVector = vectorA.add(vectorB);
        System.out.println("Сумма векторов A и B: " + sumVector);

        // Пример вычитания двух векторов
        Vector diffVector = vectorA.subtract(vectorB);
        System.out.println("Разность векторов A и B: " + diffVector);

        // Пример скалярного произведения двух векторов
        int dotProduct = vectorA.dotProduct(vectorB);
        System.out.println("Скалярное произведение векторов A и B: " + dotProduct);

        // Пример умножения вектора на скаляр
        int scalar = 2;
        Vector scalarProduct = vectorA.scalarMultiply(scalar);
        System.out.println("Умножение вектора A на скаляр 2: " + scalarProduct);

        // Пример вычисления длины (нормы) вектора
        double length = vectorA.length();
        System.out.println("Длина (норма) вектора A: " + length);

        // Создание матрицы A 2x2
        Matrix A = new Matrix(2, 2);
        A.rows[0] = new int[]{1, 2};
        A.rows[1] = new int[]{3, 4};
        System.out.println("Matrix A:");
        System.out.println(A.toString());

        // Создание матрицы B 2x2
        Matrix B = new Matrix(2, 2);
        B.rows[0] = new int[]{2, 0};
        B.rows[1] = new int[]{1, 2};
        System.out.println("Matrix B:");
        System.out.println(B.toString());

        // Сложение матриц A и B
        Matrix C = A.add(B);
        System.out.println("Matrix A + B:");
        System.out.println(C.toString());

        // Вычитание матриц B из A
        Matrix D = A.subtract(B);
        System.out.println("Matrix A - B:");
        System.out.println(D.toString());

        // Умножение матриц A и B
        Matrix E = A.multiply(B);
        System.out.println("Matrix A * B:");
        System.out.println(E.toString());

        // Умножение матрицы A на скаляр
        int scalar3 = 3;
        Matrix F = A.scalarMultiply(scalar3);
        System.out.println("Matrix A * " + scalar3 + ":");
        System.out.println(F.toString());

        // Транспонирование матрицы A
        Matrix G = A.transpose();
        System.out.println("Matrix A Transpose:");
        System.out.println(G.toString());

        // Создание квадратной матрицы 3x3
        Matrix H = new Matrix(3, 3);
        H.rows[0] = new int[]{4, 3, 2};
        H.rows[1] = new int[]{1, 3, 1};
        H.rows[2] = new int[]{2, 1, 4};
        System.out.println("Matrix H:");
        System.out.println(H.toString());

        // Вычисление определителя матрицы H
        int det = H.determinant();
        System.out.println("Determinant of Matrix H:");
        System.out.println(det);

    }
}