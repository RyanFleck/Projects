# Currently test two is too compute-intensive to pass test 14.
# To fix this problem, I'd precompute all rotations of the reference and compare
#  those to the candidate string.

def similarDNA(reference, candidates):
    similarcount = 0
    refcount = countACTG(reference)

    for candidate in candidates:
        # First, check if identical.
        if reference == candidate:
            similarcount = similarcount + 1

        # Test one filters candidates with more than 3 differences.
        elif similarACTGCount(refcount, candidate):

            # Test two makes more compute-intensive comparisons.
            if attemptSubstitutions(reference, candidate):
                similarcount = similarcount + 1
    
    return similarcount


def attemptSubstitutions(reference, candidate):
    # Second test, checks order of ATCGs.

    rotated = reference
    for x in range(len(reference)):
        rotated = rotated[-1] + rotated[:-1]
        similarities = stringSimilarities(rotated, candidate)
        if similarities + 3 >= len(reference):
            return True

    return False


def stringSimilarities(a, b):
    if len(a) != len(b):
        return 0

    if a == b:
        return len(a)

    similarities = 0
    for x in range(len(a)):
        if a[x] == b[x]:
            similarities = similarities + 1
    
    return similarities


def similarACTGCount(refcount, candidate):
    # First test, counts ATCG and ensures there are fewer than three deviations
    cancount = countACTG(candidate)
    totaldiff = 0
    for indice in range(4):
        diff = refcount[indice] - cancount[indice]
        totaldiff = totaldiff + abs(diff)

    # Totaldiff of 6 indicates 3 deviant characters.
    if totaldiff < 7:
        return True
    
    return False


def countACTG(seq):
    A = seq.count('A')
    C = seq.count('C')
    T = seq.count('T')
    G = seq.count('G')
    return [A, C, T, G]