import java.util.LinkedList;
import java.util.Queue;

class Node{
	Node left,right;
	int key;
	Node(int item){
		key=item;
		left=right=null;
	}
}
class Height{
	int h;
}
public class BinaryTree {
	Node root;
	BinaryTree(int key){
		root=new Node(key);
	}
	BinaryTree(){
		root=null;
	}
	
	void postOrderTraversal(Node node){
		if(node==null)
			return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.key);
		
	}
	void preOrderTraversal(Node node){
		if(node==null)
			return;
		System.out.print(node.key);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
		
	}
	void inOrderTraversal(Node node){
		if(node==null)
			return;
		inOrderTraversal(node.left);
		System.out.print(node.key);
		inOrderTraversal(node.right);
	}
	
	//level order tree traversal
	void levelOrder(Node node){
		int height=height(node);
		for(int i=1;i<=height;i++){
			givenLevel(node,i);
		}
		
	}
	void givenLevel(Node node, int level){
		if(node==null){
			return;
		}
		if(level==1)
			System.out.print(node.key);
		else if(level>1){
			givenLevel(node.left, level-1);
			givenLevel(node.right, level-1);
			}
			
	}
	// level order using queue optimized tree traversal
	void levelOrderUsingQueue(Node node){
		
	
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(node);
			while(!queue.isEmpty()){
				Node tempNode=queue.poll();
				System.out.print(tempNode.key);
				if(tempNode.left!=null)
					queue.add(tempNode.left);
				if(tempNode.right!=null)
					queue.add(tempNode.right);
			}
			
		}
		int height(Node node){
		if(node==null)
			return 0;
		else{
			int lheight=height(node.left);
			int rheight=height(node.right);
			if(lheight>rheight)
				return lheight+1;
			else
				return rheight+1;
		}
	}
		//diameter of binary tree
		int getDiameterOfBinaryTree(Node node){
			
			if(node==null) 
				return 0;
			else {
				int lheight = height(node.left);
				int rheight = height(node.right);
				int ldiameter = getDiameterOfBinaryTree(node.left);
				int rdiameter = getDiameterOfBinaryTree(node.right);
				return Math.max(lheight+rheight+1, Math.max(ldiameter, rdiameter));
			}
			
			
		}
		//optimized diameter of binary tree
		int getOptimizedDiameter(Node node, Height height){
			if(node==null){
				height.h=0;
				return 0;
			}
				Height lheight = new Height();
				Height rheight = new Height();
				lheight.h++;
				rheight.h++;
				int ldiameter = getOptimizedDiameter(node.left, lheight);
				int rdiameter = getOptimizedDiameter(node.right, rheight);
				height.h=Math.max(lheight.h, rheight.h)+1;
				
			return Math.max((lheight.h+rheight.h)+1, Math.max(ldiameter, ldiameter));
		}
		
		int getWidthOfBinaryTree(Node node){
			int h = height(node);
			int width=0;
			int maxWidth=0;
			for(int i=1;i<=h;i++){
				width=getWidthOfLevel(node, i);
				if(width>maxWidth)
					maxWidth=width;
				}
			return maxWidth;
		}
		int getWidthOfLevel(Node node, int level){
			 if(node==null)
				 return 0;
		 if(level==1)
				 return 1;
			 else if(level>1)
				return getWidthOfLevel(node.left, level-1) + 
						getWidthOfLevel(node.right, level-1);
			 
			 return 0;
		}
		int getOptimizedWidth(Node node){
			if(node==null)
				return 0;
			int width=0,maxWidth=0;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(node);
			while(!queue.isEmpty()){
				
				int count = queue.size();
				width = count;
				if(width>maxWidth)
					maxWidth = width;
				while(count--!=0){
					Node temp = queue.poll();
					if(temp.left!=null)
						queue.add(temp.left);
					if(temp.right!=null)
					    queue.add(temp.right);	
				}
				
			}
			return maxWidth;
			
		}
		void printNodeKdistance(Node node, int k){
			if(node == null)
				return ;
			if(k==0){
				System.out.println(node.key);
				return;
			}
				
			else{
				printNodeKdistance(node.left, k-1);
				printNodeKdistance(node.right, k-1);
			}
		}
		

		boolean printAncestorOfGivenNode(Node node, int data){
			if(node==null)
				return false;
			if(node.key==data)
				return true;
			if(printAncestorOfGivenNode(node.left, data)||printAncestorOfGivenNode(node.right, data)) {
				System.out.println(node.key);
		        return true;
			}
			return false;
		}
	public static void main(String[]args){
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        
 
        System.out.println("Preorder traversal of binary tree is ");
        tree.preOrderTraversal(tree.root);
 
        System.out.println("\nInorder traversal of binary tree is ");
        tree.inOrderTraversal(tree.root);
        
 
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.postOrderTraversal(tree.root);
        
        System.out.println("\nlevel order traversal of binary tree is ");
        tree.levelOrder(tree.root);
        tree.levelOrderUsingQueue(tree.root);
        System.out.println("\n"+tree.getDiameterOfBinaryTree(tree.root));
        System.out.println("\n"+tree.getOptimizedDiameter(tree.root, new Height()));
        System.out.println("\n"+tree.getWidthOfBinaryTree(tree.root));
        System.out.println("\n"+tree.getOptimizedWidth(tree.root));
        tree.printNodeKdistance(tree.root, 2);
        tree.printAncestorOfGivenNode(tree.root, 6);
        
		
	}

}