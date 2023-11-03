package uz.devior.springsecuritybaseauth.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.devior.springsecuritybaseauth.shared.ApplicationResponse;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public ApplicationResponse<?> add(StudentDTO studentDTO) {

        Student student = new Student();
        student.setName(studentDTO.getName());
        studentRepository.save(student);
        return ApplicationResponse.builder()
                .message("New student added")
                .success(true)
                .build();
    }

    public ApplicationResponse<?> get() {

        List<Student> all = studentRepository.findAll();
        return ApplicationResponse.builder()
                .message("Ok")
                .success(true)
                .data(Map.of("Student", all))
                .build();
    }
}
