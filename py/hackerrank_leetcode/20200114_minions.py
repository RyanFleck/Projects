# https://www.hackerrank.com/challenges/the-minion-game/problem

def minion_game(string):
    string_len = len(string)
    stuart = 0
    kevin = 0

    for iletter in range(string_len):
        score = (string_len - iletter)
        if string[iletter] in ['A','E','I','O','U']:
            kevin = kevin + score
        else:
            stuart = stuart + score

    if stuart > kevin:
        print("Stuart " + str(stuart))
    elif kevin > stuart:
        print("Kevin " + str(kevin))
    else:
        print("Draw")
