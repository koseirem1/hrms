package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.MailValidationService;


public class MailValidationManagerAdapter implements MailValidationService {

	@Override
	public boolean mailValidation(String mail) {
		return true;
	}



}
