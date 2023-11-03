package uz.devior.springsecuritybaseauth.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.devior.springsecuritybaseauth.shared.ApplicationResponse;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody StudentDTO studentDTO){
        ApplicationResponse<?> response = studentService.add(studentDTO);
        return ResponseEntity.status(response.isSuccess()?200:404).body(response);
    }

    @GetMapping
    public ResponseEntity<?> get(){
        ApplicationResponse<?> response = studentService.get();
        return ResponseEntity.status(response.isSuccess()?200:404).body(response);
    }
}
