package fundation.project.dat;

public class NodeBlock {

	private static final int SIZE = 1 << 16;

	int[] base;

	int[] check;

	int[] fail;
	
	boolean[] used;

	public NodeBlock() {
		base = new int[SIZE];
		check = new int[SIZE];
		fail = new int[SIZE];
		used = new boolean[SIZE];
	}

}
