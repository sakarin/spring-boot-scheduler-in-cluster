package th.co.truecorp.omx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import th.co.truecorp.omx.repo.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootScheduledInClusterApplicationTests {
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void contextLoads() {
		studentRepository.findAllStudents();
	}

}
