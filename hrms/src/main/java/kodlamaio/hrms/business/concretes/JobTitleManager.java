package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	
	private JobTitleDao jobDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobDao) {
		super();
		this.jobDao = jobDao;
	}


	@Override
	public List<JobTitle> getAll() {
		return jobDao.findAll();
	}

}
