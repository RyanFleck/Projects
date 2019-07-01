#!/usr/bin/python3

# Refreshing my memory, had a sea change in thinking after spending
# two days diving into Ruby to see what all the fuss was about;
# developer productivity can come before machine efficiency.
# Python has a greater set of use cases than Ruby.

import sys
import random
import copy


def helloWorld():
    '''The canonical beginner's program.'''
    print('Hello, Python!')

# helloWorld()


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


def ranges():
    '''Shove a range into an array (probably an easier way to do this.)'''
    range_arr = []
    for x in range(10):
        range_arr = range_arr + [x]

    print(range_arr)


# Example: Global Variables


spam = 0


def globalVars():
    def addToSpam():
        global spam
        spam = spam + 1

    addToSpam()
    addToSpam()
    print(spam)

# globalVars()


def exceptionHandling():
    '''Play with simple exception handling.'''
    def divide42by(num):
        '''Attempts to divide 42 by the argument num'''
        try:
            return 42 / num
        except ZeroDivisionError:
            print('I\'m afraid I can\'t do that, Dave.')
            return 0

    print(divide42by(3))
    print(divide42by(0))

# exceptionHandling()


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
        '''Checks the user guess (gum) against the stored answer (number)'''
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


# numberGame()

def pythonsFamousLists():
    '''Tinker with lists.'''
    strings = ['lead pipe', 'revolver', 'candlestick', 'rope']
    lucky_numbers = [13, 7, 4, 53 + 35, 27 - 8, 21, 392 + 274]

    # Slicing
    print(strings)
    print(lucky_numbers)
    print('Second index (1) of strings array is: \'' + strings[1] + '\'')
    # Negative slices are from-the-end.
    print('The sliced second half of the strings array is: ' +
          str(strings[-2:]))

    # Deletion
    print('The strings array contains ' + str(len(strings)) + ' items.')
    print(strings)
    print('...but not once I nuke strings[3]! Hahahaha.')
    del strings[3]
    print('The strings array contains ' + str(len(strings)) + ' items.')
    print(strings)

    # Iteration
    print('Hm, how do indices work again?')
    for i in range(len(strings)):
        print('Indice ' + str(i) + ' in strings contains: ' + strings[i])

    # The in/ not in operators.
    for thing in ['revolver', 'lipstick', 'knife']:
        print('Is there a ' + thing + ' in the list? => ' + str(thing in strings))

    for thing in ['revolver', 'lipstick', 'knife']:
        print('Is there a ' +
              thing +
              ' *not* in the list? => ' +
              str(thing not in strings))

    # Multiple Assignment (Didn't know this.)
    properties = ['red', 'loud', 'shiny']
    paint, engine, hubcaps = properties
    print(
        'The car has ' +
        paint +
        ' paint, a ' +
        engine +
        ' engine, and ' +
        hubcaps +
        ' hubcaps.')

    # List Methods
    for thing in ['lead pipe', 'chair', 'candlestick']:
        try:
            print('Murder weapon ' + thing +
                  ' is at index ' + str(strings.index(thing)))
        except ValueError:
            print('No ' + thing + ' in strings list!')

    # ...add to the end of the list:
    strings.append('rope')
    strings.append('knife')

    # ...insert at a given index:
    strings.insert(1, 'rubber chicken')

    # Use DEL for an index and REMOVE for a value.
    strings.remove('revolver')

    # Sort using ASCIIbetical order (you can use reverse=True inside, and
    # stuff.)
    strings.sort()

    print('After some modifications, the string array looks like this:')
    print(strings)

    # Tuples are ...immutable lists. That's all. Tuple with single value, add
    # comma.
    tiny_tuple = ('me',)
    regu_tuple = ('me me', 3, 'foo')
    print(tiny_tuple)
    print(regu_tuple)

    # Variables only store references to lists:
    wines = ['cab sav', 'merlot']
    cheese = wines
    cheese.append('bergamot')
    print('Wines:')
    print(wines)

    # To copy a list, take a copy or deepcopy (for inner lists)
    bread = copy.copy(cheese)
    bread.append('rye')
    print('Bread:')
    print(bread)
    print('Wines:')
    print(wines)


# pythonsFamousLists()


def pythonsFamousDictionaries():
    '''Tinker with dictionaries. Like a list, but it's a hash with keys and values.'''

    knight = {'name': 'Lancelot', 'armor': 'Shiny', 'sword': 'Sharp'}
    print('SIR KNIGHT!: '+str(knight))

    # Methods: keys, values, items
    print('Keys:\t'+str(knight.keys()))
    print('Values:\t'+str(knight.values()))
    print('Items:\t'+str(knight.items()))

    # Does SIR KNIGHT have a sword?
    print('Got Sword? => '+str( 'sword' in knight.keys()))
    print('Got Shield? => '+str( 'shield' in knight.keys()))


pythonsFamousDictionaries()
