package linguosmart.dto.examMaterials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Content implements Serializable {

    private String type;
    private String value;
    private int order;

}
