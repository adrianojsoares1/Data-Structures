'''
Created by Adriano on 4/22/17
Prof. Malenkov
Node for Binary Search Tree
'''

class Node(object):

    def __init__(self, value=None, left=None, right=None, parent=None):
        self.left = left
        self.right = right
        self.parent = parent
        self.value = value

    def get_parent(self):
        return self.parent

    def set_parent(self, new):
        if type(new) is Node or new is None:
            self.parent = new
        else:
            print("Not of valid type!")

    def get_right(self):
        return self.right

    def set_right(self, new):
        if type(new) is Node or new is None:
            self.right = new
        else:
            print("Not of valid type!")

    def get_left(self):
        return self.left

    def set_left(self, new):
        if type(new) is Node or new is None:
            self.left = new
        else:
            print("Not a valid type")

    def get_value(self):
        return self.value

    def set_value(self, val):
        self.value = val