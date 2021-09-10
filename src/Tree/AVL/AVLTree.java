package Tree.AVL;

public class AVLTree {
    private Node root;

    Node insert(Node node, int key) {
        if (node == null) return new Node(key);
        else if (node.key < key) node.left = insert(node, key);
        else if (node.key > key) node.right = insert(node, key);
        else throw new RuntimeException("duplicate key!");
        return rebalance(node);
    }

    Node delete(Node node, int key) {
        if (node == null) return node;
        //node is external
        if (node.key > key) node.left = delete(node.left, key);
        else if (node.key < key) node.right = delete(node.right, key);
        else {
            if (node.left == null || node.right == null) node = node.left == null ? node.right : node.left;
            else {
                Node leftMost = leftMost(node.right);
                node.key = leftMost.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) node = rebalance(node);
        return node;
    }

    Node leftMost(Node node) {
        if (node.left == null) return node;
        return leftMost(node.left);
    }

    Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) break;
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    //use this for all Nodes in the path from inserted/deleted node to the root
    Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.left) < height(z.right.right)) {
                z = rotateLeft(z);
            } else {
                z = rotateRightLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z = rotateLeftRight(z);
            }
        }
        return z;
    }

    void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    int height(Node n) {
        return n == null ? -1 : n.height;
    }

    int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    boolean isBalanceValid(Node n) {
        return getBalance(n) == -1 || getBalance(n) == 0 || getBalance(n) == 1;
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(x);
        updateHeight(y);
        return x;
    }

    Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(x);
        updateHeight(y);
        return x;
    }

    Node rotateRightLeft(Node y) {
        Node x = y.left;
        y.left = rotateRight(x);
        return rotateLeft(y);
    }

    Node rotateLeftRight(Node y) {
        Node x = y.right;
        y.right = rotateLeft(x);
        return rotateRight(y);
    }


}
