package threadingpool;
import java.util.Scanner;

import threadingpool.Task;
import threadingpool.ThreadPool;

public class Main {

	public static void main(String[] args) {

		int numOfThreads, numOfMatrices, matrixDimension;
		Scanner userInput = new Scanner(System.in);

		// get first input from user
		System.out.println("Pick a number between 2 and 20 (this number will represent the threads amount)");
		numOfThreads = Integer.parseInt(userInput.next());

		// initialize the thread pool with n threads
		ThreadPool pool = new ThreadPool(numOfThreads);

		while(true) {
			// get second input from user (number of matrices)
			System.out.println("Pick a number (at list 2 - this number will represent the matrices amount)");
			numOfMatrices = Integer.parseInt(userInput.next());

			// get third input from user (dimension)
			System.out.println("Pick a number (this number will represent the matrix dimention)");
			matrixDimension = Integer.parseInt(userInput.next());

			// temporary Matrix to calculate
			Matrix resultMatrix = new Matrix(matrixDimension);
			resultMatrix.setToIdentity();

			for (int i = 0; i < numOfMatrices; i++) {
				Task task = new Task(matrixDimension);
				task.setMatrix(resultMatrix);
				pool.execute(task);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				resultMatrix = task.getMatrix();
			}
			resultMatrix.printMatrix();
		}
	}
}