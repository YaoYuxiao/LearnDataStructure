package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  public boolean containsNode(String s){ 
	  if (data.equals(s)) {
		  return true;
	  }else {
		  if (data.compareTo(s)>0) {
			  if (left==null) {
				  return false;
			  }else {
				  return left.containsNode(s);
			  }
		  }else{
			  if (this.right==null) {
				  return false;
			  }else {
				  return right.containsNode(s);
			  }
		  }
	  }
	  }
  public boolean insertNode(String s){ 
  	if (this.data.equals(s)) {
  		return false;
  	}else if (this.data.compareTo(s)>0) {
  		if (this.left==null) {
  			this.left=new BST_Node(s);
  			return true;
  		}else {
  			return this.left.insertNode(s);
  		}
  	}else {
  		if (this.right==null) {
  			this.right=new BST_Node(s);
  			return true;
  		}else {
  			return this.right.insertNode(s);
  		}
  	}
  
  }
  public boolean removeNode(String s,BST_Node parent){ 
	 if(data.equals(s)) {
		 if(left==null&&right==null){//the node is a leaf
			 if (parent.left!=null&&parent.left.getData().equals(s)) {//if the node is the parent's left child
				 parent.left=null;
			 }else {//if the node is the parent's right child
				 parent.right=null;
			 }
		 }else if (left==null) {//the node has one child (no left node)
			 if (parent.left!=null&&parent.left.getData().equals(s)) {//if the node is the parent's left child
				 parent.left=this.right;
			 }else {//if the node is the parent's right child
				 parent.right=this.right;
			 }
		 }else if(right==null) {//the node has one child (no right node)
			 if (parent.left!=null&&parent.left.getData().equals(s)) {//if the node is the parent's left child
				 parent.left=this.left;
			 }else {//if the node is the parent's right child
				 parent.right=this.left;
			 }
		 }else {//the node has two children
			 this.data=right.findMin().getData();
			 right.removeNode(right.findMin().getData(), this);
		 }return true;
	 }else if (data.compareTo(s)>0) {//left
		 if(left==null) {
			 return false;
		 }else {
			 return left.removeNode(s, this);
		 }
	 }else {//right
		 if(right==null) {
			 return false;
		 }else {
			 return right.removeNode(s, this);
		 }
	 }
	  
	 
  
/*	  if (s.compareTo(data)<0) { 
          if (left != null) {
        	  return left.removeNode(s, this); 
          }
                
          else {
        	  return false; 
          }
                
    } else if (s.compareTo(data)>0) { 
          if (right != null) {
        	  return right.removeNode(s, this); 
          }
                
          else {
        	  return false;
          }
                 
    } else { 
          if (left != null && right != null) { 
                this.data = right.findMin().getData(); 
                right.removeNode(this.data, this); 
          } else if (parent.left == this) { 
                parent.left = (left != null) ? left : right; 
          } else if (parent.right == this) { 
                parent.right = (left != null) ? left : right; 
          } 
          return true; 
    } */
  }
  public BST_Node findMin(){ 
  	if (this.left==null) {
  		return this;
  	}else {
  		return this.left.findMin();
  	}
  }
  public BST_Node findMax(){ 
	  if (this.right==null) {
		return this;
	}else {
		return this.right.findMax();
	} }
  public int getHeight(){ 
	 if(left==null&&right==null) {
		  return 1; //the node is a leaf
	  }else {
			  int left_height=0;
			  int right_height=0;
			  if(left!=null&&right!=null) {
				  left_height=left.getHeight();
				  right_height=right.getHeight();
			  }
		  if (left_height>right_height) {
			  return left_height+1;
		  }else {
			  return right_height+1;
		  }
	  }
  }
  

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}
