def in_array(array1, array2):
    answers = []
    
    for keyword in array1:
        for word in array2:
            if keyword in word and keyword not in answers:
                answers.append(keyword)

    return sorted(answers)
