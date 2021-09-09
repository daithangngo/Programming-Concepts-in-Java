package List.Tree;

class TreeElement {
    private long info;
    private TreeElement left;
    private TreeElement right;

    public TreeElement(long info) {
        this.info = info;
    }

    public void insert(long value) {
        if (value < info)
            if (left != null)
                left.insert(value);
            else
                left = new TreeElement(value);
        else if (right != null)
            right.insert(value);
        else
            right = new TreeElement(value);
    }

    public void toString(StringBuilder sb) {
        if (left != null)
            left.toString(sb);
        if (sb.length() != 0)
            sb.append(",");
        sb.append(info);
        if (right != null)
            right.toString(sb);
    }

    public TreeElement remove(long value) {
        if (value < info && left != null)
            left = left.remove(value);
        else if (value > info && right != null)
            right = right.remove(value);
        else if (value == info) {
            if (right == null)
                return left;
            if (left == null)
                return right;
            info = right.getMin();
            right = right.remove(info);
        }
        return this;
    }

    private long getMin() {
        return left == null ? info : left.getMin();
    }

    public int size() {
        return 1 + (left != null ? left.size() : 0)
                + (right != null ? right.size() : 0);
    }

    public boolean contains(long value) {
        if (info < value)
            return right != null && right.contains(value);
        if (info > value)
            return left != null && left.contains(value);
        return true;
    }
}
