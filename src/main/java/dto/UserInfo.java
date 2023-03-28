 package dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	long mobile;
	String email;
	String password;
	Date date;
	String gender;
	String addres;
	String country;
	String[] skills;
	int setAge;

}
