package LinAlg;

import java.util.Scanner;

public class TestMatrixVectorD {

    // check almost equality between double values
    private static boolean almost_equals(double x, double y, double tol) {
      return Math.abs(x-y) <= tol * Math.abs(x+y);
    }
  
    // overload of the almost_equals method without a tolerance argument
    private static boolean almost_equals(double x, double y) {
      return almost_equals(x,y,1.e-15);
    }
  
  
    /// Check some methods of the matrix, assuming it is given as in the main() method
    private static void testMatrix(MatrixD A) {
      assert A.getRowCount() == 2;
      assert A.getColCount() == 2;
  
      MatrixD At = A.transpose();
      assert A.getRowCount() == At.getColCount();
      assert A.getColCount() == At.getRowCount();
  
      assert At.transpose().equals(A);
    }
  
    /// Check some methods of the vectors, assuming they are given as in the main() method
    private static void testVector(VectorD x, VectorD b) {
      assert x.getSize() == 2;
      assert b.getSize() == 2;
  
      VectorD xb = x.add(b);
      assert xb.getSize() == x.getSize();
  
      assert b.add(x).equals(xb);
  
      double d = x.dot(b);
      assert almost_equals(d, 14.0);
  
      double n = x.norm();
      assert almost_equals(n, Math.sqrt(x.dot(x)));
    }
  
    /// Check the interaction of matrix and vector
    private static void testMatrixVector(MatrixD A, VectorD x, VectorD b) {
      assert A.getColCount() == x.getSize();
      assert A.getRowCount() == b.getSize();
  
      // A is identity matrix
      assert A.mul(x).equals(x);
      assert A.mul(b).equals(b);
  
      VectorD r = b.sub(A.mul(x));
      assert r.getSize() == b.getSize();
  
      VectorD r0 = x.sub(A.mul(x));
      VectorD zero = new VectorD(2);
      double[] elem = new double[2];
      elem[0] = 0.0;
      elem[1] = 0.0;
      zero.setElem(elem);
      assert r0.equals(zero);
    }
  
  
    public static void main(String[] args) {
      // Assume we can access the data of the matrix directly, i.e., it is package-private
  
      Scanner scanner = new Scanner(System.in);
      MatrixD A = new MatrixD(2,2);
      double[][] elem = new double[2][2]; 
      elem[0][0] = 1.0;
      elem[0][1] = 0.0;
      elem[1][0] = 0.0;
      elem[1][1] = 1.0;
      A.setElem(elem);
  
      VectorD x = new VectorD(2);
      double[] array = new double[2];
      array[0] = 4.0;
      array[1] = 2.0;
      x.setElem(array);
  
      VectorD b = new VectorD(2);
      double[] input = new double[2];
      input[0] = 2.0;
      input[1] = 3.0;
      b.setElem(input);
  
      testMatrix(A);
      testVector(x,b);
      testMatrixVector(A,x,b);
      scanner.close();
    }
  }  