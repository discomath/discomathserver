package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.MathTopic.SubTopic;
import ca.vapurrmaid.discretemathapplications.domain.MathTopic.Topic;
import ca.vapurrmaid.discretemathapplications.repository.SubTopicRepository;
import ca.vapurrmaid.discretemathapplications.repository.TopicRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vapurrmaid
 */
@RequiredArgsConstructor
@Service
public class MathTopicsServiceImpl implements MathTopicsService {

    @Autowired
    private final TopicRepository topicRepository;

    @Autowired
    private final SubTopicRepository subTopicRepository;

    @Override
    public List<Topic> getAllTopics() {
        List<Topic> topicList = new ArrayList<>();
        topicRepository
                .findAll()
                .forEach(topicList::add);
        return topicList;
    }

    @Override
    public List<SubTopic> getAllSubTopics() {
        List<SubTopic> subTopicList = new ArrayList<>();
        subTopicRepository
                .findAll()
                .forEach(subTopicList::add);
        return subTopicList;
    }
}
