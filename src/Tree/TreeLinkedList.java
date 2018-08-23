package Tree;

public class TreeLinkedList implements Tree {
    //树根节点
    private Object element;
    private TreeLinkedList parent,firstChild,nextSibling;
    public TreeLinkedList(){
        this(null,null,null,null);
    }
    public TreeLinkedList(Object e,TreeLinkedList p,TreeLinkedList c,TreeLinkedList s){
        element = e;
        parent = p;
        firstChild = c;
        nextSibling = s;
    }
    @Override
    public Object getElem() {
        return element;
    }
    //将对象obj存入当前节点,并返回此前的内容
    @Override
    public Object setElem(Object obj) {
        Object bak = element;
        element = obj;
        return bak;
    }

    @Override
    public TreeLinkedList getParent() {
        return parent;
    }

    @Override
    public TreeLinkedList getFirstChild() {
        return firstChild;
    }

    @Override
    public TreeLinkedList getNextSibling() {
        return nextSibling;
    }

    //返回当前节点后代元素的数目,即以当前节点为根的子树的规模
    @Override
    public int getSize() {
        int size = 1;
        TreeLinkedList subtree = firstChild;
        while (subtree != null) {
            size += subtree.getSize();
            subtree = subtree.getNextSibling();
        }
        return size;
    }

    @Override
    public int getHeight() {
        int height = -1;
        TreeLinkedList subtree = firstChild;
        while (subtree != null){
            height = Math.max(height,subtree.getHeight());
            subtree = subtree.getNextSibling();

        }
        return height+1;
    }

    @Override
    public int getDepth() {
        int depth = 0;
        TreeLinkedList p = parent;
        while(p != null){
            depth++;
            p = p.getParent();
        }
        return depth;
    }
}
