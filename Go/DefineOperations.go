package main

import "sort"

func SubVectors(first []int, second []int) []int{
	for i := 0; i < len(first); i++ {
		first[i] = first[i] - second[i]
	}
	return first
}

func MultiplyVectors(first []int, second []int) int{
	result := 0
	for i := 0; i < len(first); i++{
		result += first[i]*second[i]
	}
	return result
}

func MultiplyMatrixVector(matrix [][]int, vector []int) []int{
	result := make([]int, len(vector))
	for i := 0; i < len(vector); i++{
		for j := 0; j < len(vector); j++{
			result[i] += vector[i]*matrix[i][j]
		}
	}
	return result
}

func MultiplyMatrix(first [][]int, second [][]int) [][]int{
	result := make([][]int, len(first))
	for i := 0; i < len(first); i++{
		result[i] = make([]int, len(first))
		for j := 0; j < len(first); j++{
			for k :=0; k < len(first); k++{
				result[i][j] += first[i][k]*second[k][j]
			}
		}
	}
	return result
}

func SumMatrix(first [][]int, second [][]int) [][]int{
	for i := 0; i < len(first); i++ {
		for  j:=0; j < len(first); j++{
		    first[i][j] = first[i][j] + second[i][j];
		}
	}
	return first
}

func  SortMatrix(matrix [][]int) [][]int{
	for i := 0; i < len(matrix); i++{
		sort.Sort(sort.Reverse(sort.IntSlice(matrix[i])))
	}
	return matrix
}