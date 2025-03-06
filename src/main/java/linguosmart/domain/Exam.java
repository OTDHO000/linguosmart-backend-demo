package linguosmart.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exam_bank")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long examId;

    private String title;

    private String des;

    private int duration;

    private int totalMarks;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "exam_material",
            joinColumns = @JoinColumn(name = "exam_id",referencedColumnName = "examId")
            ,inverseJoinColumns = @JoinColumn(name = "material_id", referencedColumnName = "material_id"))
    private List<MaterialBank> materials;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "exam_questions",
            joinColumns = @JoinColumn(name = "exam_id",referencedColumnName = "examId")
            ,inverseJoinColumns = @JoinColumn(name = "questions_id", referencedColumnName = "questionId"))
    private List<Question> questions;
}
