package linguosmart.dto.examMaterials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Metadata implements Serializable {

    private String version;
    private LocalDateTime lastUpdated;
    private int totalBanks;
}
