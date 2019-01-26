package ca.vapurrmaid.discretemathapplications.domain.MathTopic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A Topic is a major branch or area of Mathematics.
 *
 * @author vapurrmaid
 */
@Entity
@Table(name = "Topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "topic_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "topic")
    @JsonIgnoreProperties("topic")
    private List<SubTopic> subTopics;

    /**
     * Empty constructor for JSON/JPA
     */
    protected Topic() {

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

    public List<SubTopic> getSubTopics() {
        return subTopics;
    }

    public void setSubTopics(List<SubTopic> subTopics) {
        this.subTopics = subTopics;
    }

}
