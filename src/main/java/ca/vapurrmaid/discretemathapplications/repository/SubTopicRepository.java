package ca.vapurrmaid.discretemathapplications.repository;

import ca.vapurrmaid.discretemathapplications.domain.MathTopic.SubTopic;
import java.util.Optional;
import org.springframework.data.repository.Repository;

/**
 * This interface is used to interact with persisted {@link SubtTopic} objects.
 *
 * @see ca.vapurrmaid.discretemathapplications.domain.MathTopic.SubTopic
 * @author vapurrmaid
 */
public interface SubTopicRepository extends Repository<SubTopic, Long> {

    Optional<SubTopic> findByName(final String name);

    Iterable<SubTopic> findAll();
}
