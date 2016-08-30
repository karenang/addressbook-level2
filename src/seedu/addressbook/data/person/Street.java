package seedu.addressbook.data.person;

public class Street {
	private String street;

	public Street(String street) {
		this.street = street.trim();
	}

	@Override
	public String toString() {
		return this.street;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other instanceof Street) {
			return this.toString().equals(other.toString());
		}
		return false;
	}
}
