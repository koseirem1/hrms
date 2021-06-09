package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@Table(name = "verification_code_employers")
@AllArgsConstructor
@NoArgsConstructor
@NonNull
@EqualsAndHashCode(callSuper = true)
public class VerificationCodeEmployer extends VerificationCode {
	@Id
	@PrimaryKeyJoinColumn()
	@Column(name = "id")
	private int verificationCodeEmployer;
	
	@Column(name = "employer_id")
	private int employerId;

}
