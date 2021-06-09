package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_confirms_employers")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
public class EmployeeConfirmEmployer extends EmployeeConfirm {
	@Column(name = "employer_id")
	private int employerId;

}
