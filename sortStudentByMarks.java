package CustomSorting;

import java.util.Comparator;

import sdbms.Student;

public class sortStudentByMarks implements Comparator <Student> {

	@Override
	public int compare(Student x, Student y) {
		
		return x.getMarks()-y.getMarks();
	}

}
