package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "id")
@NonNull
public class Candidate extends User {
	
	@NotBlank(message = "İsim alanı boş geçilemez")
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "Soyad alanı boş geçilemez")
	@NotNull
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message = "TC alanı boş geçilemez")
	@NotNull
	@Column(name="identity_number")
	private String identityNumber;
	
	@NotBlank(message = "Doğum yılı alanı boş geçilemez")
	@NotNull
	@Column(name="birth_year")
	private int birthYear;

}
