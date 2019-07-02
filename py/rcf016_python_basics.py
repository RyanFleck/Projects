#!/usr/bin/python3

# Refreshing my memory, had a sea change in thinking after spending
# two days diving into Ruby to see what all the fuss was about;
# developer productivity can come before machine efficiency.
# Python has a greater set of use cases than Ruby.

import sys
import random
import copy
import pprint
import re
import os


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

    knight = {'name': 'Lancelot', 'armor': 'shiny', 'sword': 'sharp'}
    print('SIR KNIGHT!: ' + str(knight))

    # Methods: keys, values, items
    print('Keys:\t' + str(knight.keys()))
    print('Values:\t' + str(knight.values()))
    print('Items:\t' + str(knight.items()))

    # Does SIR KNIGHT have a sword?
    print('Got Sword? => ' + str('sword' in knight.keys()))
    print('Got Shield? => ' + str('shield' in knight.keys()))

    # Method get(thing to look for, fallback value)
    print('Sword property: ' + str(knight.get('sword', 'nope')))
    print('Shield property: ' + str(knight.get('shield', 'nope')))

    # SetDefault sets a value if it doesn't already exist.
    knight.setdefault('sword', 'bloody')
    knight.setdefault('shield', 'rugged')
    knight.setdefault('face', 'clean shaven')
    knight.setdefault('intents', 'noble')
    knight.setdefault('aim', 'true')
    print(knight)

    # Give the knight some stuff
    knight.setdefault(
        'inventory', {
            'arrows': 12, 'gold coins': 2, 'copper coins': 38})

    # PPRINT -> Pretty print
    # Pretty print dictionaries and stuff.
    pprint.pprint(knight)


# pythonsFamousDictionaries()

def stringManipulation():
    '''Mess around with strings, slicing, wheat kings, etc.'''

    lyric = "In the zippo lighter, he sees the killer's face."
    lyric_two = "Maybe it's someone standing in the killer's place."
    print(lyric + '\n' + lyric_two)

    # Ramsey's F*CKING RAW (raw) strings ignore all specials and escape chars:
    raw_string = r'Any\thing can\t go in here and it\'ll still be processed'
    print(raw_string)

    # Multiline strings got three ticks:
    wanderer = '''
    I went out walking
    under an atomic sky
    where the pain it churned
    and the rain, it burned
    my own ghost walking by my side
    '''
    print(wanderer)

    # Strings can be SLICED, diced and indexed.
    # Empty entry just defaults to that end of the list.
    print(lyric[:13])
    print(lyric[13:])

    # We can do things like remove the last letter, and add EMPHASIS!!!
    print(lyric.upper()[:-1] + '!!!')
    print('Is it normally all uppercase? => ' + str(lyric.isupper()))

    # Also see isalpha() isalnum() isdecimal() isspace() istitle()

    # Split and join
    print('! '.join(['three', 'minutes', 'to', 'midnight']) + '!')
    print('I like apples, bananas, and frunklefruit.'.split(','))

    # Dumb formatting
    print('Left '.ljust(80, '='))
    print(' Right'.rjust(80, '='))
    print(' Central, Baybee '.center(80, '='))

    # Remove whitespace with strip() (heh), rstrip(), lstrip().


# stringManipulation()

def pythonRegex():
    '''Regular expressions and stuff.'''
    print('Python is pretty good with regular expressions')

    foo = "Hey, don't let it go to waste; I love it for the aftertaste."
    message_to_dev = '''
    =========================
    from: agent@talent.com
    to: super-awesome.programm_er.lol@ryanfleck.ca
    subject: Django Foos Site
    =========================

    Uh, hey, this is Dave.

    You came up to me at my concert and said you could build me a site?

    Anyways, it'd be great if you could do that. I've heard of this thing
    called Django that sounds cool; I like the Tarantino movie, and I'm sure
    a website thing named after an awesome movie has to be good.

    Oh, and you need to be able to log people in and buy merch! and stuff!

    I'm sending this from my agent's email, you can get back to me directly
    by calling (613) 501-6192 or, alternatively, 789-293-3942, my wife's phone.

    Or +3 412 492 3912, my dog's phone. or is it +2(413) 492-3912? Hm... Well,
    in any case, his email is dog@foos.co.uk.

    OR you can email me or my agent back, but he usually takes a while to get
    back so right to me is better: dave@foofighters.com, agent.j@talent.com !

    Thanks man!

    - Dave

    '''

    print('Awesome, Dave Grohl sent me an email:\n' + message_to_dev)
    print('Let\'s get all the useful phone numbers and emails outta this.')

    # Compile the regex pattern for phone numbers.
    re_phonenumber_1 = re.compile(
        r'((\+\d)?(\(| )*\d\d\d(\)|-| )*\d\d\d(-| )*\d\d\d\d)')

    # Get the first match.
    matches = re_phonenumber_1.search(message_to_dev)

    # Get ALL the matches!
    all_matches = re_phonenumber_1.findall(message_to_dev)
    print('\nWe successfully extracted ' +
          str(len(all_matches)) + ' phone numbers:')
    for match in range(len(all_matches)):
        # Match is stored in a tuple with all the groups from the regex.
        print(str(match + 1) + ': ' + all_matches[match][0].strip())

    # Compile the regex pattern for email addresses.
    # This only accounts for non-disassembled addresses with (at) (dot)
    re_emailaddr = re.compile(r'((\w|\.|-)+@(\w|\.|-)+)')
    email_matches = re_emailaddr.findall(message_to_dev)

    print('\nEmail addresses:')
    for match in range(len(email_matches)):
        # Match is stored in a tuple with all the groups from the regex.
        print(str(match + 1) + ': ' + email_matches[match][0].strip())

    # GREED

    gstring = '<this is a test> for greediness> you wall street banker, you>'

    greedy = re.compile(r'<.*>')
    timid = re.compile(r'<.*?>')

    print('\nA note on GREED. For the string:\n\t' + gstring + '\n')
    print('Greedy algo:\t' + greedy.search(gstring).group())
    print('Timid algo:\t' + timid.search(gstring).group())

    # CENSORSHIP
    # Let's re-use the compiled email and phone number regexes from earlier...
    cnsr = '[CENSORED]'
    message_censored = re_phonenumber_1.sub(cnsr, message_to_dev)
    message_censored = re_emailaddr.sub(cnsr, message_censored)
    print(message_censored)

    # COMPLEXITY
    # Regex can be spread over multiple lines to simplify and annotate.
    re_phonenumber_2 = re.compile(r'''(
    (\+\d)?     # Country code.
    (\(| )*     # First gap.
    \d\d\d      # First three digits, area code.
    (\)|-| )*   # Dash between area code and unique 1-3/7 digits
    \d\d\d      # 1-3/7 digits.
    (-| )*      # Second dash.
    \d\d\d\d    # Last 4-7/7 digits.
    )''', re.VERBOSE)

    # Get ALL the matches!
    all_matches_complex = re_phonenumber_1.findall(message_to_dev)
    print('\nWe successfully extracted ' +
          str(len(all_matches_complex)) +
          ' phone numbers with a complex algo:')
    for match in range(len(all_matches_complex)):
        # Match is stored in a tuple with all the groups from the regex.
        print(str(match + 1) + ': ' + all_matches_complex[match][0].strip())

    # re.I or re.IGNORECASE, re.D or re.DOTALL, re.V or re.VERBOSE can all be
    # passed to modify the results of a regex compilation.
    # example = re.compile(r'theregex', re.IGNORECASE | re.DOTALL | re.VERBOSE)
    # re.VERBOSE - Ignore whitespace and comments.
    # re.IGNORECASE - Obvs.
    # re.DOTALL - Dot character matches specials like newline and tab.


# pythonRegex()

def pythonFileIO():
    '''In which the user learns about reading and writing files to disk.'''
    print('Running IO tests.')
    print('Path to python gold mine: ' +
          os.path.join('/', 'home', 'rflec028', 'Repos', 'Projects', 'py'))
    print('Working directory: ' + os.getcwd())

    # NEW DIRECTORIES: os.makedirs()
    # Ex. os.makedirs(os.path.join(os.getcwd(), 'testdir'))

    # Absolute and relative paths.
    # Check with os.path.isabs(path)
    # Return with os.path.relpath(path, start) (failing to priovide start uses
    # cwd.)
    print("\nPython rcf* files in the current directory:")
    pyfiles = []
    for f in os.listdir(os.getcwd()):
        if(f.endswith('.py') and f.startswith('rcf')):
            pyfiles.append(f)

    pprint.pprint(pyfiles)

    # DOUBLE CHECKING
    # os.path.exists() -> obvs.
    # os.path.is dir|file () -> check if dir or file. Ex:
    print('\nDirectories:')
    dirs = []
    for f in os.listdir(os.getcwd()):
        if(os.path.isdir(f)):
            dirs.append(f)

    pprint.pprint(dirs)


pythonFileIO()

