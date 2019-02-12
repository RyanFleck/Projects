package main

import(
    "flag"
    "fmt"
    // "os"
)

// flag library : https://golang.org/pkg/flag/

var stringvar   string
var intvar      int

func main(){

    // Simple boolean flags:
    a := flag.Bool("a", false, "Sample flag A.")
    b := flag.Bool("b", false, "Sample flag A.")
    c := flag.Bool("c", false, "Sample flag A.")

    // String and int flags:
    d := flag.String("file", "", "file to parse.")
    e := flag.Int("amount", 12, "Number of repeats.")

    flag.StringVar(&stringvar, "name", "", "name to search for.")
    flag.IntVar(&intvar, "double", 0, "number to double.")

    flag.Parse();
    fmt.Println("a has value ", *a)
    fmt.Println("b has value ", *b)
    fmt.Println("c has value ", *c)
    fmt.Println("file has value", *d)
    fmt.Println("repeating", *e, "times.")
    fmt.Println("name is ",stringvar)
    fmt.Println(intvar, "multiplied by 2 is", (intvar*2))
}
