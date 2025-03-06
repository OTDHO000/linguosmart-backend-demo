package linguosmart.service;


import linguosmart.domain.MaterialBank;
import linguosmart.dto.examMaterials.*;
import linguosmart.repository.MaterialBankRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExamMaterialService {

    @Autowired
    MaterialBankRepository materialBankRepository;

    public MaterialBanks buildExamMaterialAll(){

        return new MaterialBanks();
    }

    public MaterialBanks buildExamMaterialByPart(String part){

        Optional<MaterialBank>mbank = materialBankRepository.findByTitleAndPart("EN-IEL16","reading");
        if("reading".equals(part)){
           return convertToMaterialBanks(mbank.get());
        }
        if("listening".equals(part)){
            return convertToMaterialBanks(mbank.get());
        }
        if("writing".equals(part)){
            return convertToMaterialBanks(mbank.get());
        }

        return null;

    }

    public MaterialBanks convertToMaterialBanks(MaterialBank material){

            List<Content> contentlist = new ArrayList<>();
            Content content1 = new Content();
            content1.setValue(material.getContent1());
            content1.setType(material.getType());
            content1.setOrder(1);
            contentlist.add(content1);
            if(StringUtils.isNoneBlank(material.getContent2())){
                Content content2 = new Content();
                content2.setValue(material.getContent2());
                content2.setType(material.getType());
                content2.setOrder(2);
                contentlist.add(content2);
            }
            if(StringUtils.isNoneBlank(material.getContent3())){
                Content content3 = new Content();
                content3.setValue(material.getContent3());
                content3.setType(material.getType());
                content3.setOrder(2);
                contentlist.add(content3);
            }
            Materials materials = new Materials();
            materials.setPageIndex(0);
            materials.setExamlanguage("en");
            materials.setContent(contentlist);

            List<Materials> mlist = new ArrayList<>();
            mlist.add(materials);

            // create Banks Map
            Map<String, List<Materials>> materialsMap = new HashMap<>();
//            String bankname = material.getTitle()+"-R-";
            materialsMap.put("materials", mlist);

            Map<String, Map<String, List<Materials>>  >banks = new HashMap<>();
            banks.put(material.getTitle(),materialsMap);

            Metadata metadata = new Metadata();
            metadata.setVersion("1.0");
            metadata.setTotalBanks(1);
            metadata.setLastUpdated(LocalDateTime.now());

            MaterialBanks materialBanks = new MaterialBanks();
            materialBanks.setMetadata(metadata);
            materialBanks.setBanks(banks);
            return materialBanks;

    }

}
