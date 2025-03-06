package linguosmart.dto.examMaterials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Materials implements Serializable {

    private int pageIndex;
    private String examlanguage;
    private List<Content> content;

}
