package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

public interface EmployerService {
	Result add(Employer employer);
	DataResult<User> findByMail(String email);
	DataResult<List<Employer>> getAll();
}
