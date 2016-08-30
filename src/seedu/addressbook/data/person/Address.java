package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

	public static final String EXAMPLE = "314, Pie Street, #15-92, 653589";
	public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format: BLOCK, STREET, UNIT, POSTCODE.";
	public static final String ADDRESS_VALIDATION_REGEX = "\\d{1,3},[\\s\\w]+,[\\s]?[\\d#\\-]+,[\\s]?[\\d]{6}";
	private static final String ADDRESS_DELIMITER = ", ";
	
	private Block block;
	private Street street;
	private Unit unit;
	private PostCode postCode;
	private boolean isPrivate;

	private enum AddressSegment {
		BLOCK(0), STREET(1), UNIT(2), POSTCODE(3);

		private final int index;

		private AddressSegment(int index) {
			this.index = index;
		}

		public int getIndex() {
			return this.index;
		}
	}

	/**
	 * Validates given address.
	 *
	 * @throws IllegalValueException
	 *             if given address string is invalid.
	 */
	public Address(String address, boolean isPrivate) throws IllegalValueException {
		this.isPrivate = isPrivate;
		if (!isValidAddress(address)) {
			throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS + " Example: " + EXAMPLE);
		}
		parseAddressString(address);
	}

	/**
	 * Returns true if a given string is a valid person email.
	 */
	public static boolean isValidAddress(String test) {
		return test.matches(ADDRESS_VALIDATION_REGEX);
	}

	/**
	 * Parses the given address.
	 * @param address is the user's string input
	 * @throws IllegalValueException
	 */
	public void parseAddressString(String address) throws IllegalValueException {
		String[] addressSegments = address.split(ADDRESS_DELIMITER);
		int actualNumberOfSegments = addressSegments.length;
		int expectedNumberOfSegments = AddressSegment.values().length;
		if (actualNumberOfSegments != expectedNumberOfSegments) {
			throw new IllegalValueException("Got " + actualNumberOfSegments + " address segments, want "
					+ expectedNumberOfSegments + " segments.");
		}
		this.block = new Block(addressSegments[AddressSegment.BLOCK.getIndex()]);
		this.street = new Street(addressSegments[AddressSegment.STREET.getIndex()]);
		this.unit = new Unit(addressSegments[AddressSegment.UNIT.getIndex()]);
		this.postCode = new PostCode(addressSegments[AddressSegment.POSTCODE.getIndex()]);
	}

	@Override
	public String toString() {
		String[] segments = {this.block.toString(), this.street.toString(), this.unit.toString(), this.postCode.toString()};
		return String.join(ADDRESS_DELIMITER, segments); 
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {// short circuit if same object
			return true;
		}
		if (other instanceof Address) {
			Address address = (Address) other; // instanceof handles nulls
			return this.block.equals(address.block) && this.street.equals(address.street)
					&& this.unit.equals(address.unit) && this.postCode.equals(address.postCode);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}