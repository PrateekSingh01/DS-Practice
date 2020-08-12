package UnionFind;

public class SimpleUnionFind {

	int size;
	int components;
	private int sz[];// Track size of current componets in that root;
	private int parent[];// Track parent of element i;

	public SimpleUnionFind(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size can't be zero0");
		}
		this.size = components= size;
		sz = new int[size];
		parent = new int[size];
		for (int i = 0; i < size; i++) {
			sz[i] = 1;
			parent[i] = i;
		}
	}

	// find the component of element
	public int find(int element) {
		int root = element;
		// Finding root
		while (root != parent[root]) {
			root = parent[root];
		}
		// Compressing to root

		int next;
		while (root != parent[root]) {
			next = parent[element];
			parent[element] = root;
			element = next;
		}
		return root;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int componentSize(int p) {
		return sz[find(p)];
	}

	public int size() {
		return size;
	}

	public void union(int p, int q) {
		int root1 = find(p);
		int root2 = find(q);

		if (root1 == root2) {
			return;
		}
		if (componentSize(root1) > componentSize(root2)) {
			parent[root2] = root1;
			sz[root1] += sz[root2];
		} else {
			parent[root1] = root2;
			sz[root2] += sz[root1];
		}

		components--;
	}

	public static void main(String[] args) {
		SimpleUnionFind uf = new SimpleUnionFind(10);
		uf.union(1, 2);
		uf.union(1, 3);
		uf.union(4, 2);
		System.out.println("sdsdsd");
	}

}
