package org.nuclei.service.impl;

import org.nuclei.bo.StudentBO;
import org.nuclei.enums.SortComparatorEnum;
import org.nuclei.exception.UserAlreadyExistsException;
import org.nuclei.exception.UserNotFoundException;
import org.nuclei.model.Student;
import org.nuclei.service.StudentService;
import org.nuclei.utils.DeserializeData;
import org.nuclei.utils.SerializeData;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private final String fileLocation;
    private final StudentBO userBO;

    public StudentServiceImpl() {

        this.fileLocation = "src/org/nuclei/resource/students";
        this.userBO = new StudentBO(this.fileLocation);
    }

    public StudentServiceImpl(final String fileLocation) {

        this.fileLocation = fileLocation;
        this.userBO = new StudentBO(this.fileLocation);
    }

    private Student getUserByRollNo(final int rollNo) throws UserNotFoundException {

        return userBO.getStudents().stream()
                .filter(student -> student.getRollNo()==rollNo)
                .findFirst()
                .orElseThrow( UserNotFoundException::new );
    }

    private boolean checkUserByRollNo(final Student student) {

        return userBO.getStudents().stream()
                .anyMatch(x -> Objects.equals(x, student));
    }

    @Override
    public void addUser(final Student student) throws UserAlreadyExistsException {

        if (checkUserByRollNo(student)) {
            throw new UserAlreadyExistsException("User already exists");
        }
        userBO.getStudents().add(student);
        userBO.getStudents().sort(SortComparatorEnum.SORT_BY_ADDRESS_AND_ROLL_NUMBER.getComparator(SortComparatorEnum.SORT_BY_ADDRESS_AND_ROLL_NUMBER.ascendingLiteral));
    }

    @Override
    public void deleteUser(final int rollNo) throws UserNotFoundException {

        userBO.getStudents().remove(this.getUserByRollNo(rollNo));
    }

    @Override
    public List<Student> getUsers() {

        return userBO.getStudents();
    }

    @Override
    public List<Student> getSortedUsers(final String choice, final String order) {

        return getUsers().stream()
                .sorted(SortComparatorEnum.valueOf(choice).getComparator(order))
                .collect(Collectors.toList());
    }

    @Override
    public void flushIntoDisk() throws IOException {

        final SerializeData<Student> handler = new SerializeData<>();
        handler.serializeData(userBO.getStudents(), userBO.getFileName());
    }

    @Override
    public void fetchFromDisk() throws IOException, ClassNotFoundException {

        final DeserializeData<Student> handler = new DeserializeData<>();
        userBO.setStudents(handler.deserializeData(userBO.getFileName()));
    }

}
