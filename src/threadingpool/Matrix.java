package threadingpool;
import java.util.concurrent.ThreadLocalRandom;


public class Matrix {
	// var's
	private int size;
	private long[][] data;

	// constructor
	public Matrix(int size) {		
		this.size = size;
		this.data = new long[size][size];
		this.randomNumber();
	}

	// picking random number between 1 to 10 & assign values
	public void randomNumber() {
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				this.data[i][j] = ThreadLocalRandom.current().nextLong(0,10) + 1;
			}
		}
	}

	// print matrix
	public void printMatrix() {
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				System.out.printf("%d\t\t", this.data[i][j]);
			}
			System.out.printf("\n");
		}
		System.out.println();
	}

	// set to identity matrix
	public void setToIdentity() {
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				if(i == j) 
					this.data[i][j] = 1;
				else 
					this.data[i][j] = 0;
			}
		}
	}

	// set the matrix on zero
	public void setOnZero() {
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				this.data[i][j] = 0;
			}
		}
	}

	// multiply matrices
	public Matrix multiplyMatrix(Matrix m1) {
		
		// initialize the result matrix with 0's
		Matrix matrix = new Matrix(this.size);	
		matrix.setOnZero();

		// multiply the matrices (this & m1)
		for(int i = 0; i < matrix.size; i++) {
			for(int j = 0; j < matrix.size; j++) {
				for(int k = 0; k < matrix.size; k++) {
					matrix.data[i][j] += this.data[i][k] * m1.data[k][j];
				}
			}
		}

		return matrix;
	}

}
