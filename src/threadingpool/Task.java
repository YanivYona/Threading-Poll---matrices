package threadingpool;

public class Task implements Runnable {

	private Matrix matrix_0;
	private Matrix matrix_1;

	public Task(int dimension) {
		this.matrix_0 = new Matrix(dimension);
		this.matrix_1 = new Matrix(dimension);
	}

	public void setMatrix(Matrix matrix) {
		// matrix for first calculation
		this.matrix_0 = matrix;
	}

	public Matrix getMatrix() {
		return this.matrix_0;
	}

	public void run() {
		this.matrix_0 = this.matrix_0.multiplyMatrix(this.matrix_1);
//		this.matrix_1.printMatrix();	// turn on to see the multiplications between the actual matrices 
	}
}