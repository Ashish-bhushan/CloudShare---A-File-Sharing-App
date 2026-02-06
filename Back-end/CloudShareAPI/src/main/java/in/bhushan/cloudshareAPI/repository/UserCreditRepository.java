package in.bhushan.cloudshareAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.bhushan.cloudshareAPI.document.UserCredits;

public interface UserCreditRepository extends MongoRepository<UserCredits, String>
{
		
}
