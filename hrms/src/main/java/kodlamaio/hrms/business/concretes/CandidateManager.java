package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class CandidateManager implements CandidateService {
	
	@Autowired
	private CandidateDao candidateDao;
	//private MailValidationService mailService;
	private MernisService mernisService;
	//private UserDao userDao;
	
	
	@Autowired(required = false)
	public CandidateManager(CandidateDao candidateDao,MernisService mernisService) {
		this.candidateDao = candidateDao;
		this.mernisService = mernisService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Is Arayanlar Listelendi");
	}

	@Override
	public Result add(Candidate candidate) {

	    if(findByMail(candidate.getMail()).getData() != null) {
			return new ErrorResult("Bu e-posta ile kayıtlı kullanıcı mevcuttur.");
		} else if(findByIdentityNumber(candidate.getIdentityNumber()).getData() != null) {
			return new ErrorResult("Girdiğiniz kimlik numarası ile kullanıcı mevcuttur.");
		} else if(!mernisService.checkIfRealPerson(candidate)) {
			return new ErrorResult("Kimlik doğrulaması gerceklestirilemedi.");
		} else {
			this.candidateDao.save(candidate);
			return new SuccessResult("Is Arayan Kisi Kaydı Gerceklesti");
		}
		
	}
	
	@Override
	public DataResult<MernisService> checkIfRealPerson(Candidate candidate) {
		return new SuccessDataResult<MernisService>("Mernis ile doğrulandı.");
	}

	@Override
	public DataResult<Candidate> findByIdentityNumber(String nationalId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByIdentityNumber(nationalId));
	}

	@Override
	public DataResult<User> findByMail(String email) {
		return new SuccessDataResult<User>(this.candidateDao.findByMail(email));
	}

}
