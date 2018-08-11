# Ryan's Ruby Manual

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)

  View formatted manual on [ryanfleck.github.io/rb](https://ryanfleck.github.io/rb)
  

[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)
```ruby
puts "Hello, World!"
```


## What is Ruby?

In descriptors: high-level, object-oriented and interpreted. Ruby occupies a similar market space to *Python*, with both striving to create a more human-readable language. I'll update this as I learn more, with my primary resources being [Ruby Koans](http://rubykoans.com/) and [Codecademy](https://www.codecademy.com/courses/learn-ruby). In code blocks below, `#>` indicates text that is printed to the console.

## The Basics

### Data Types
```ruby
number = 18
boolean = true
string = "Hello"
```

### Console Output
```ruby
puts "String" #Appends a newline
print "String"
```
`puts` and `print` are used for output, the only difference being that `puts` appends a newline after printing the given string.

### Arithmetic
```ruby
x = (3 + 3) / 2 #Brackets
x = 3 ** 2 #Exponents
x = 3 / 3 #Division
x = 3 * 3 #Multiplication
x = 3 + 3 #Addition
x = 3 - 3 #Subtraction
x = 3 % 3 #Modulo
```
The only operation that may be foreign is *modulo*, which is the *remainder of a division*. For instance, running `128 / 13` will give 9, and `128 % 13` will give 11. Stepping backwards, `13 * 9` is 117, and adding 11 gives 128.

### Using Methods
```ruby
x = "String length".length
puts x #> 13
```
Methods without arguments (or to be invoked with only default arguments,) can be called without brackets `( )`.
```ruby
puts "RoFlMaO".upcase.reverse.downcase
#> oamlfor
```

### String Manipulation

**Reverse**
```ruby
x = "Ruby is interesting...".reverse
puts x #> ...gnitseretni si ybuR
```

**Upcase/Downcase**
```ruby
puts "Ruby is interesting...".upcase
#> RUBY IS INTERESTING...
puts "Ruby is interesting...".downcase
#> ruby is interesting...
```

### Basic Syntax
Comments can be included anywhere, and are formatted as follows:
```ruby
# Single line.

=begin
Multi-line.
=end
```

Names are all lowercase and words are separated with `_`.
```ruby
large_number = 7893425089273045
player_name = "Jimothy"
```

### Concept
Intro
```ruby
puts("Hello, World!")
```




## Section
Intro

### Concept
Intro
```ruby
puts("Hello, World!")
```




<!--
## Section
Intro

### Concept
Intro
```ruby
puts("Hello, World!")
```
-->
