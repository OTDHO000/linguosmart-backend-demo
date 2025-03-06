package linguosmart.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(User.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class User_ {

	public static final String LAST_LOGIN = "lastLogin";
	public static final String PASSWORD = "password";
	public static final String ACTIVE = "active";
	public static final String USER_ID = "userId";
	public static final String EMAIL = "email";
	public static final String CREATE_AT = "createAt";
	public static final String USERNAME = "username";

	
	/**
	 * @see linguosmart.domain.User#lastLogin
	 **/
	public static volatile SingularAttribute<User, LocalDateTime> lastLogin;
	
	/**
	 * @see linguosmart.domain.User#password
	 **/
	public static volatile SingularAttribute<User, String> password;
	
	/**
	 * @see linguosmart.domain.User#active
	 **/
	public static volatile SingularAttribute<User, String> active;
	
	/**
	 * @see linguosmart.domain.User
	 **/
	public static volatile EntityType<User> class_;
	
	/**
	 * @see linguosmart.domain.User#userId
	 **/
	public static volatile SingularAttribute<User, String> userId;
	
	/**
	 * @see linguosmart.domain.User#email
	 **/
	public static volatile SingularAttribute<User, String> email;
	
	/**
	 * @see linguosmart.domain.User#createAt
	 **/
	public static volatile SingularAttribute<User, LocalDateTime> createAt;
	
	/**
	 * @see linguosmart.domain.User#username
	 **/
	public static volatile SingularAttribute<User, String> username;

}

