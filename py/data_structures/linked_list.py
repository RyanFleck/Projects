#! /usr/bin/env python3

'''
Linked List Experiment
Ryan Fleck - Ryan.Fleck@protonmail.com

This program implements a linked list class with methods for ... (finish me)
'''

print("Linked List Experiment")
test_case_error = "A test case failed. Please check this line."


class LinkedListNode:
    '''Node for singly linked list.'''

    def __init__(self, data=None, next_node=None):
        self.data = data
        self.next_node = next_node

    def __repr__(self):
        return repr(self.data)


class LinkedList:
    '''Singly linked list'''

    def __init__(self):
        self.head = None

    def append(self, data):
        '''Searches for end of linked_list and appends new node. O(N)'''

        # Add new head if none exists.
        if self.head is None:
            self.head = LinkedListNode(data=data)
            return

        # Else, find last node.
        last_node = self.head
        while last_node.next_node:
            last_node = last_node.next_node

        last_node.next_node = LinkedListNode(data=data)

    def prepend(self, data):
        '''Replaces head with new node. O(1)'''
        self.head = LinkedListNode(data=data, next_node=self.head)

    def debug_to_list(self):
        '''Collects data from linked list into a Python array. O(N)'''
        check_node = self.head
        debug_list = []
        while check_node:
            debug_list.append(check_node.data)
            check_node = check_node.next_node

        return debug_list


x = LinkedList()
x.append("Hello")
x.append("World")
x.append("It's been")
x.append("real")

print(x.debug_to_list())

if x.debug_to_list() != ["Hello", "World", "It's been", "real"]:
    raise Exception(test_case_error)


class DoubleLinkedListNode:
    '''Node for doubly linked list.'''

    def __init__(self, data=None, previous_node=None, next_node=None):
        self.data = data
        self.next_node = next_node
        self.previous_node = previous_node

    def __repr__(self):
        return repr(self.data)
