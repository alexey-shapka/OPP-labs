import java.lang.reflect.Array;

class operations {

    public float[] SubVectors(float[] first, float[] second){
        int size = Array.getLength(first);
        float[] result = new float[size];

        for (int i = 0; i < size; i++) {
            result[i] = first[i] - second[i];
        }

        return result;
    }

    public float MultiplyVectors(float[] first, float[]second){
        int size = Array.getLength(first);
        float result = 0;

        for(int i=0; i<size; i++){
            result+=first[i]*second[i];
        }

        return result;
    }

    public float[] MultiplyMatrixVector(float[][] mat, float[] vec){
        int size = Array.getLength(vec);
        float[] result = new float[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i] += vec[i] * mat[i][j];
            }
        }

        return result;
    }

    public float[][] MultiplyMatrix(float[][] first, float[][] second){
        int size = Array.getLength(first);
        float[][] result = new float[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {

                    result[i][j] += first[i][k] * second[k][j];

                }
            }
        }

        return result;
    }

    public float[][] SumMatrix(float[][] first, float[][] second){
        int size = Array.getLength(first);
        float[][] result = new float[size][size];

        for (int i = 0; i < size; i++) {
            for (int j=0; j<size; j++){
                result[i][j] = first[i][j] + second[i][j];
            }
        }

        return result;
    }

    public float[][]  SortMatrix(float[][] mat){
        int size = Array.getLength(mat);
        
        int check = 1;

        while(check!=0){
            check=0;
            for(int i=0; i<size; i++){
                for(int j=0; j<size-1; j++){
                    if(mat[i][j]<mat[i][j+1]){
                        float memory = mat[i][j];
                        mat[i][j] = mat[i][j+1];
                        mat[i][j+1] = memory;
                        check+=1;
                    }
                }
            }
        }
        return mat;
    }

}
    