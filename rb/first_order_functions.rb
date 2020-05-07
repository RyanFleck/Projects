#!/usr/bin/env ruby

puts "First order function test"

def func_a(str)
	puts "Func A acted on #{str}"
end

def func_b(str)
	puts "Func B acted on #{str}"
end

[method(:func_a), method(:func_b)].each{ |func|
	func.call("test")
}