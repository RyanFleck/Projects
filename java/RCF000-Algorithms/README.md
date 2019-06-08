# Algorithms

I'll try to complete a few Java programming puzzles a week.
Puzzles sourced from popular sites like leetcode, hackerrank, euler.
Each puzzle has an accompanying set of JUnit tests to ensure simple and complex test cases pass.
Common operations, like functions dealing with prime numbers, are stored in the utils package.

**Goal 1**: Complete 100 problems before the end of the semester, roughly one problem per day.

### Revision History

1. **20190601** Multiples of 3 and 5
1. **20190601** Even Fibonacci Numbers, along with array utils.
1. **20190601** Largest Prime Factor, along with prime utils.
1. **20190602** Palindrome problem
1. **20190607** Multiples problems

### How To Run the Algos

At the time of writing, very near the beginning of this project, algorithms are all
contained in the `com.rcf.algorithms` package. The algorithms are tested with JUnit,
and can be run independently in eclipse, or all together with `mvn test`. Currently,
test output appears as in the console example below. *JUnit is great.*

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.rcf.algorithms.PrimeFactorTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.117 sec
Running com.rcf.algorithms.utils.PrimeUtilTest
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running com.rcf.algorithms.utils.ArrayUtilTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running com.rcf.algorithms.MultiplesTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec
Running com.rcf.algorithms.FibonacciTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running com.rcf.algorithms.PalindromeTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.096 sec

Results :

Tests run: 19, Failures: 0, Errors: 0, Skipped: 0
```

To run the algorithms in another project, simply include the compiled 
JAR (run `mvn install`) as a maven dependency.