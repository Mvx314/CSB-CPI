package sec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sec.project.domain.Signup;

import java.util.List;

public interface SignupRepository extends JpaRepository<Signup, Long> {

}