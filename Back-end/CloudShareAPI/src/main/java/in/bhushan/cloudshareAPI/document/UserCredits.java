package in.bhushan.cloudshareAPI.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_credits")
public class UserCredits {

    @Id
    private String id;
    private String clerkId;
    private Integer credits;
    private String plan;

    // =================== Constructors ===================

    // No-args constructor
    public UserCredits() {}

    // All-args constructor
    public UserCredits(String id, String clerkId, Integer credits, String plan) {
        this.id = id;
        this.clerkId = clerkId;
        this.credits = credits;
        this.plan = plan;
    }

    // =================== Getters & Setters ===================

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

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    // =================== Manual Builder ===================

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String clerkId;
        private Integer credits;
        private String plan;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder clerkId(String clerkId) {
            this.clerkId = clerkId;
            return this;
        }

        public Builder credits(Integer credits) {
            this.credits = credits;
            return this;
        }

        public Builder plan(String plan) {
            this.plan = plan;
            return this;
        }

        public UserCredits build() {
            return new UserCredits(id, clerkId, credits, plan);
        }
    }
}
