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
@Table(name = "employers")
@NonNull
public class Employer extends User {
	
	@NotNull
	@NotBlank
	@Column(name = "company_name")
	private String companyName;
	
	@NotNull
	@NotBlank
	@Column(name = "web_site")
	private String webSite;
	
	@NotNull
	@NotBlank
	@Column(name = "phone_number")
	private String phoneNumber;
	
}
