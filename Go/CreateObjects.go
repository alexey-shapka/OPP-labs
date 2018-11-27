package main

import (
	"math/rand"
	"time"
)

func CreateVector(size int, number int) []int{
	vector := make([]int, size)
	for i := 0; i < size; i++ {
		vector[i] = number
	}
	return vector
}

func CreateRandomVector(size int) []int{
	vector := make([]int, size)
	s1 := rand.NewSource(time.Now().UnixNano())
    r1 := rand.New(s1)
	for i := 0; i < size; i++ {
		vector[i] = r1.Intn(50)
	}
	return vector
}

func CreateMatrix(size int, number int) [][]int{
	matrix := make([][]int, size)
	for i := 0; i < size; i++ {
		matrix[i] = make([]int, size)
		for j := 0; j < size; j++ {
			matrix[i][j] = number
		}
	}

	return matrix
}

func CreateRandomMatrix(size int) [][]int{
	matrix := make([][]int, size)
	s1 := rand.NewSource(time.Now().UnixNano())
    r1 := rand.New(s1)
	for i := 0; i < size; i++ {
		matrix[i] = make([]int, size)
		for j := 0; j < size; j++ {
			matrix[i][j] = r1.Intn(50)
		}
	}

	return matrix
}