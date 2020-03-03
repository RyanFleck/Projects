/* 1. Package declaration.
 *
 * All go programs run in packages; the main package is the first entry point
 * of a go program.
 */
package main

/* 2. Import packages.
 *
 * Tells the preprocessor to include files in package 'fmt'.
 * Allows calling of functions like fmt.Println().
 *
 * Interestingly,
 *  a function is exported if the function name starts with a capital.
 */
import "fmt"

/* 3. Main function.
 * of a go program.
 */
func main() {
	fmt.Println("Hello, World!")
}

/* Wow! A Go program!
 * Run by executing:
 *   dnf install golang
 *   go run rcf001_HelloWorld.go
 *
 * Alternatively, compile the package in the current dir with:
 *   go build
 *
 * Interestingly, it is EZ to 'keep' programs with
 *   go install
 *
 * ( From Fedora docs: )
 * These programs are located in $GOPATH/bin, but it's easy to run them without
 * the 'go' command by exporting the directory path to your PATH:
 *   $ echo 'export PATH=$PATH:$GOPATH/bin' >> $HOME/.bashrc
 *   $ source $HOME/.bashrc
 *   $ hello
 *   Hello, Fedora!
 */
