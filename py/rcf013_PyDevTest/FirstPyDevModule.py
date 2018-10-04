'''
@author: Ryan Fleck
@contact: ryan.fleck@protonmail.com
@copyright: GNU GPL v3

Created on Oct. 4, 2018

'''

class FirstClass:
    
    def __init__(self, message):
        self.message = message
        self.hello(self.message)
    
    def hello(self, arg="Hello, World!"):
        print(arg)





if __name__ == '__main__':
    print("Run unit tests...")
    
    inst = FirstClass("It's a gas!")
    inst.hello()