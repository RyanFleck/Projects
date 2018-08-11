#!/usr/bin/env ruby

# Implement Class

class Greeter
  
  def initialize( name="World" )
    @name = name
  end

  def say_hi
    puts "Hi #{@name}!"
  end

  def say_bye
    puts "Bye, #{@name}, come again soon!"
  end

end

greet = Greeter.new("Mark")

puts("Test greeter methods...")
greet.say_hi
greet.say_bye

#puts(Greeter.instance_methods)

puts("Inspect and augment greeter...")
for element in ["name","say_hi","say_bye","to_s","yell"] do
  puts("Responds to #{element}? #{greet.respond_to?(element)}")
end

# Update Class

class Greeter
  attr_accessor :name
end

greet.name="John"  
puts("Test greeter methods again...")
greet.say_hi
greet.say_bye
