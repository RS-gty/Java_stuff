package linalg.matrix;

import linalg.Vector3d;

public class Matrix3d {
    public double[][] matrix = new double[3][3];
    private int nset = 0;

    public Matrix3d() {}
    public Matrix3d addColumn(double n1, double n2, double n3){
        double[] args = {n1, n2, n3};
        if (nset < 3){
            for (int i = 0; i < 3; i++){
                matrix[nset][i] = args[i];
            }
            nset += 1;
        } else{
            throw new ArrayIndexOutOfBoundsException();
        }
        return this;
    }
    public Vector3d multiply(Vector3d v) {
        double[] nums = new double[3];
        for (int i = 0; i < 3; i++) {
            double result = 0;
            for (int j = 0; j < 3; j++) {
                result += this.matrix[i][j] * v.array[j];
            }
            nums[i] = result;
        }
        return new Vector3d(nums);
    }
}
