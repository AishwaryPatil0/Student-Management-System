package CustomSorting;

import java.util.Comparator;

import sdbms.Student;

public class sortStudentByName implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {

		return x.getName().compareTo(y.getName());
	}


}
