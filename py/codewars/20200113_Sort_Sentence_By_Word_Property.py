# My original Solution:

def order(sentence):
  sentence = sentence.split()
  sentence_rearranged = [None]*len(sentence)
  if len(sentence) == 0:
    return ""
  
  for word in sentence:
    for letter in word:
        if str.isdigit(letter):
            addr = int(letter) - 1
            sentence_rearranged.pop(addr)
            sentence_rearranged.insert(addr,word)
  
  return " ".join(sentence_rearranged)


# Solution that I liked:

def order(sentence):
    return " ".join(sorted(sentence.split(), key=lambda x: int(filter(str.isdigit, x))))
