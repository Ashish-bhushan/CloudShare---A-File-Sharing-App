package in.bhushan.cloudshareAPI.DTO;

import java.time.Instant;

public class ProfileDTO {

    private String id;
    private String clerkId;
    private String email;
    private String firstName;
    private String lastName;
    private Integer credits;
    private String photoUrl;
    private Instant createdAt;

    // No-args constructor
    public ProfileDTO() {}

    // All-args constructor
    public ProfileDTO(String id, String clerkId, String email, String firstName, String lastName,
                      Integer credits, String photoUrl, Instant createdAt) {
        this.id = id;
        this.clerkId = clerkId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
        this.photoUrl = photoUrl;
        this.createdAt = createdAt;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getClerkId() { return clerkId; }
    public void setClerkId(String clerkId) { this.clerkId = clerkId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Integer getCredits() { return credits; }
    public void setCredits(Integer credits) { this.credits = credits; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    // ================= Manual Builder =================
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String clerkId;
        private String email;
        private String firstName;
        private String lastName;
        private Integer credits;
        private String photoUrl;
        private Instant createdAt;

        public Builder id(String id) { this.id = id; return this; }
        public Builder clerkId(String clerkId) { this.clerkId = clerkId; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder firstName(String firstName) { this.firstName = firstName; return this; }
        public Builder lastName(String lastName) { this.lastName = lastName; return this; }
        public Builder credits(Integer credits) { this.credits = credits; return this; }
        public Builder photoUrl(String photoUrl) { this.photoUrl = photoUrl; return this; }
        public Builder createdAt(Instant createdAt) { this.createdAt = createdAt; return this; }

        public ProfileDTO build() {
            return new ProfileDTO(id, clerkId, email, firstName, lastName, credits, photoUrl, createdAt);
        }
    }
}
