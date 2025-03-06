package linguosmart.controller;


import linguosmart.dto.examMaterials.MaterialBanks;
import linguosmart.service.ExamMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/material")
public class MaterialController extends AbstractBaseController{

    @Autowired
    ExamMaterialService examMaterialService;

    @PostMapping("/exam-materials")
    public MaterialBanks queryExamMaterial(@RequestParam String part) {
        MaterialBanks mb =examMaterialService.buildExamMaterialByPart(part);
        return mb;
    }

}
