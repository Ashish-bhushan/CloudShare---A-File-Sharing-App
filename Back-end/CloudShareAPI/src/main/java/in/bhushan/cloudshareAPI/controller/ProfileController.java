package in.bhushan.cloudshareAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.bhushan.cloudshareAPI.DTO.ProfileDTO;
import in.bhushan.cloudshareAPI.service.ProfileService;

@RestController
public class ProfileController 
{
	private final ProfileService profileservice;

	public ProfileController(ProfileService profileservice) {
		super();
		this.profileservice = profileservice;
	}
	
	@PostMapping("/register")
	public ResponseEntity<ProfileDTO> registerProfile(@RequestBody ProfileDTO prifiledto)
	{
		HttpStatus status = profileservice.existsByClerkId(prifiledto.getClerkId()) ? HttpStatus.OK : HttpStatus.CREATED;
		 ProfileDTO saveProfile  = profileservice.createProfile(prifiledto);
		 return ResponseEntity.status(status).body(saveProfile);
	}
	
	
	
}
