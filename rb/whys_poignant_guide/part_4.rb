#!/usr/bin/env ruby
# Rubocop thing:
# frozen_string_literal: false

# So, I continue in my wGtR journey with the fourth chapter,
# 'Floating Little Leaves of Code' where Why covers stuff.
# Ruby looks nice in VSCode with the 'Monokai Dimmed' theme.

neato = true
falso = false

puts 'This single line is protected by the if at the end.' if neato
puts 'Also protected, but with' unless neato
puts 'Multiple. (corrected by rubocop)' unless falso || !neato

if neato == true
  x = 1 + 2
  puts "Alright, 1 + 2 = #{x}"
end

# if returns the last returned string.

something = if falso
              'it shouldn\'t be this.'
            else
              'it should be this.'
            end

puts something

does_not_exist = nil

puts 'DNE is not a thing' if does_not_exist.nil?
puts 'reasonable deal'.reverse

CODE_WORDS = {
  'starmonkeys' => 'Phil and Pete, those prickly chancellors of the New Reich',
  'catapult' => 'chucky go-go', 'firebomb' => 'Heat-Assisted Living',
  'Nigeria' => "Ny and Jerry's Dry Cleaning (with Donuts)",
  'Put the kibosh on' => 'Put the cable box on'
}.freeze

puts CODE_WORDS['catapult'].upcase
puts CODE_WORDS.[]('Nigeria')

puts 'Enter your evil plan: (Or hit enter and we\'ll read your mind)'

idea = gets
idea = 'Go to Nigeria and launch a firebomb with a catapult.' if idea.strip.empty?

CODE_WORDS.each do |real, code|
  # The exclamation mark makes gsub apply the changes directly to 'idea'
  idea.gsub!(real, code)
  # ...it's a destructive! method.
end

puts "I\'ve encrypted that for you:\n"
puts idea

File.open('idea.txt', 'w') do |f|
  f << idea
end

puts "\n...and saved it to idea.txt!!!!"

# Sample output:

# Enter your evil plan:
#   Go to Nigeria with starmonkeys and Put the kibosh on.
# I've encrypted that for you:
#   Go to Ny and Jerry's Dry Cleaning (with Donuts) with Phil
#   and Pete, those prickly chancellors of the New Reich and
#   Put the cable box on.

# See RDOC and RI for building out Ruby program documentation.

puts 'Uh, any other ruby programs in this directory?'

Dir['*.rb'].each do |f_name|
  puts f_name
end

puts '...neato.'

# Hashes & Arrays? Ruby thinks this is equivalent:

desk_objects =
  [name: 'pen', color: 'transparent'] +
  [name: 'ink bottle', color: 'blue'] +
  [name: 'watch', color: 'black']

# Behaves as [ { :name => 'watch' ... }, ... ]
# Skinny pipes around something = chute.

puts 'Sorted by color:'
desk_objects.sort_by { |item| item[:color] }.each { |item| puts item }

puts 'Sorted by name:'
desk_objects.sort_by { |item| item[:name] }.each { |item| puts item }

puts 'Only things that are not transparent:'
desk_objects.each do |item|
  next if item[:color] == 'transparent'

  puts item
end

puts 'Panic if something is blue:'
desk_objects.each do |item|
  break if item[:color] == 'blue'

  puts item
end

# Fin
exit
