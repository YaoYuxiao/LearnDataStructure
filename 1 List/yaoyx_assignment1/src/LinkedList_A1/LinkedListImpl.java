

/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node sentinel; //this will be the entry point to your linked list (the head)
  int numElts=0;
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }

@Override
public boolean insert(double elt, int index) {
	if (index<0||index>numElts) {
		return false;
	}else if(index==0&&numElts==0){
		Node firstNode= new Node(elt);
		sentinel.next=sentinel.prev=firstNode;
		firstNode.prev=firstNode.next=sentinel;
		numElts++;
		return true;
	}else{
		
		Node newNode= new Node(elt);
		Node temp=getNode(index);//Node temp is the node right behind the node being added
		newNode.prev=getNode(index).prev;
		
		newNode.next=getNode(index);
		
		newNode.prev.next=newNode;
		newNode.next.prev=newNode;
		
		
		
		numElts++;
		return true;
	}
	
	
}

@Override
public boolean remove(int index) {
	if (index==0||numElts==1) {
		sentinel.prev=sentinel.next=sentinel;
		 numElts--;
		 return true;
	}else if (index<0||index>=numElts) {
		System.out.println("index out of bounds");
		return false;
	}else {
		getNode(index).next.prev = getNode(index).prev; 
		 getNode(index).prev.next = getNode(index).next; 
		 numElts--;
		return true;
	}
	 
}

@Override
public double get(int index) {
	if (index<0||index>=numElts) {
		return Double.NaN;
	}else {
		return getNode(index).getData();
	}
	
}

@Override
public int size() {
	
	return numElts;
}

@Override
public boolean isEmpty() {
	
	return size()==0;
}

@Override
public void clear() {
	if(numElts!=0) {
		remove(0);
	}
	numElts=0;
	
}
private Node getNode(int index) {
	Node p=sentinel;
	if(numElts==0) {
		return sentinel;
	}else {
		for (int i=0;i<index+1;i++) {
			p=p.next;
		}
	return p;
	}
		
}
}