package seedu.addressbook.data.person;

public class Unit {
	private String unit;

	public Unit(String unit) {
		this.unit = unit.trim();
	}

	@Override
	public String toString() {
		return this.unit;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other instanceof Unit) {
			return this.toString().equals(other.toString());
		}
		return false;
	}
}
