package m3d11;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree binaryTree=new BinaryTree();
		
		HeroNode node1=new HeroNode(1,"�ν�");
		HeroNode node2=new HeroNode(2,"����");
		HeroNode node3=new HeroNode(3,"¬����");
		HeroNode node4=new HeroNode(4,"�ֳ�");
		
		node1.setLeft(node2);
		node1.setRight(node3);
		node3.setRight(node4);
		
		binaryTree.setRoot(node1);
		//ǰ��
		//binaryTree.perOrder();
		//����
		//binaryTree.infixOrder();
		//����
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
	
	//ǰ�����
	public void perOrder() {
		if(this.root!=null) {
			this.root.preOrder();
		}else {
			System.out.println("������Ϊ��");
		}
		
	}
	//�������
	public void infixOrder() {
		if(this.root!=null) {
			this.root.infixOrder();
		}else {
			System.out.println("������Ϊ��");
		}
	}
	//�������
	public void postOrder() {
		if(this.root!=null) {
			this.root.postOrder();
		}else {
			System.out.println("������Ϊ��");
		}
	}
	
	//ǰ���������
	public HeroNode perOrderSearch(int no) {
		if(root!=null) {
			return root.preOrderSearch(no);
		}else {
			return null;
		}
	}
	//�����������
	public HeroNode infixOrderSearch(int no) {
		if(root!=null) {
			return root.infixOrderSearch(no);
		}else {
			return null;
		}
	}
	//�����������
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
	
	//ǰ�����
	public void preOrder() {
		System.out.println(this);//��������ڵ�
		//�ݹ���������ǰ�����
		if(this.left!=null) {
			this.left.preOrder();
		}
		//�ݹ���������ǰ�����
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
	//�������
	public void infixOrder() {
		//�ݹ����������������
		if(this.left!=null) {
			this.left.infixOrder();
		}
		//������ڵ�
		System.out.println(this);
		//�ݹ����������������
		if(this.right!=null) {
			this.right.infixOrder();
		}
	}
	//�������
	public void postOrder() {
		//�ݹ����������������
		if(this.left!=null) {
			this.left.postOrder();
		}

		//�ݹ����������������
		if(this.right!=null) {
			this.right.postOrder();
		}
		//������ڵ�
		System.out.println(this);
	}
	
	//ǰ���������
	public HeroNode preOrderSearch(int no) {
		//�Ƚϵ�ǰ�ڵ�
		if(this.no==no) {
			return this;
		}
		//�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�գ�����Ϊ����ݹ�ǰ�����
		HeroNode ret=null;
		if(this.left!=null) {
			ret=this.left.preOrderSearch(no);
		}
		if(ret!=null) {//���������ҵ�
			return ret;
		}
		//�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�գ�����Ϊ����ݹ�ǰ�����
		if(this.right!=null) {
			ret=this.right.preOrderSearch(no);
		}
		return ret;
	}
	
	//�����������
	public HeroNode infixOrderSearch(int no) {
		//�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�գ�����Ϊ����ݹ��������
		HeroNode ret=null;
		if(this.left!=null) {
			ret=this.left.infixOrderSearch(no);
		}
		if(ret!=null) {//���������ҵ�
			return ret;
		}
		
		//�Ƚϵ�ǰ�ڵ�
		if(this.no==no) {
			return this;
		}
		
		if(this.right!=null) {
			ret=this.right.infixOrderSearch(no);
		}
		return ret;
	}
	
	//�����������
	public HeroNode postOrderSearch(int no) {
		//�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�գ�����Ϊ����ݹ�������
		HeroNode ret=null;
		if(this.left!=null) {
			ret=this.left.postOrderSearch(no);
		}
		if(ret!=null) {//���������ҵ�
			return ret;
		}
		//�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�գ�����Ϊ����ݹ�������
		if(this.right!=null) {
			ret=this.right.postOrderSearch(no);
		}
		if(ret!=null) {//���������ҵ�
			return ret;
		}
		//�Ƚϵ�ǰ�ڵ�
		if(this.no==no) {
			return this;
		}
		return ret;
	}
}
