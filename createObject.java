 class createObject {

    public float[] CreateRandomVector(Integer size) {
        float[] v = new float[size];
        for (int i = 0; i < size; i++) {
            v[i] = (float)(Math.random() * 50.0);
        }
        return v;
    }

    public float[] CreateVector(Integer size, Integer number){
        float[] v = new float[size];
        for (int i=0; i<size;i++){
            v[i] = (float) number;
        }
        return v;
    }

    public float[][] CreateRandomMatrix(Integer size){
        float[][] m = new float[size][size];
        for (int i=0; i<size; i++){
            m[i] = CreateRandomVector(size);
        }
        return m;
    }

    public float[][] CreateMatrix(Integer size, Integer number){
        float[][] m = new float[size][size];
        for (int i=0; i<size; i++){
            m[i] = CreateVector(size, number);
        }
        return m;
    }
}