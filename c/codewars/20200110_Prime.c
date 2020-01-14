#include <stdbool.h>

bool is_prime(int num)
{
    if( num < 0 )
        return false;
        
    if( num == 0 || num == 1 )
        return false;
        
    int test_f = (num/2);
    float test_b = 2.0;
    
    for( ; test_b <= test_f ; test_b++ ){
        float x = num / test_b;
        if( floorf(x) == x ){
            return false;
        }
    }
    return true;
}
