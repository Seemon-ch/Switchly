package live.switchly.api.repository;

import live.switchly.api.model.Flag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlagRepository extends JpaRepository<Flag, UUID> {

    List<Flag> findByProjectId(UUID projectId);

    boolean existsByProjectIdAndKey(UUID projectId, String key);
}