package fr.epita.assistants.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Double> {
    final private double[][] matrix;
    final private int xLowerBound;
    final private int xUpperBound;
    final private int yLowerBound;
    final private int yUpperBound;

    public MyRecursiveTask(double[][] matrix, int xLowerBound, int xUpperBound, int yLowerBound, int yUpperBound) {
        this.matrix = matrix;
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
        this.yUpperBound = yUpperBound;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Double compute() {
        int xLen = xUpperBound - xLowerBound;
        int yLen = yUpperBound - yLowerBound;

        if (xLen <= 0 || yLen <= 0)
            return 0.;

        if (xLen <= 5 && yLen <= 5) {
            double ret = 0.;
            for (int i = xLowerBound; i < xUpperBound; i++) {
                for (int j = yLowerBound; j < yUpperBound; j++) {
                    ret += matrix[i][j];
                }
            }

            return ret / (xLen * yLen);
        }

        int xMid = xLowerBound + xLen / 2;
        int yMid = yLowerBound + yLen / 2;

        MyRecursiveTask one = new MyRecursiveTask(matrix, xLowerBound, xMid, yLowerBound, yMid);
        MyRecursiveTask two = new MyRecursiveTask(matrix, xMid, xUpperBound, yLowerBound, yMid);
        MyRecursiveTask three = new MyRecursiveTask(matrix, xLowerBound, xMid, yMid, yUpperBound);
        MyRecursiveTask four = new MyRecursiveTask(matrix, xMid, xUpperBound, yMid, yUpperBound);

        one.fork();
        two.fork();
        three.fork();

        return (four.compute() + one.join() + two.join() + three.join()) / 4.;
    }
}