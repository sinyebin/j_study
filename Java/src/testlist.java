import java.util.*;
public class testlist {
    static ListStack list = new ListStack();
    static ListStack.Node root;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        root=list.new Node(10);
        while(true){
            System.out.println("1: insert 2: delete 3: output 4:invert 5: exit");
            int num=scanner.nextInt();
            switch(num){
                case 1:
                    int item=scanner.nextInt();
                    root=list.add(root,item);
                    break;
                case 2:
                    root=list.delete(root);
                    break;
                case 3:
                    list.print(root);
                    break;
                case 4:
                    root=list.invert(root);   
                    break;
                case 5:
                    System.out.println(5);
                    System.exit(0);
                    break;
            }
        }
    }
}
class ListStack {
    class Node{
        int node;
        Node link;
        public Node(int node){
            this.node=node;
        }
        public Node(int node, Node link){
            this.node=node;
            this.link=link;
        }
    }
    Node add(Node root,int item){
        ListStack.Node nroot=new ListStack.Node(item, root);
        return nroot;
    }
    Node delete(Node root){
        if(root==null){
            System.out.println("EMPTY");
            return root;
        }
        System.out.println(root.node+" "+"삭제");
        root=root.link;
        return root;
    }
    void print(Node root){
        while(root!=null){
            System.out.println(root.node);
            root=root.link;
        }
    }
    Node invert(Node root){
        ListStack.Node a=root.link;
        ListStack.Node temp=null;
        while(root!=null){
            a=root.link;
            root.link=temp;
            temp=root;
            root=a;    
        }
        return temp;
    }
}