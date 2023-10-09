public class Contact {

    // Basic variable initialization
        private static String id;
        private String firstName;
        private String lastName;
        private String phone;
        private String address;


        // Main constructor for Contact class
        public Contact(String firstName, String lastName, String id, String phone, String address) {
            if (id == null || id.length() > 10) {
                throw new IllegalArgumentException("Invalid id.");
            }
            if (firstName == null || firstName.length() > 10) {
                throw new IllegalArgumentException("Invalid first name.");
            }
            if (lastName == null || lastName.length() > 10) {
                throw new IllegalArgumentException("Invalid last name.");
            }
            if (phone == null || phone.length() != 10) {
                throw new IllegalArgumentException("Invalid phone number.");
            }
            if (address == null || address.length() > 30) {
                throw new IllegalArgumentException("Invalid address.");
            }

            // Setters

            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.address = address;
        }

        // Getters
        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getId() {
            return id;
        }

        public String getPhone() {
            return phone;
        }

        public String getAddress() {
            return address;
        }

}
