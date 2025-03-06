package linguosmart.dto.examMaterials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MaterialBanks implements Serializable {

    private Metadata metadata;
    private Map<String, Map<String, List<Materials>>>  banks;

}
