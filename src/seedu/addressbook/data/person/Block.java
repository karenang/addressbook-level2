package seedu.addressbook.data.person;

public class Block {
	private String block;
	
	public Block(String block) {
		this.block = block.trim();
	}
	
	@Override
	public String toString() {
		return this.block;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other){
			return true;
		}
		if (other instanceof Block){
			return this.toString().equals(other.toString());
		}
		return false;
	}
}
