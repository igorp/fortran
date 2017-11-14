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
        
    # A rather ugly function that draws a tree up to 4 levels
    def draw(self):
            treeFlattened = [-99] * 15
            a = self.root

            if(a != None):
                treeFlattened.pop(0)
                treeFlattened.insert(0, a.data)
                b = a.leftChild
                c = a.rightChild

                if(b != None):
                    treeFlattened.pop(1)
                    treeFlattened.insert(1, b.data)
                    d = b.leftChild
                    e = b.rightChild

                    if(d != None):
                        treeFlattened.pop(3)
                        treeFlattened.insert(3, d.data)
                        h = d.leftChild
                        i = d.rightChild

                        if(h != None):
                            treeFlattened.pop(7)
                            treeFlattened.insert(7, h.data)   

                        if(i != None):
                            treeFlattened.pop(8)
                            treeFlattened.insert(8, i.data)     

                    if(e != None):
                        treeFlattened.pop(4)
                        treeFlattened.insert(4, e.data)
                        j = e.leftChild
                        k = e.rightChild

                        if(j != None):
                            treeFlattened.pop(9)
                            treeFlattened.insert(9, j.data)   

                        if(k != None):
                            treeFlattened.pop(10)
                            treeFlattened.insert(10, k.data)     

                if(c != None):
                    treeFlattened.pop(2)
                    treeFlattened.insert(2, c.data)
                    f = c.leftChild
                    g = c.rightChild

                    if(f != None):
                        treeFlattened.pop(5)
                        treeFlattened.insert(5, f.data)
                        l = f.leftChild
                        m = f.rightChild

                        if(l != None):
                            treeFlattened.pop(11)
                            treeFlattened.insert(11, l.data)   

                        if(m != None):
                            treeFlattened.pop(12)
                            treeFlattened.insert(12, m.data)     

                    if(g != None):
                        treeFlattened.pop(6)
                        treeFlattened.insert(6, g.data)
                        n = g.leftChild
                        o = g.rightChild

                        if(n != None):
                            treeFlattened.pop(13)
                            treeFlattened.insert(13, n.data)   

                        if(o != None):
                            treeFlattened.pop(14)
                            treeFlattened.insert(14, o.data)     

            # draw function's inner helper function
            def formatNodeData(n):
                if(n == -99):
                    return "   "
                elif(n > 9):
                    return " " + str(n)
                else:
                    return " " + str(n) + " "

            print("        ______" 
                + formatNodeData(treeFlattened[0]) 
                + "______ ")
            print("       /               \\")
            print("    __" + formatNodeData(treeFlattened[1])
                + "__         __"
                + formatNodeData(treeFlattened[2]) + "__")
            print("   /       \       /       \\")
            print("  " 
                + formatNodeData(treeFlattened[3]) 
                + "     " 
                + formatNodeData(treeFlattened[4]) 
                + "     " 
                + formatNodeData(treeFlattened[5]) 
                + "     " 
                + formatNodeData(treeFlattened[6]))
            print(" /   \   /   \   /   \   /   \\")
            print("" 
                + formatNodeData(treeFlattened[7]) 
                + " " 
                + formatNodeData(treeFlattened[8]) 
                + " " 
                + formatNodeData(treeFlattened[9]) 
                + " " 
                + formatNodeData(treeFlattened[10]) 
                + " " 
                + formatNodeData(treeFlattened[11]) 
                + " " 
                + formatNodeData(treeFlattened[12]) 
                + " " 
                + formatNodeData(treeFlattened[13]) 
                + " " 
                + formatNodeData(treeFlattened[14]) 
                + "")

# test out a inserting, deleting and printing
def main():    
    
    tree = Tree()

    tree.insert(50)
    tree.insert(25)
    tree.insert(75)
    tree.insert(12)
    tree.insert(37)
    tree.insert(42)

    tree.draw()

    tree.delete(42)
    tree.traverse()    

main()
