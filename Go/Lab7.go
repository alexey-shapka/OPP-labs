/* ==========================================
Основи Паралельного програмування
Лабораторна робота №7
Потоки в мові програмування Go
F1: d  = (B * C) + (A * B) + (C * (B * (MA * ME)))
F2: MF = (MG * MH) * (MK + ML)
F3: S  = SORT(MS * MT) * O - P
Шапка Олексій Володимирович ІО-62
дата: 26.11.2018
========================================== */

package main

import (
	"fmt"
	"sync"
	"time"
)

var wg sync.WaitGroup

func main() {
	fmt.Println("Main thread started...")
	wg.Add(3)
	go Function1(4, 3000)
	go Function2(4, 1400)
	go Function3(4, 2000)
	wg.Wait()
	fmt.Println("Main thread fininshed.")
}

func Function1(size int, sleep time.Duration) {
	fmt.Println("Thread 1 started...")
	A := CreateVector(size, 1)
	B := CreateVector(size, 1)
	C := CreateVector(size, 1)
	MA := CreateMatrix(size, 1)
	ME := CreateMatrix(size, 1)
	time.Sleep(sleep * time.Millisecond)
	Result := MultiplyVectors(B, C) + MultiplyVectors(A, B) + MultiplyVectors(MultiplyMatrixVector(MultiplyMatrix(MA, ME), B), C)
	fmt.Println(fmt.Sprintf("Function 1 result:\n%d", Result))
	wg.Done()
}

func Function2(size int, sleep time.Duration) {
	fmt.Println("Thread 2 started...")
	MG := CreateMatrix(size, 2)
	MH := CreateMatrix(size, 2)
	MK := CreateMatrix(size, 2)
	ML := CreateMatrix(size, 2)
	time.Sleep(sleep * time.Millisecond)
	Result := MultiplyMatrix(MultiplyMatrix(MG, MH), SumMatrix(MK, ML))
	fmt.Println(fmt.Sprintf("Function 2 result:\n%v", Result))
	wg.Done()
}

func Function3(size int, sleep time.Duration) {
	fmt.Println("Thread 3 started...")
	O := CreateVector(size, 3)
	P := CreateVector(size, 3)
	MS := CreateMatrix(size, 3)
	MT := CreateMatrix(size, 3)
	time.Sleep(sleep * time.Millisecond)
	Result := SubVectors(MultiplyMatrixVector(SortMatrix(MultiplyMatrix(MS, MT)), O), P)
	fmt.Println(fmt.Sprintf("Function 3 result:\n%v", Result))
	wg.Done()
}
