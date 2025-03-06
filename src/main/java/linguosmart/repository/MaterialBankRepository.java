package linguosmart.repository;

import linguosmart.domain.MaterialBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaterialBankRepository extends JpaRepository<MaterialBank,Long> {


    Optional<MaterialBank> findByTitleAndPart(String title,String part);
}
