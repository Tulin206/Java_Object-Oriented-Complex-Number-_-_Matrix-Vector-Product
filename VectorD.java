package LinAlg;

import java.util.Scanner;

public class VectorD {
    private static Scanner scanner;
    private int size;


    //Store the vector elements in a one-dimensional (non-public) array of type double.
    private double [] elem;

    //constructor
    //read the number of size as well as the vector entries from keyboard input.
    public VectorD(){
      this(true);
    }

    //with passed number of size.
    public VectorD (int size){
      this.size = size;
      this.elem = new double [size];
    }

    //with passed number of array size. 
    //If the argument keyboardIn is true, read the vector entries from keyboard input.
    public VectorD(int size, boolean keyboardIn){
      this(size);
      if(keyboardIn == true){
        readVector();
      }
    }

    //read the number of rows and columns from keyboard input. 
    //If the argument keyboardIn is true, read the matrix entries(row-wise) from keyboard input.
    public VectorD(boolean keyboardIn){
      System.out.print("Enter the number of size: "); 
      this.size = scanner.nextInt();
      if(keyboardIn){
        readVector();
      }
    }

    //Method for input
    public void readVector(){
      this.elem = new double [size];
      System.out.println("Enter the elements of the array: ");
      for (int i=0; i<elem.length; i++){
        elem [i] = scanner.nextDouble();
      }
    }

    public int getSize() {
      return size;
    }

    public void setSize(int size) {
      this.size = size;
    }

    public double[] getElem() {
      return elem;
    }

    public void setElem(double[] elem) {
      this.elem = elem;
    }

    //Method to compute the Euclidean inner product
    public double dot(VectorD other){
      double sum = 0;
      if (this.size == other.size){
        for (int i=0; i<elem.length; i++){
          sum = sum + (this.elem[i] * other.elem[i]);
        }
      }
      return sum;
    }

    public double norm (){
      double sum = 0;
      double normalize;
      for (int i=0; i<elem.length; i++){
        sum = sum + (this.elem [i] * this.elem[i]);
      }
      normalize = Math.sqrt(sum);
      return normalize;
  }

  public VectorD add(VectorD other){
    VectorD temp = new VectorD(this.size);
    if (this.size == other.size){
      for (int i=0; i<elem.length; i++){
          temp.elem[i] = this.elem[i] + other.elem[i];
      }
    } else {
      System.out.println("Vectors are not equal");
    }
    return temp;
  }


  public VectorD sub(VectorD other){
    VectorD temp = new VectorD(this.size);
    if (this.size == other.size){
      for (int i=0; i<elem.length; i++){
          temp.elem[i] = this.elem[i] + other.elem[i];
      }
    } else {
      System.out.println("Vectors are not equal");
    }
    return temp;
  }
}