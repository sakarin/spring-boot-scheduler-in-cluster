package th.co.truecorp.omx.repo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import th.co.truecorp.omx.model.Student;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static final String KEY = "Student";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public StudentRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void saveStudent(final Student student) {
        hashOperations.put(KEY, student.getId(), student);
    }

    public void updateStudent(final Student student) {
        hashOperations.put(KEY, student.getId(), student);
    }

    public Student findStudent(final String id) {
        return (Student) hashOperations.get(KEY, id);
    }

    public Map<Object, Object> findAllStudents() {
        return hashOperations.entries(KEY);
    }

    public void deleteStudent(final String id) {
        hashOperations.delete(KEY, id);
    }
}
