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

	x := new(triangle) // This is a pointer to the triangle.
	x.Name = "Terrence"
	x.Vertices = []Point{
		Point{1, 1},
		Point{2, 2},
		Point{3, 1},
	}

	x.Show()
	fmt.Print("Perimeter: ")
	fmt.Println(x.Perimeter())

	y := new(triangle) // This is a pointer to the triangle.
	y.Name = "Terrence 2"
	y.Vertices = []Point{
		Point{1, 1},
		Point{2, 2},
		Point{3, 1},
	}

	z := new(square) // This is a pointer to the triangle.
	z.Name = "Squarrence 1"
	z.Vertices = []Point{
		Point{1, 1},
		Point{2, 2},
		Point{2, 1},
		Point{1, 2},
	}

	q := new(square) // This is a pointer to the triangle.
	q.Name = "Squarrence 1"
	q.Vertices = []Point{
		Point{1, 1},
		Point{2, 2},
		Point{2, 1},
		Point{1, 2},
	}

	shapies := [4]Shape{x, y, z, q}

	var totalPerimeter float64 = 0.0
	for _, tpi := range shapies {
		totalPerimeter += tpi.Perimeter()
		fmt.Print("Perimeter of: ")
		fmt.Println(tpi.Perimeter())
	}

	fmt.Print("Total Perimeter: ")
	fmt.Println(totalPerimeter)

}
