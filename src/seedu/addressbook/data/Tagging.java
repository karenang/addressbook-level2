package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
	private Action action;
	private Tag tag;
	private Person person;

	public Tagging(Action action, Tag tag, Person person) {
		this.action = action;
		this.tag = tag;
		this.person = person;
	}

	public Action getAction() {
		return action;
	}

	public Tag getTag() {
		return tag;
	}

	public Person getPerson() {
		return person;
	}
	
	public String toString(){
		return action.toString() + " " + person.getName().toString() + " " + tag.toString();
	}

	private enum Action {
		ADDED("+"), DELETED("-");

		private String value;

		Action(String symbol) {
			this.value = symbol;
		}

		public String toString() {
			return value;
		}
	}

}
