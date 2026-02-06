package in.bhushan.cloudshareAPI.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.bhushan.cloudshareAPI.document.ProfileDocument;
import java.util.List;


public interface ProfileRepository extends MongoRepository<ProfileDocument, String>
{
		Optional<ProfileDocument> findByEmail(String email);
		
		ProfileDocument  findByClerkId(String clerkId);
		
		Boolean existsByClerkId(String clerkId);
}
