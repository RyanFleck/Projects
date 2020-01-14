def solution(number):
  numbers = [None] * number
  total = 0
  
  x=5
  while( x < number ):
    numbers[x] = 1
    x = x + 5
  
  y=3
  while( y < number ):
    numbers[y] = 1
    y = y + 3
    
  for z in range(len(numbers)):
    if( numbers[z] == 1 ):
      total = total + z
      
  return total 
        
