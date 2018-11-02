public class LinkedList implements List {

	private Node head;
	private int size;

	public class Node {
		public Object data;
		public Node next;
	}

	public LinkedList() {
		head = null;
		size = 0;
	}

	public void add(Object object) throws Exception {
		if(size < 0) {
			throw new Exception("Invalid");
		}
		Node node = new Node();
		node.data = object;

		if(size == 0) {
			head = node;
		} else {
			Node previous = find(size - 1);
			previous.next = node;
		}
		size++;
	}

	public void add(int position, Object object) throws Exception {
		if(size < 0) {
			throw new Exception("Invalid");
		}

		Node node = new Node();
		node.data = object;
		
		if(size == 0) {
			node.next = head;
			head = node;
		}
		Node previous = find(position - 1);
		node.next = previous.next;
		previous.next = node;
		size++;
	}

	public Object get(int position) throws Exception {
		if(position < 0 || position >= size) {
			throw new Exception("You cannot retrieve from this position.");
		}
		Node node = head;
		for(int i = 0; i < position; i++) {
			node = node.next;
		}
		return node.data;
	}

	public Node find(int position) {
		Node node = head;
		for(int i = 0; i < position; i++) {
			node = node.next;
		}
		return node;
	}

	public Object remove(int position) throws Exception {
		if(position < 0 || position >= size) {
			throw new Exception("You cannot remove from this position.");
		}
		if(position == 0) {
			Node node = head;
			head = head.next;
			size--;
			return node.data;
		}
		Node previous = find(position - 1);
		Node current = previous.next;
		previous.next = current.next;
		size--;
		return current.data;
	}

	public int size() {
		return size;
	}
}