package in.bhushan.cloudshareAPI.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.mongodb.DuplicateKeyException;

import in.bhushan.cloudshareAPI.DTO.ProfileDTO;
import in.bhushan.cloudshareAPI.document.ProfileDocument;
import in.bhushan.cloudshareAPI.repository.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    // ✅ Constructor injection (replaces @RequiredArgsConstructor)
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileDTO createProfile(ProfileDTO profileDto) 
    {
    		
    	if(profileRepository.existsByClerkId(profileDto.getClerkId()))
    	{
    		return updateProfile(profileDto);
    	}
    	
    	
        // ✅ DTO → Document
        ProfileDocument profileDocument = new ProfileDocument();
        profileDocument.setClerkId(profileDto.getClerkId());
        profileDocument.setEmail(profileDto.getEmail());
        profileDocument.setFirstName(profileDto.getFirstName());
        profileDocument.setLastName(profileDto.getLastName());
        profileDocument.setCredits(5);
        profileDocument.setPhotoUrl(profileDto.getPhotoUrl());
        profileDocument.setCreatedAt(Instant.now());

        // createdAt will be auto-set by @CreatedDate
        ProfileDocument savedProfile=profileRepository.save(profileDocument);
       

        // ✅ Document → DTO
        ProfileDTO responseDto = new ProfileDTO();
        responseDto.setId(savedProfile.getId());
        responseDto.setClerkId(savedProfile.getClerkId());
        responseDto.setEmail(savedProfile.getEmail());
        responseDto.setFirstName(savedProfile.getFirstName());
        responseDto.setLastName(savedProfile.getLastName());
        responseDto.setCredits(savedProfile.getCredits());
        responseDto.setPhotoUrl(savedProfile.getPhotoUrl());
        responseDto.setCreatedAt(savedProfile.getCreatedAt());

        return responseDto;
    }
    
    public ProfileDTO updateProfile(ProfileDTO profileDTO)
    {
    	ProfileDocument existing_profile_data = profileRepository.findByClerkId(profileDTO.getClerkId());
		if(existing_profile_data != null)
		{
			//update fields if provided
			if(profileDTO.getEmail() != null && !profileDTO.getEmail().isEmpty())
			{
				existing_profile_data.setEmail(profileDTO.getEmail());
			}
			if(profileDTO.getFirstName() != null && !profileDTO.getFirstName().isEmpty())
			{
				existing_profile_data.setFirstName(profileDTO.getFirstName());
			}
			if(profileDTO.getLastName() != null && !profileDTO.getLastName().isEmpty())
			{
				existing_profile_data.setLastName(profileDTO.getLastName());
			}
			if(profileDTO.getPhotoUrl() != null && !profileDTO.getPhotoUrl().isEmpty())
			{
				existing_profile_data.setPhotoUrl(profileDTO.getPhotoUrl());
			}
			
			
			profileRepository.save(existing_profile_data);
			
			ProfileDTO responseDto = new ProfileDTO();
			responseDto.setId(existing_profile_data.getId());
			responseDto.setEmail(existing_profile_data.getEmail());
			responseDto.setClerkId(existing_profile_data.getClerkId());
			responseDto.setFirstName(existing_profile_data.getFirstName());
			responseDto.setLastName(existing_profile_data.getLastName());
			responseDto.setCredits(existing_profile_data.getCredits());
			responseDto.setCreatedAt(existing_profile_data.getCreatedAt());
			responseDto.setPhotoUrl(existing_profile_data.getPhotoUrl());
			
			
		}
		return profileDTO;
    }

	public Boolean existsByClerkId(String clerkId) 
	{
		return profileRepository.existsByClerkId(clerkId);
	}
	
	public void deletedProfile(String clerkId)
	{
		ProfileDocument existingProfile =  profileRepository.findByClerkId(clerkId);
		
		if(existingProfile != null)
		{
			profileRepository.delete(existingProfile);
		}
		
	}

	
    
}
