# Programming in Ruby

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/rb](https://ryanfleck.github.io/rb)
  

[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)
```ruby
puts "Hello, World!"
```


<br />



<br />

## What is Ruby?

In descriptors: high-level, object-oriented and interpreted. Ruby occupies a similar market space to *Python*, with both striving to create a more human-readable language. I'll update this as I learn more, with my primary resources being [Ruby Koans](http://rubykoans.com/) and [Codecademy](https://www.codecademy.com/courses/learn-ruby). In code blocks below, `#>` indicates text that is printed to the console.

## Why I am Writing Programs in Ruby

I'm not, really; it seems like a fun language with lots of respected devs. I don't have time to learn or tinker with this very flexible scripting lang at the moment. At one point in early 2019, I spent a short, intense period binge-learning C++, then Ruby, in order to meet requirements and complete technical interviews at C++/Ruby shops.

<br />

## The Basics

Running `ruby -v` will print your ruby version. If you have a 'good' OS, you should have a version built in. Upgrade if the version is less than 2. `ruby` runs ruby programs. `irb` starts an interactive ruby prompt.

On Debian, it is best to add `/.gem/ruby/2.3.0/bin` to your PATH in `~/.profile`, and `gem: --user-install` to your `~/.gemrc`. Be careful not to run gem, bundle, etc as root.

Adding this user bin to your PATH makes it easy to use tools like [RuboCop](https://rubocop.readthedocs.io/en/latest/) (`gem install rubocop`) to `rubocop --fix-layout *.rb` your ruby files. 

**Resources:**
1. Ruby: [Why's Poignant Guide](https://poignant.guide/book/)
1. Rails: [Rails Guides](https://guides.rubyonrails.org/) and [railstutorial.org](https://www.railstutorial.org/book/beginning) are good.
1. [Ruby Koans](http://rubykoans.com/)
1. [The Odin Project](https://www.theodinproject.com/courses)


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

## MongoDB

After installing MongoDB and loading <http://media.mongodb.org/zips.json> into the database, (or another from <https://github.com/ozlerhakan/mongodb-json-files>,)


<!--
## Section
Intro

### Concept
Intro
```ruby
puts("Hello, World!")
```
-->
