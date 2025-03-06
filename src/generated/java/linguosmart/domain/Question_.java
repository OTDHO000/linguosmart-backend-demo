package linguosmart.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Question.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Question_ {

	public static final String CREATED_AT = "createdAt";
	public static final String QUESTION_ID = "questionId";
	public static final String OPTIONS = "options";
	public static final String MARKS = "marks";
	public static final String TYPE = "type";
	public static final String CORRECT_ANSWER = "correctAnswer";
	public static final String CONTENT = "content";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see linguosmart.domain.Question#createdAt
	 **/
	public static volatile SingularAttribute<Question, LocalDateTime> createdAt;
	
	/**
	 * @see linguosmart.domain.Question#questionId
	 **/
	public static volatile SingularAttribute<Question, Long> questionId;
	
	/**
	 * @see linguosmart.domain.Question#options
	 **/
	public static volatile SingularAttribute<Question, String> options;
	
	/**
	 * @see linguosmart.domain.Question#marks
	 **/
	public static volatile SingularAttribute<Question, Integer> marks;
	
	/**
	 * @see linguosmart.domain.Question#type
	 **/
	public static volatile SingularAttribute<Question, String> type;
	
	/**
	 * @see linguosmart.domain.Question#correctAnswer
	 **/
	public static volatile SingularAttribute<Question, String> correctAnswer;
	
	/**
	 * @see linguosmart.domain.Question
	 **/
	public static volatile EntityType<Question> class_;
	
	/**
	 * @see linguosmart.domain.Question#content
	 **/
	public static volatile SingularAttribute<Question, String> content;
	
	/**
	 * @see linguosmart.domain.Question#updatedAt
	 **/
	public static volatile SingularAttribute<Question, LocalDateTime> updatedAt;

}

