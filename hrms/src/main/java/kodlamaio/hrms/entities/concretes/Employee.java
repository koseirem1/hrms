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
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "employees")
@NonNull
public class Employee extends User {
	
	@NotBlank(message = "Ad alanı boş geçilemez")
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "Soyad alanı boş geçilemez")
	@NotNull
	@Column(name="last_name")
	private String lastName;

}
