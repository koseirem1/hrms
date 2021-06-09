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
@Table(name = "verification_code_candidates")
@AllArgsConstructor
@NoArgsConstructor
@NonNull
@EqualsAndHashCode(callSuper = true)
public class VerificationCodeCandidate extends VerificationCode {
	@Id
	@PrimaryKeyJoinColumn()
	@Column(name = "id")
	private int verificationCodeId;
	
	@Column(name = "candidate_id")
	private int candidateId;

}
