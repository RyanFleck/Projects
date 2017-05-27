#!/usr/bin/env ruby

#Ryan Fleck - Ruby learning file.

#SECTION ONE: Variables.

name = "Ryan"
currentYear = 2017

#SECTION TWO: Basic classes and methods.

#My first class.
class Human
	def initialize(name="Unnamed",age="Unknown",gender="Genderless")
		@name=name
		@age=age
		@gender=gender
	end
	def hello
		puts "Hello, my name is #{@name}. I am #{@age} years old."
	end
	def age
		puts "#{@name} grew older..."
		@age+=1
	end
end
	
	
	
#SECTION THREE: Application of basic classes and methods written above.
if __FILE__ == $0

	#Printing is easy.
	puts "Ruby. Test."
	
	#Friggin' breezy text insertion:
	puts "Name:#{name} \nYear:#{currentYear}"
	
	
	
	#Initialize a human:
	paul = Human.new("Paul",37,"Male")
	paul.hello
	paul.age
	paul.age
	paul.hello
	
	#Useful for debugging:
	#puts "\nList instance methods for Humans:"
	#puts Human.instance_methods
end
	
	

