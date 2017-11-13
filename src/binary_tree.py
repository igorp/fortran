# Binary Tree Implementation by Igor Podsechin
# based on the material in the book "Data Structures 
# & Algorithms in Java, 2nd edition" by Robert Lafore

class Node:
    def __init__(self, data):
        self.data = data
        self.leftChild = None
        self.rightChild = None

    def displayNode(self):
        print(self.data)

class Tree:
    def __init__(self):
        self.root = None

    def find(self, key):
        current = self.root

        while(current.data != key):
            print(current.data)
            if(key < current.data):
                current = current.leftChild
            else:
                current = current.rightChild
            if(current == None):
                return None
        return current

    def insert(self, d):
        newNode = Node(d)
        if(self.root == None):
            self.root = newNode
        else:
            current = self.root
            while(True):
                parent = current
                # go down the left node
                if(d < current.data):              
                    current = current.leftChild
                    if(current == None):
                        parent.leftChild = newNode
                        return
                # go down the right node
                else:
                    current = current.rightChild
                    if(current == None):
                        parent.rightChild = newNode
                        return


    # Returns the node with next-highest value after delNode
    def getSuccessor(self, delNode):
        successorParent = delNode
        successor = delNode
        current = delNode.rightChild

        while(current != None):
            successorParent = successor
            successor = current
            current = current.leftChild

        if(successor != delNode.rightChild):
            successorParent.leftChild = successor.rightChild
            successor.rightChild = delNode.rightChild
        return successor

    def delete(self, key):
        current = self.root
        parent = self.root
        isLeftChild = True

        while(current.data != key):
            parent = current
            # go left
            if(key < current.data):
                isLeftChild = True
                current = current.leftChild
            # go right
            else:
                isLeftChild = False
                current = current.rightChild
            if(current == None):
                return False
        # if no children, then just delete it
        if(current.leftChild == None and current.rightChild == None):
            if(current == self.root):
                self.root = None
            elif(isLeftChild):
                parent.leftChild = None
            else:
                parent.rightChild = None
        # if no right child, replace with left subtree
        elif(current.rightChild == None):
            if(current == self.root):
                self.root = current.leftChild
            elif(isLeftChild):
                parent.leftChild = current.leftChild
            else:
                parent.rightChild = current.leftChild
        # if no left child, replace with right subtree
        elif(current.leftChild == None):
            if(current == self.root):
                self.root = current.rightChild
            elif(isLeftChild):
                parent.leftChild = current.rightChild
            else:
                parent.rightChild = current.rightChild
        # two children, so replace with in-order successor
        else:
            # get successor of node to delete (current)
            successor = self.getSuccessor(current)

            # connect parent of current to successor instead
            if(current == self.root):
                self.root = successor
            elif(isLeftChild):
                parent.leftChild = successor
            else:
                parent.rightChild = successor
            # connect successor to current's left child
            successor.leftChild = current.leftChild
        return True

    # Traverses tree printing each out each node
    def traverse(self):
        def inOrder(localRoot):
            if(localRoot != None):
                inOrder(localRoot.leftChild)
                localRoot.displayNode()
                inOrder(localRoot.rightChild)

        inOrder(self.root)

def main():    
    
    tree = Tree()

    tree.insert(50)
    tree.insert(25)
    tree.insert(75)
    tree.insert(12)
    tree.insert(37)

    tree.traverse()

    tree.delete(12)
    tree.traverse()    

main()
