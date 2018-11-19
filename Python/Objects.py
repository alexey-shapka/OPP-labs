import random

def CreateMatrix(size, number):
    return [[number for _ in range(size)] for _ in range(size)] 

def CreateRandomMatrix(size):
    return [[random.randint(1,50) for _ in range(size)] for _ in range(size)] 

def CreateVector(size, number):
    return [number for _ in range(size)]

def CreateRandomVector(size):
    return[random.randint(1,50) for _ in range(size)]