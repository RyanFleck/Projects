def rotateImage(a):
    b = [False] * len(a)
    for x in range(len(a)):
        b[x] = [0] * len(a)

    max = len(a) - 1

    for outerIndice in range(len(a)):
        for innerIndice in range(len(a)):
            b[innerIndice][max - outerIndice] = a[outerIndice][innerIndice]

    return b
