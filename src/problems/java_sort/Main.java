// https://www.hackerrank.com/challenges/java-sort/problem

package problems.java_sort;

import problems.input_reader.InputReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Main {
	
	private static class Student {
		int id;
		String name;
		double cgpa;
		static Comparator<Student> comparator;
		
		static {
			comparator = (o1, o2) -> {
				if (o1.cgpa > o2.cgpa) {
					return -1;
				} else if (o1.cgpa < o2.cgpa) {
					return 1;
				} else {
					return o1.name.compareTo(o2.name);
				}
			};
		}
		
		Student(int id, String name, double cgpa) {
			this.id = id;
			this.name = name;
			this.cgpa = cgpa;
		}
		
		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public double getCgpa() {
			return cgpa;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.java_sort/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		
		int n = Integer.parseInt(inputs[0]);
		ArrayList<Student> students = new ArrayList<>(n);
		
		IntStream.range(0, n).boxed().forEach(i -> {
			int id = Integer.parseInt(inputs[i + 1].split(" ")[0]);
			String name = inputs[i + 1].split(" ")[1];
			double cgpa = Double.parseDouble(inputs[i + 1].split(" ")[2]);
			students.add(new Student(id, name, cgpa));
		});
		
		System.out.println(students);
		students.sort(Student.comparator);
		System.out.println(students);
	}
}
