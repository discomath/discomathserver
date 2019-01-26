package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.MathTopic.SubTopic;
import ca.vapurrmaid.discretemathapplications.domain.MathTopic.Topic;
import java.util.List;

/**
 * Services related to {@link Topic} and {@link SubTopic} objects.
 *
 * @author vapurrmaid
 */
public interface MathTopicsService {

    /**
     * Returns all available mathematical topics.
     *
     * @return a List of {@link Topic} objects
     */
    List<Topic> getAllTopics();

    /**
     * Returns all available mathematical sub-topics.
     *
     * @return a List of {@link SubTopic} objects
     */
    List<SubTopic> getAllSubTopics();
}
