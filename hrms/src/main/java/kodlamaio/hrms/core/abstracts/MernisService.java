package kodlamaio.hrms.core.abstracts;


import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisService {
	boolean checkIfRealPerson(Candidate candidate);
}
