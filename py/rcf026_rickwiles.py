# rickwiles attempt
import time
import math
print("The earth really ends where you started to roam.\n")


####################### LIBRARY SECTION ########################


def check(name, guess, answer=None):
    """Pretty print guesses and results when no answer is given."""
    if answer is None:
        print(f"{name} => {guess}")
    elif guess != answer:
        print(f"Incorrect answer for {name}")
        print(f"\tResult:  {guess}")
        print(f"\tAnswer:  {answer}")
    else:
        print(f"{name} ✓")


####################### SOLUTION SECTION #######################


def sum_natty_to(max):
    seive = [False] * max
    sum_of_naturals = 0

    for i in range(0, max, 3):
        seive[i] = True

    for i in range(0, max, 5):
        seive[i] = True

    for i in range(max):
        if seive[i]:
            sum_of_naturals = sum_of_naturals + i

    return sum_of_naturals


check("sum naturals 10", sum_natty_to(10), 23)
check("sum naturals 1000", sum_natty_to(1000))  # ✓✓✓


def fibby_eden(max_value):
    start_a = 1
    start_b = 1

    def fibby_recurse(a, b, _sum, _max):
        c = a + b

        if c > _max:
            return _sum

        if c % 2 == 0:
            _sum = _sum + c

        return fibby_recurse(b, c, _sum, _max)

    return fibby_recurse(start_a, start_b, 0, max_value)


check("fibby eden 10", fibby_eden(10), 10)
check("fibby eden 10", fibby_eden(4000000))  # ✓✓✓


def primes_to(x: int):
    """V1 - Returns an array of primes up to (x)"""
    seive = [True] * (x + 1)
    seive[0] = False
    seive[1] = False

    # For every indice, mark false, then mark every multiple false up to limit
    indice = 1
    while indice < x:
        indice = indice + 1
        second_indice = 2
        if not seive[indice]:
            continue
        product = indice * second_indice
        while product <= x:
            seive[product] = False
            second_indice = second_indice + 1
            product = indice * second_indice

    # Check indices and move to array.
    primes = []
    for i in range(x + 1):
        if seive[i]:
            primes.append(i)
    return primes


check("primez2 100", primes_to(50), [
      2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47])


def lipfactor(x: int):
    # Quit early, quit often
    if x < 2:
        return 0

    # Find smallest common denominator
    scd = 2
    while x % scd != 0 and scd < x:
        scd = scd + 1

    # Largest prime factor must be below scd
    # primes = primes_to(int(x / scd)) # MEMORY ERROR!
    # F***ing hate prime number questions, f*** this sh**

    return x


# check("lipfactor prompt", lipfactor(13195), 29)
# check("lipfactor prompt", lipfactor(600851475143))


def is_palindrome_v1(x: int) -> bool:
    """V1 - Takes a string and determines if it's a palindrome"""
    if not isinstance(x, str):
        x = str(x)
    if x[0] != x[-1]:
        return False
    if len(x) <= 2:
        return True
    return is_palindrome(x[1:-1])


def is_palindrome(x: int, base=None) -> bool:
    """V2 - Uses mathematics to extract first/last numbers"""
    if x == 0:
        return True
    if not base:
        base = 10**int(math.log(x, 10))
    first = int(x / base)
    last = int(x % 10)
    if not first == last:
        return False
    next_x = int((x - last - (first * base)) / 10)  # Chop off ends
    next_base = int(base / 100)  # We drop by two decimal places each iteration
    return is_palindrome(next_x, next_base)


# check("is pal? 8008", is_palindrome(8008), True)
# check("is pal? 238832", is_palindrome(238832), True)
# check("is pal? 23832", is_palindrome(23832), True)
# check("is pal? 3008", is_palindrome(3008), False)
# check("is pal? 8022", is_palindrome(8022), False)
# check("is pal? 87168", is_palindrome(87168), False)
# check("is pal? 1", is_palindrome(1), True)
# check("is pal? 12", is_palindrome(12), False)
# check("is pal? 230832", is_palindrome(230832), False)


def palinilap(_min, _max):
    biggest = 0
    for a in range(_min, _max):
        for b in range(_min, _max):
            product = a * b
            pali = is_palindrome(product)
            if pali and product > biggest:
                print(product)
                biggest = product

    return biggest


# check("palinderome len twodig", palinilap(10, 99), 9009)
# check("palinderome len twodig", palinilap(100, 999))  # ✓✓✓
