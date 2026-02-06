package in.bhushan.cloudshareAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bhushan.cloudshareAPI.document.UserCredits;
import in.bhushan.cloudshareAPI.repository.UserCreditRepository;

@Service
public class UserCreditService {

	private final UserCreditRepository userCreditRepository;
	
	
    public UserCreditService(UserCreditRepository userCreditRepository) {
		super();
		this.userCreditRepository = userCreditRepository;
	}


    public UserCredits createInitialCredits(String clerkId) {
        System.out.println("💰 STEP 5: Saving credits for " + clerkId);

        UserCredits userCredits = UserCredits.builder()
                .clerkId(clerkId)
                .credits(5)
                .plan("BASIC")
                .build();

        return userCreditRepository.save(userCredits);
    }
    
    
	
    
}
