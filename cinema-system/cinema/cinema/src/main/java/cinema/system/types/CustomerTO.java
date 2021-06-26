package cinema.system.types;

public class CustomerTO {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    public CustomerTO(Long id, String email, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerTOBuilder builder() {
        return new CustomerTOBuilder();
    }


    public static final class CustomerTOBuilder {
        private Long id;
        private String email;
        private String firstName;
        private String lastName;
        private String phoneNumber;

        public CustomerTOBuilder() {
        }

        public CustomerTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CustomerTOBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerTOBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerTOBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerTOBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerTO build() {
            return new CustomerTO(id, email, firstName, lastName, phoneNumber);
        }
    }
}
