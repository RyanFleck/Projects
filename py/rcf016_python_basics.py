#!/usr/bin/python3

# Refreshing my memory, had a sea change in thinking after spending
# two days diving into Ruby to see what all the fuss was about;
# developer productivity can come before machine efficiency.
# Python has a greater set of use cases than Ruby.

import sys
import random

# The canonical beginner's program.
print('Hello, Python!')


def teenyREPL():
    '''Runs a tiny read-evaluate-print loop looking for the exit cmd'''

    def respond(text):
        print('\t' + text)

    while True:
        x = input('\n> ')
        respond('executing \'' + x.upper() + '\'')
        respond('command length: ' + str(len(x)))
        respond('token groups: ' + str(len(x.split())))
        if(x.startswith('exit')):
            respond('exiting...')
            break
        elif(x.startswith('kill')):
            sys.exit()

# teenyREPL()

# Oh, it'd be good to write a telegram bot that used a REPL for its
# testing interface, rather than having to upload to Heroku first.


# Ranges
range_arr = []
for x in range(10):
    range_arr = range_arr + [x]

print(range_arr)


# Example: Global Variables


spam = 0


def addToSpam():
    global spam
    spam = spam + 1


addToSpam()
addToSpam()
print(spam)

# Example: Exception Handling


def divide42by(num):
    '''Attempts to divide 42 by the argument num'''
    try:
        return 42 / num
    except ZeroDivisionError:
        print('I\'m afraid I can\'t do that, Dave.')
        return 0


print(divide42by(3))
print(divide42by(0))


def numberGame():
    '''Begins a small number guessing game with user.'''
    low = 0
    high = 10
    print('Guess my number between ' + str(low) + ' and ' + str(high) + '!')
    number = random.randint(low + 1, high - 1)

    def ensureRandomness(lo_bound, hi_bound):
        total = 0
        iterations = 100000
        for test in range(iterations):
            total = total + random.randint(lo_bound + 1, hi_bound - 1)

        print('Average (' + str(iterations) + ' iterations) is: ' +
              str(total / iterations))

    ensureRandomness(low, high)

    # print('(answer is '+str(number)+')')

    def guess(gum):
        if(gum > number):
            print('Too high.')
            return False
        elif(gum < number):
            print('Too low.')
            return False
        else:
            return True

    while True:
        x = input('> ')
        try:
            if(guess(int(x))):
                print('Good job!')
                break
        except ValueError:
            print('Please enter a number this time.')

        if(x.startswith('exit')):
            print('Exiting...')
            break


numberGame()
