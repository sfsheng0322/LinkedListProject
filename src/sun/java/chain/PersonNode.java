package sun.java.chain;

public class PersonNode {
	
	private Person person;
	private PersonNode nextNode;
	
	public PersonNode(Person person, PersonNode nextNode) {
		this.person = person;
		this.nextNode = nextNode;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public PersonNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(PersonNode nextNode) {
		this.nextNode = nextNode;
	}

}
