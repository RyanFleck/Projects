def uniqueDNASequences(sequences):
    # Store sequences in dict:
    #  key: hash:int -> val: [unique-hashes:strings]
    seqvals = {}

    for seq in sequences:
        hash = seqHash(seq)
        if hash in seqvals.keys():
            rotatedHash = False
            for hashseq in seqvals[hash]:
                if rotated(seq, hashseq):
                    rotatedHash = True
                    break
            if not rotatedHash:
                seqvals[hash].append(seq)

        else:
            seqvals[hash] = [seq]

    total = 0
    for seqs in seqvals.keys():
        total = total + len(seqvals[seqs])

    return total


def seqHash(seq):
    # Returns int with decimal places representing ACTG
    A = seq.count('A') * 1000
    C = seq.count('C') * 100
    T = seq.count('T') * 10
    G = seq.count('G')
    return A + C + T + G


def rotated(seqA, seqB):

    # Base case.
    if seqA == seqB:
        return True

    # Otherwise, compare to all rotations:
    rotated = seqA
    for num in range(1, len(seqA), 1):
        rotated = rotated[-1] + rotated[:-1]
        if rotated == seqB:
            return True

    return False
