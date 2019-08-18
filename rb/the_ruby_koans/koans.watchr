watch( '.*\.rb' ) do
  puts "\n" * 10
  system 'rake'
  puts "\n" * 10
end
