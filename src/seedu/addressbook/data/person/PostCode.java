package seedu.addressbook.data.person;

public class PostCode {
	private String postCode;

	public PostCode(String postCode) {
		this.postCode = postCode.trim();
	}

	@Override
	public String toString() {
		return this.postCode;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other instanceof PostCode) {
			return this.toString().equals(other.toString());
		}
		return false;
	}
}
