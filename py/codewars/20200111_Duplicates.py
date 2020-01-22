def unique_in_order(iterable):
    x = 0
    iterable = list(iterable)
    
    # O(n)
    while x < len(iterable) - 1:
        try:
            if( iterable[x] == iterable[x+1] ):
                iterable.pop(x+1)
            else:
                x = x + 1
                
        except IndexError:
            pass
            
    return iterable
