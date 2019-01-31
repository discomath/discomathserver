package ca.vapurrmaid.discretemathapplications.domain.MathTopic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.NonNull;

/**
 * A SubTopic is a unit of study within a {@link Topic}.
 *
 * @author vapurrmaid
 */
@Entity
@Table(name = "SubTopics")
public class SubTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_topic_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "sub_topic_name", nullable = false)
    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnoreProperties("subTopics")
    @NonNull
    private Topic topic;

    /**
     * Empty constructor for JSON/JPA
     */
    protected SubTopic() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
