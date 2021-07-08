package assignment2;

import assignment2.exceptions.InvalidUserDetailException;
import assignment2.models.User;
import assignment2.util.NewUserCreatorUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NewUserCreatorTest {

    @Test
    void getNewUser() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("assignment2/student1").getFile());

        try {
            System.setIn(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        User user = NewUserCreatorUtil.getNewUser() ;

        assertEquals(user.getName(), "Natesh");
        assertEquals(user.getRollNumber(), 1);
        assertEquals(user.getAddress(),"Tumkur" );
        assertEquals(user.getAge(), 21);

        try {
            file = new File(classLoader.getResource("assignment2/student2").getFile());
            System.setIn(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertThrows(InvalidUserDetailException.class , ()->{
            NewUserCreatorUtil.getNewUser() ;
        }, "student2 file has wrong entries for student");
    }
}