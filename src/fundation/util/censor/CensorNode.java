package fundation.util.censor;

import java.util.Map;

public class CensorNode {

	private Map<Character, CensorNode> children;

	private char ch;

	private boolean isEnd;

	public Map<Character, CensorNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, CensorNode> children) {
		this.children = children;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

}
