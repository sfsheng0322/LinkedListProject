package sun.java.chain;


public class SingleLinkedList {
	
	private PersonNode head;
	private int size;
	
	//增加节点
	public void addNode(Person p) {
		if (isEmpty()) {
			head = new PersonNode(p, null);
		} else {
			head = new PersonNode(p, head);
		}
		size++;
	}
	
	//删除节点
	public void deleteNode(String personName) {
		//情况一：链表节点数为0
		if (isEmpty()) {
			return ;
		}
		//情况二：链表中无此节点
		if (!contains(personName)) {
			return ;
		}
		//情况三：链表中只有一个节点且匹配
		if (size == 1) {
			head = null;
			size = 0;
			return ;
		}
		//情况四：删除的是第一个链表节点
		int index = 0;//被删除节点的索引
		for (PersonNode pn = head; pn != null; pn = pn.getNextNode()) {
			if (pn.getPerson().getName().equals(personName)) {
				break;
			} else {
				index++;
			}
		}
		if (index == 0) {
			head = new PersonNode(head.getNextNode().getPerson(), head.getNextNode().getNextNode());
			size--;
			return ;
		}
		//情况五：删除的不是第一个链表节点
		 int preIndex = 0;//被删除节点的前一个节点的索引
		 for (PersonNode pn = head; pn != null; pn = pn.getNextNode()) {
			 if (preIndex == index - 1) {
				 if (index == size - 1) {//删除的节点是最后一个节点
					 pn.setNextNode(null);
				 } else {
					 pn.setNextNode(pn.getNextNode().getNextNode());
				 }
				 size--;
				 return ;
			 }
			 preIndex++;
		 }
	}
	
	//修改人名
	public void modifyPersonName(String oldName, String newName) {
		if (newName == null || oldName == null) {
			return ;
		}
		Person p = searchPerson(oldName);
		if (p == null) {
			return ;
		}
		p.setName(newName);
	}
	
	//修改年龄
	public void modifyPersonAge(String personName, int age) {
		if (personName == null) {
			return ;
		}
		if (age <= 0) {
			return ;
		}
		Person p = searchPerson(personName);
		if (p == null) {
			return ;
		}
		p.setAge(age);
	}
	
	//根据人名搜索这个人的节点
	public Person searchPerson(String personName) {
		for (PersonNode pn = head; pn != null; pn = pn.getNextNode()) {
			if (pn.getPerson().getName().equals(personName)) {
				return pn.getPerson();
			}
		}
		return null;
	}
	
	//根据人名搜索这个人的节点
	public PersonNode searchNode(String personName) {
		for (PersonNode pn = head; pn != null; pn = pn.getNextNode()) {
			if (pn.getPerson().getName().equals(personName)) {
				return pn;
			}
		}
		return null;
	}
	
	//链表中是否包含该名字的节点
	public boolean contains(String personName) {
		if (!isEmpty()) {
			for (PersonNode pn = head; pn != null; pn = pn.getNextNode()) {
				if (pn.getPerson().getName().equals(personName)) {
					return true;
				}
			}
		}
		return false;
	}
	
	//是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	//打印所有节点
	public void printAllNode() {
		if (!isEmpty()) {
			for (PersonNode pn=head; pn != null; pn = pn.getNextNode()) {
				System.out.println(pn.getPerson().toString());
			}
			System.out.println("----------------------------------------");
		}
	}
	
	//链表反转
	public PersonNode reverse() {
		if (isEmpty()) {
			return null;
		}
		PersonNode pre = head;
		PersonNode cur = head.getNextNode();
		PersonNode next;
		while (cur != null) {
			next = cur.getNextNode();
			cur.setNextNode(pre);
			pre = cur;
			cur = next;
		}
		head.setNextNode(null);
		head = pre;
		return head;
	}
	
	public boolean isLoop() {
		if (head == null || head.getNextNode() == null) {
			return false;
		}
		PersonNode slow = head;
		PersonNode fast = head;
		while (fast != null && fast.getNextNode() != null) {
			slow = slow.getNextNode();
			fast = fast.getNextNode().getNextNode();
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.addNode(new Person("c", 1));
		singleLinkedList.addNode(new Person("ruby", 2));
		singleLinkedList.addNode(new Person("c++", 3));
		singleLinkedList.addNode(new Person("java", 4));
		singleLinkedList.printAllNode();
		
//		singleLinkedList.deleteNode("java");
//		singleLinkedList.printAllNode();
//		
//		singleLinkedList.modifyPersonName("c", "android");
//		singleLinkedList.printAllNode();
//		
//		singleLinkedList.modifyPersonAge("android", 3);
//		singleLinkedList.printAllNode();
//		
//		singleLinkedList.reverse();
//		singleLinkedList.printAllNode();
		
		
//		singleLinkedList.searchNode("c").setNextNode(singleLinkedList.searchNode("java"));
//		singleLinkedList.printAllNode();
		System.out.println("isLoop: "+singleLinkedList.isLoop());
		
	}

}
