boolean hasCycle(Node head) {
    HashMap<Node,String> hs=new HashMap<Node,String>();
    Node node=new Node();
    node=head;
    while(node!=null){
        if(hs.containsKey(node))
            {
            return true;
        }else{
            hs.put(node,"Y");
        }
        node=node.next;
    }    
    return false;
}
