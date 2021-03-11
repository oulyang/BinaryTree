package m3d11;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree binaryTree=new BinaryTree();
		
		HeroNode node1=new HeroNode(1,"宋江");
		HeroNode node2=new HeroNode(2,"吴用");
		HeroNode node3=new HeroNode(3,"卢俊义");
		HeroNode node4=new HeroNode(4,"林冲");
		
		node1.setLeft(node2);
		node1.setRight(node3);
		node3.setRight(node4);
		
		binaryTree.setRoot(node1);
		//前序
		//binaryTree.perOrder();
		//中序
		//binaryTree.infixOrder();
		//后序
		//binaryTree.postOrder();
		
		HeroNode ret1=binaryTree.perOrderSearch(2);
		System.out.println(ret1);
		HeroNode ret2=binaryTree.infixOrderSearch(3);
		System.out.println(ret2);
		HeroNode ret3=binaryTree.postOrderSearch(1);
		System.out.println(ret3);
	}

}

class BinaryTree{
	private HeroNode root;
	public void setRoot(HeroNode root) {
		this.root=root;
	}
	
	//前序遍历
	public void perOrder() {
		if(this.root!=null) {
			this.root.preOrder();
		}else {
			System.out.println("二叉树为空");
		}
		
	}
	//中序遍历
	public void infixOrder() {
		if(this.root!=null) {
			this.root.infixOrder();
		}else {
			System.out.println("二叉树为空");
		}
	}
	//后序遍历
	public void postOrder() {
		if(this.root!=null) {
			this.root.postOrder();
		}else {
			System.out.println("二叉树为空");
		}
	}
	
	//前序遍历查找
	public HeroNode perOrderSearch(int no) {
		if(root!=null) {
			return root.preOrderSearch(no);
		}else {
			return null;
		}
	}
	//中序遍历查找
	public HeroNode infixOrderSearch(int no) {
		if(root!=null) {
			return root.infixOrderSearch(no);
		}else {
			return null;
		}
	}
	//后序遍历查找
	public HeroNode postOrderSearch(int no) {
		if(root!=null) {
			return root.postOrderSearch(no);
		}else {
			return null;
		}
	}
}
class HeroNode{
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	public HeroNode() {
		
	}
	public HeroNode(int no,String name) {
		this.no=no;
		this.name=name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HeroNode getLeft() {
		return left;
	}
	public void setLeft(HeroNode left) {
		this.left = left;
	}
	public HeroNode getRight() {
		return right;
	}
	public void setRight(HeroNode right) {
		this.right = right;
	}
	
	public String toString() {
		return "HeroNode[ no:"+no+",name:"+name+"]";
	}
	
	//前序遍历
	public void preOrder() {
		System.out.println(this);//先输出父节点
		//递归向左子树前序遍历
		if(this.left!=null) {
			this.left.preOrder();
		}
		//递归向右子树前序遍历
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
	//中序遍历
	public void infixOrder() {
		//递归向左子树中序遍历
		if(this.left!=null) {
			this.left.infixOrder();
		}
		//输出父节点
		System.out.println(this);
		//递归向右子树中序遍历
		if(this.right!=null) {
			this.right.infixOrder();
		}
	}
	//后序遍历
	public void postOrder() {
		//递归向左子树后序遍历
		if(this.left!=null) {
			this.left.postOrder();
		}

		//递归向右子树后序遍历
		if(this.right!=null) {
			this.right.postOrder();
		}
		//输出父节点
		System.out.println(this);
	}
	
	//前序遍历查找
	public HeroNode preOrderSearch(int no) {
		//比较当前节点
		if(this.no==no) {
			return this;
		}
		//判断当前节点的左子节点是否空，若不为空则递归前序查找
		HeroNode ret=null;
		if(this.left!=null) {
			ret=this.left.preOrderSearch(no);
		}
		if(ret!=null) {//在左子树找到
			return ret;
		}
		//判断当前节点的左子节点是否空，若不为空则递归前序查找
		if(this.right!=null) {
			ret=this.right.preOrderSearch(no);
		}
		return ret;
	}
	
	//中序遍历查找
	public HeroNode infixOrderSearch(int no) {
		//判断当前节点的左子节点是否空，若不为空则递归中序查找
		HeroNode ret=null;
		if(this.left!=null) {
			ret=this.left.infixOrderSearch(no);
		}
		if(ret!=null) {//在左子树找到
			return ret;
		}
		
		//比较当前节点
		if(this.no==no) {
			return this;
		}
		
		if(this.right!=null) {
			ret=this.right.infixOrderSearch(no);
		}
		return ret;
	}
	
	//后序遍历查找
	public HeroNode postOrderSearch(int no) {
		//判断当前节点的左子节点是否空，若不为空则递归后序查找
		HeroNode ret=null;
		if(this.left!=null) {
			ret=this.left.postOrderSearch(no);
		}
		if(ret!=null) {//在左子树找到
			return ret;
		}
		//判断当前节点的左子节点是否空，若不为空则递归后序查找
		if(this.right!=null) {
			ret=this.right.postOrderSearch(no);
		}
		if(ret!=null) {//在左子树找到
			return ret;
		}
		//比较当前节点
		if(this.no==no) {
			return this;
		}
		return ret;
	}
}
