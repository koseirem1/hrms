package kodlamaio.hrms.core.concretes;

import java.rmi.RemoteException;

import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements MernisService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		boolean result = true;
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName().toUpperCase(), 
					candidate.getLastName().toUpperCase(), candidate.getBirthYear());
			
		} catch (RemoteException e) {
			result=false;
			e.printStackTrace();
		}
		
		
		return result;
	}
	
}
