#!/usr/bin/env ruby
# frozen_string_literal: true

# Er, so I have a reason to learn Ruby now. So I figured I'd
# take a quick read through Why's Poignant Guide and see what
# was up with Ruby which, supposedly, is designed with human
# happiness in mind. Worth a shot. Good to have another tool
# on my toolbelt.

# Canonical first test.
puts 'Hello, world!'
# Numbers have methods? What is this? (Anything in {} is a block.)
3.times { puts 'Odelay!' }

# Rubocop autocorrects the array of words here... neat.
%w[toast hummus celery tomato].each { |food| puts 'eat some ' + food }

# Variables (Use underscores to make big numbers easy to read.)
banana_phone = 3
use_some_underscores = 4_000_000
no_other_punctuation = 3.14
# Globals start with $, symbols start with :, instance variables use @,
# class vars use @@. Phew!

puts banana_phone + use_some_underscores + no_other_punctuation

hello_world = 'Hello, World!'
puts "'#{hello_world}' is #{hello_world.length} chars long."

# Ranges (x..y) returns different things for x and y:

print "\nA to Z: "
('a'..'z').each { |letter| print letter }

print "\n0 to 5: "
(0..5).each { |number| print number }

print "\n0 to 4: "
(0...5).each { |number| print number }
puts ''

# Arrays & Hashes
some_array = %w[one more time]
some_array.each { |x| puts x }
some_hash = { 'o' => 'one', 'm' => 'more', 't' => 'time' }
some_hash.each do |k, v|
  puts "Key #{k}, value #{v}"
end

# Libraries
require 'net/http'
puts "\nRuby License:\n"
Net::HTTP.start('www.ruby-lang.org', 80) do |http|
  puts(http.get('/en/about/license.txt').body)
end

# Fin.
exit
