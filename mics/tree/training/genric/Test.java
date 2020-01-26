package tree.training.genric;

import java.util.Arrays;


public class Test {

	public static void main(String[] args) {
		testInteger();
		testString();
		testStudent();
		//testPerson(); //ClassCastException due to not Implementing the Comparable
	}

	public static void testInteger() {
		BST<Integer> intBst = new BST<>();
		int[] input = { 8, 5, 10, 1, 7, 9, 12 };
		Arrays.stream(input).forEach(intBst::insert);
		System.out.println(intBst);

		intBst.delete(5);
		assert (intBst.size() == 6);
		
		Iterator<Integer> itr = intBst.getIterator();
		while (itr.hasNext()) {
			System.out.print(" " + itr.next());
		}

		System.out.println("\ntestInteger() Passed\n");
	}

	public static void testString() {
		BST<String> stringBst = new BST<>();
		String[] input = { "H", "E", "J", "A", "G", "I", "L" };
		Arrays.stream(input).forEach(stringBst::insert);
		System.out.println(stringBst);

		stringBst.delete("A");
		assert (stringBst.size() == 6);
		
		Iterator<String> itr = stringBst.getIterator();
		while (itr.hasNext()) {
			System.out.print(" " + itr.next());
		}

		System.out.println("\ntestInteger() Passed\n");
	}

	public static void testStudent() {
		BST<Student> studentBst = new BST<>();
		Student[] input = { new Student(1, "H"), new Student(2, "E"), new Student(3, "J"), new Student(4, "A"),
				new Student(5, "G"), new Student(6, "I"), new Student(7, "L") };
		Arrays.stream(input).forEach(studentBst::insert);
		System.out.println(studentBst);

		studentBst.delete(new Student(3, "Shafi"));
		assert (studentBst.size() == 6);
		
		Iterator<Student> itr = studentBst.getIterator();
		while (itr.hasNext()) {
			System.out.print(" " + itr.next());
		}

		System.out.println("\ntestInteger() Passed\n");
	}

	public static void testPerson() {
		BST<Person> studentBst = new BST<>();
		Person[] input = { new Person(1, "H"), new Person(2, "E"), new Person(3, "J"), new Person(4, "A"),
				new Person(5, "G"), new Person(6, "I"), new Person(7, "L") };
		Arrays.stream(input).forEach(studentBst::insert);
		System.out.println(studentBst);

		studentBst.delete(new Person(3, "Shafi"));
		assert (studentBst.size() == 6);
		
		Iterator<Person> itr = studentBst.getIterator();
		while (itr.hasNext()) {
			System.out.print(" " + itr.next());
		}

		System.out.println("\ntestInteger() Passed\n");
	}
}

class Student implements Comparable<Student> {

	int id;
	String name;

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Student) obj).id;
	}

	@Override
	public String toString() {

		return "<" + id + "," + name + ">";
	}
}

// Can not create BST of Person objects, because Person doesn't implements Comparable
class Person {
	int id;
	String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {

		return "<" + id + "," + name + ">";
	}
}
