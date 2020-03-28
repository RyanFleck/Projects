def firstDuplicate(a):
    dups = [False] * (len(a) + 1)
    for elem in a:
        exists = dups[elem]
        if(exists):
            return elem
        else:
            dups[elem] = True

    return -1
