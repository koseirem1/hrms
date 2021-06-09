package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	
	@Autowired
     public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<User> findByMail(String email) {
	  return new SuccessDataResult<User>(this.employerDao.findByMail(email));
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Is Verenler Listelendi");
	}

	@Override
	public Result add(Employer employer) {
	    if(findByMail(employer.getMail()).getData() != null) {
				return new ErrorResult("Bu e-posta ile kayıtlı kullanıcı mevcuttur.");
			}  else {
				this.employerDao.save(employer);
				return new SuccessResult("Is Veren Kaydı Gerceklesti");
			}

	}

}
