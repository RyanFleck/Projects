package main

import (
	"fmt"
	"math"
)

type Point struct {
	X float64
	Y float64
}

func Distance(p1 Point, p2 Point) (distance float64) {
	distance = math.Sqrt(math.Pow(p1.X-p2.X, 2.0))
	return
}

type Shape interface {
	Perimeter() float64
	Show()
}

type shape struct {
	Name     string
	Vertices []Point
}

type square struct {
	shape
}

type triangle struct {
	shape
}

func (t triangle) Show() {
	fmt.Println(t.Name)
}

func (t triangle) Perimeter() float64 {
	var perimeter float64 = 0.0
	for i := 0; i < 3; i++ {
		perimeter += Distance(t.Vertices[i], t.Vertices[(i+1)%3])
	}
	return perimeter
}

func (s square) Show() {
	fmt.Println(s.Name)
}

func (s square) Perimeter() float64 {
	var perimeter float64 = 0.0
	for i := 0; i < 3; i++ {
		perimeter += Distance(s.Vertices[i], s.Vertices[(i+1)%4])
	}
	return perimeter
}

// MAIN

func main() {
	fmt.Println("Hello, World!")
	done := make(chan bool)
	shapeChannel := make(chan triangle, 3)

	go processor(shapeChannel, done)

	for j := 1; j <= 10; j++ {
		shapeChannel <- triangle{}
	}

	<-done
}

func processor(shapes chan triangle, done chan bool) {
	triangle, more := 
	for {
		done <- true
		return
	}

}
