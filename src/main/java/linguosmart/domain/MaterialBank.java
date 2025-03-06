package linguosmart.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "material_bank")
public class MaterialBank {

    @Id
    @GeneratedValue
    @Column(name = "material_id")
    private long materialId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "part")
    private String part; // listening reading writing

    @Column(name = "fileUrl")
    private String fileUrl;

    @Column(name = "content1")
    private String content1;

    @Column(name = "content2")
    private String content2;

    @Column(name = "content3")
    private String content3;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "material_question",
     joinColumns = @JoinColumn(name = "material_id",referencedColumnName = "material_id")
    ,inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "questionId"))//cascade = CascadeType.ALL orphanRemoval = true
    private List<Question> questions;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
