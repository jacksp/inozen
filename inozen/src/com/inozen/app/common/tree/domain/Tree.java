package com.inozen.app.common.tree.domain;

public class Tree {
	protected String nodeid;
	protected String name;
	protected String parentid;
	protected boolean isleaf;
	protected boolean islast;
	protected boolean haschild;
	protected int level;

	public String getNodeId() {
		return nodeid;
	}

	public String getName() {
		return name;
	}

	public String getParentId() {
		return parentid;
	}

	public boolean isLeaf() {
		return isleaf;
	}

	public boolean isLast() {
		return islast;
	}

	public boolean hasChild() {
		return haschild;
	}

	public void setNodeId(String nodeid) {
		this.nodeid = nodeid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParentId(String parentid) {
		this.parentid = parentid;
	}

	public void setLeaf(boolean leaf) {
		this.isleaf = leaf;
	}

	public void setLast(boolean last) {
		this.islast = last;
	}

	public void setHasChild(boolean haschild) {
		this.haschild = haschild;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
}
