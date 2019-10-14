package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

@Override
public boolean insert(String s) {
	if (this.contains(s)) {
		return false;
	}else {
		if(root==null) {
			root=new BST_Node(s);
			size++;
			return true;
		}else {
			size++;
			return root.insertNode(s);
		}
		
	}
	
}

@Override
public boolean remove(String s) {
	if (size==0) {//if the tree is empty, return 0
		return false;
	}else if(this.contains(s)==false){//if the tree does not contain node with data s
		return false;
	}else {if (root.getData().equals(s)) { //remove the root
		if (root.getLeft()==null&&root.getRight()==null) {//no child
			root=null;
			size=0;
		}else if(root.getLeft()==null) {//one child
			root=root.getRight();
		}else if(root.getRight()==null) {
			root=root.getLeft();
		}else {//two children
			root.data=root.right.findMin().getData();
			 root.right.removeNode(s, root);
		}
		size--;
		return true;
	}else {
		size--;
		return root.removeNode(s,null);
	}
	  
			
	}

}

@Override
public String findMin() {
	if (size==0) {
		return null;
	}else {
		return root.findMin().getData();
	}
	
}

@Override
public String findMax() {
	if (size==0) {
		return null;
	}else {
		return root.findMax().getData();
	}
	
}

@Override
public boolean empty() {
	if (size==0) {
		return true;
	}else {
		return false;
	}
}

@Override
public boolean contains(String s) {
	if (size==0||root==null) {
		return false;
	}else {
		return root.containsNode(s);
	}
	
}

@Override
public int size() {
	
	return size;
}

@Override
public int height() {
	if (size==0) {
	return 0;
	}else{
	return root.getHeight();
	}
	
}

}
