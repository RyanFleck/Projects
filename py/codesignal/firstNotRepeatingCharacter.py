def firstNotRepeatingCharacter(s):
    repeating = {}
    for char in s:
        if char in repeating.keys():
            repeating[char] = True
        else:
            repeating[char] = False

    for char in repeating.keys():
        if not repeating[char]:
            return char

    return '_'
