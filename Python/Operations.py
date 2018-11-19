def SubtractVectors(first, second):
    return [first[i]- second[i] for i in range(len(first))]

def MultiplyVectors(first, second):
    return sum([first[i]*second[i] for i in range(len(first))])

def MultiplyMatrixVector(matrix, vector):
    return [sum([vector[i]*matrix[i][j] for j in range(len(vector))]) for i in range(len(vector))]

def MultiplyMatrix(first, second):
    return [[sum([first[i][k]*second[k][j] for k in range(len(first))]) for j in range(len(first))] for i in range(len(first))]

def SumMatrix(first, second):
    return [[first[i][j] + second[i][j] for j in range(len(first))] for i in range(len(first))]

def SortMatrix(matrix):
    return [sorted([matrix[i][j] for j in range(len(matrix))], reverse = True) for i in range(len(matrix))]