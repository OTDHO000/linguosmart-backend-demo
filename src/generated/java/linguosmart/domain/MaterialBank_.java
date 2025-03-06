package linguosmart.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(MaterialBank.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class MaterialBank_ {

	public static final String PART = "part";
	public static final String QUESTIONS = "questions";
	public static final String DESCRIPTION = "description";
	public static final String MATERIAL_ID = "materialId";
	public static final String TITLE = "title";
	public static final String TYPE = "type";
	public static final String CREATE_AT = "createAt";
	public static final String CONTENT3 = "content3";
	public static final String CONTENT2 = "content2";
	public static final String CONTENT1 = "content1";
	public static final String FILE_URL = "fileUrl";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see linguosmart.domain.MaterialBank#part
	 **/
	public static volatile SingularAttribute<MaterialBank, String> part;
	
	/**
	 * @see linguosmart.domain.MaterialBank#questions
	 **/
	public static volatile ListAttribute<MaterialBank, Question> questions;
	
	/**
	 * @see linguosmart.domain.MaterialBank#description
	 **/
	public static volatile SingularAttribute<MaterialBank, String> description;
	
	/**
	 * @see linguosmart.domain.MaterialBank#materialId
	 **/
	public static volatile SingularAttribute<MaterialBank, Long> materialId;
	
	/**
	 * @see linguosmart.domain.MaterialBank#title
	 **/
	public static volatile SingularAttribute<MaterialBank, String> title;
	
	/**
	 * @see linguosmart.domain.MaterialBank#type
	 **/
	public static volatile SingularAttribute<MaterialBank, String> type;
	
	/**
	 * @see linguosmart.domain.MaterialBank#createAt
	 **/
	public static volatile SingularAttribute<MaterialBank, LocalDateTime> createAt;
	
	/**
	 * @see linguosmart.domain.MaterialBank#content3
	 **/
	public static volatile SingularAttribute<MaterialBank, String> content3;
	
	/**
	 * @see linguosmart.domain.MaterialBank#content2
	 **/
	public static volatile SingularAttribute<MaterialBank, String> content2;
	
	/**
	 * @see linguosmart.domain.MaterialBank#content1
	 **/
	public static volatile SingularAttribute<MaterialBank, String> content1;
	
	/**
	 * @see linguosmart.domain.MaterialBank#fileUrl
	 **/
	public static volatile SingularAttribute<MaterialBank, String> fileUrl;
	
	/**
	 * @see linguosmart.domain.MaterialBank
	 **/
	public static volatile EntityType<MaterialBank> class_;
	
	/**
	 * @see linguosmart.domain.MaterialBank#updatedAt
	 **/
	public static volatile SingularAttribute<MaterialBank, LocalDateTime> updatedAt;

}

