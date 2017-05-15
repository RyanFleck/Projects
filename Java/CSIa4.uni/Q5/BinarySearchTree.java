public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<T> {

        private final T value;
        private Node<T> left;
        private Node<T> right;

        private Node(T value) {
            this.value = value;
        }

    }

    private Node<E> root;

    /**
     * Inserts an object into this BinarySearchTree.
     *
     * @param obj item to be added
     * @return true if the object has been added and false otherwise
     */

    public boolean add(E obj) {

        // pre-condtion:
        if (obj == null) {
            throw new NullPointerException("Illegal Argument");
        }

        // special case:
        if (root == null) {
            root = new Node<E>(obj);
            return true;
        }

        // general case:
        return add(obj, root);
    }

    private boolean add(E obj, Node<E> current) {

        boolean result;
        int test = obj.compareTo(current.value);

        if (test == 0) {
            result = false; // already exists, not added
        } else if (test < 0) {
            if (current.left == null) {
                current.left = new Node<E>(obj);
                result = true;
            } else {
                result = add(obj, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = new Node<E>(obj);
                result = true;
            } else {
                result = add(obj, current.right);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node<E> p) {
        if (p == null) {
            return "null";
        } else {
            return "(" + toString(p.left) + "," + p.value + "," + toString(p.right) + ")";
        }
    }

    public int count(E low, E high) {
        
         if (root == null) {return 0;} //throw EmptyTreeException
        return count(low,high,root);
    }
    
    private int count(E low, E high, Node<E> current) {
        
        if (current.value == null){return 0;} 
        int token=0;
        boolean addToken=false;
        
        if((current.left!=null)&&(low.compareTo(current.value)<=0)){token+=count(low,high,current.left);}
        if((current.right!=null)&&(high.compareTo(current.value)>=0)){token+=count(low,high,current.right);}
        if((low.compareTo(current.value)<=0)&&(high.compareTo(current.value)>=0)){addToken=true;}
        if(addToken){token++;}
        
         return token;
    }
}
