package main

import(
    "flag"
    "fmt"
    // "os"
)

// flag library : https://golang.org/pkg/flag/

func main(){
    a := flag.Bool("a", false, "Sample flag A.")
    b := flag.Bool("b", false, "Sample flag A.")
    c := flag.Bool("c", false, "Sample flag A.")
    flag.Parse();
    fmt.Println("a has value ", *a)
    fmt.Println("b has value ", *b)
    fmt.Println("c has value ", *c)
}
