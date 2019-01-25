#!/usr/bin/env ruby

name = 'Ryan'
currentYear = 2019 # Two years since RCF001.rb!

class Customer 
  attr_accessor :name # Allows class vars to be accessed.
  def initialize(name = 'Unnamed', age = 'Unknown', gender = 'Not specified.')
    @name = name
    @age = age
    @gender = gender
    @id = 0  #TODO: Learn how to generate random numbers.
  end

  def hello
    puts "Hello, my name is #{@name}. I am #{@age} years old."
  end

  def age
    puts "#{@name} grew older..."
    @age += 1
  end
end

class BeerGlass
    attr_accessor :drinks_poured

class Machine
  def initialize(items = 'Empty'); end
end

# SECTION THREE: Application of basic classes and methods written above.
if $PROGRAM_NAME == __FILE__

  # Printing is easy.
  puts 'Ruby. Test.'

  # Friggin' breezy text insertion:
  puts "Name:#{name} \nYear:#{currentYear}"

  # Initialize a human:
  paul = Human.new('Paul', 37, 'Male')
  paul.hello
  paul.age
  paul.age
  paul.hello
  puts paul.name

  # Useful for debugging:
  # puts "\nList instance methods for Humans:"
  # puts Human.instance_methods
end
