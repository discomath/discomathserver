package ca.vapurrmaid.discretemathapplications.controllers;

import ca.vapurrmaid.discretemathapplications.domain.MathTopic.SubTopic;
import ca.vapurrmaid.discretemathapplications.domain.MathTopic.Topic;
import ca.vapurrmaid.discretemathapplications.services.MathTopicsServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST Controller for {@link Topic} and {@link SubTopic} objects.
 *
 * @see ca.vapurrmaid.discretemathapplications.domain.MathTopic.Topic
 * @see ca.vapurrmaid.discretemathapplications.domain.MathTopic.SubTopic
 * @author vapurrmaid
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public final class MathTopicController {

    @Autowired
    private final MathTopicsServiceImpl topicService;

    @GetMapping("/topics")
    public List<Topic> getTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/sub-topics")
    public List<SubTopic> getSubTopics() {
        return topicService.getAllSubTopics();
    }

}
