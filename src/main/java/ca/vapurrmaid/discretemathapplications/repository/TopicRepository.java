package ca.vapurrmaid.discretemathapplications.repository;

import ca.vapurrmaid.discretemathapplications.domain.MathTopic.Topic;
import org.springframework.data.repository.Repository;

/**
 * This interface is used to interact with persisted {@link Topic} objects.
 *
 * @see ca.vapurrmaid.discretemathapplications.domain.MathTopic.Topic
 * @author vapurrmaid
 */
public interface TopicRepository extends Repository<Topic, Long> {

    Iterable<Topic> findAll();
}
