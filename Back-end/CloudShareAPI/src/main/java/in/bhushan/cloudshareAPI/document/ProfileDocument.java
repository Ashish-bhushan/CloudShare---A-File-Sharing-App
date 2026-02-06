package in.bhushan.cloudshareAPI.document;

import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profiles")
public class ProfileDocument {

    private String id;
    private String clerkId;

    @Indexed(unique = true)
    private String email;

    private String firstName;
    private String lastName;
    private Integer credits;
    private String photoUrl;

    @CreatedDate
    private Instant createdAt;

    // ✅ No-args constructor (required by Spring Data)
    public ProfileDocument() {
    }

    // ✅ All-args constructor
    public ProfileDocument(
            String id,
            String clerkId,
            String email,
            String firstName,
            String lastName,
            Integer credits,
            String photoUrl,
            Instant createdAt) {

        this.id = id;
        this.clerkId = clerkId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
        this.photoUrl = photoUrl;
        this.createdAt = createdAt;
    }

    // ✅ Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClerkId() {
        return clerkId;
    }

    public void setClerkId(String clerkId) {
        this.clerkId = clerkId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    // ✅ equals & hashCode (important for Mongo entities)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileDocument)) return false;
        ProfileDocument that = (ProfileDocument) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ✅ toString (optional but useful)
    @Override
    public String toString() {
        return "ProfileDocument{" +
                "id='" + id + '\'' +
                ", clerkId='" + clerkId + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", credits=" + credits +
                ", photoUrl='" + photoUrl + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
