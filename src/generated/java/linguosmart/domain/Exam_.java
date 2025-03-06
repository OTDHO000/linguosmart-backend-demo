package linguosmart.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Exam.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Exam_ {

	public static final String DURATION = "duration";
	public static final String CREATED_AT = "createdAt";
	public static final String DES = "des";
	public static final String MATERIALS = "materials";
	public static final String EXAM_ID = "examId";
	public static final String QUESTIONS = "questions";
	public static final String TITLE = "title";
	public static final String TOTAL_MARKS = "totalMarks";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see linguosmart.domain.Exam#duration
	 **/
	public static volatile SingularAttribute<Exam, Integer> duration;
	
	/**
	 * @see linguosmart.domain.Exam#createdAt
	 **/
	public static volatile SingularAttribute<Exam, LocalDateTime> createdAt;
	
	/**
	 * @see linguosmart.domain.Exam#des
	 **/
	public static volatile SingularAttribute<Exam, String> des;
	
	/**
	 * @see linguosmart.domain.Exam#materials
	 **/
	public static volatile ListAttribute<Exam, MaterialBank> materials;
	
	/**
	 * @see linguosmart.domain.Exam#examId
	 **/
	public static volatile SingularAttribute<Exam, Long> examId;
	
	/**
	 * @see linguosmart.domain.Exam#questions
	 **/
	public static volatile ListAttribute<Exam, Question> questions;
	
	/**
	 * @see linguosmart.domain.Exam#title
	 **/
	public static volatile SingularAttribute<Exam, String> title;
	
	/**
	 * @see linguosmart.domain.Exam#totalMarks
	 **/
	public static volatile SingularAttribute<Exam, Integer> totalMarks;
	
	/**
	 * @see linguosmart.domain.Exam
	 **/
	public static volatile EntityType<Exam> class_;
	
	/**
	 * @see linguosmart.domain.Exam#updatedAt
	 **/
	public static volatile SingularAttribute<Exam, LocalDateTime> updatedAt;

}

