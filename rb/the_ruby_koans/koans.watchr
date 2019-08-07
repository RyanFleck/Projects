watch( '.*\.rb' ) do
  puts "\n" * 20
  system 'rake'
  puts "\n" * 20
end
