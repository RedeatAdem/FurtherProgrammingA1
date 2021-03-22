package startpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class StudentListener implements ActionListener {
    private Student student;



    public StudentListener(Student s) {
        student = s;
    }


    public StudentListener() {}


    private void updateName(String firstName, String lastName) {
        // student.updateName(firstName, lastName);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
    }



}