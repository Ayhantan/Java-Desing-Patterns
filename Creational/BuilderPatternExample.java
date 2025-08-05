package Creational;

public class BuilderPatternExample {

    public static void main(String[] args) {
        // Kullanım
        User user1 = new User.UserBuilder(1, "Ali")
                .email("ali@example.com")
                .phone("1234567890")
                .build();

        User user2 = new User.UserBuilder(2, "Veli").build();

        System.out.println(user1);
        System.out.println(user2);
    }
}

// Asıl sınıf
class User {
    // Zorunlu alanlar
    private final int id;
    private final String name;

    // Opsiyonel alanlar
    private final String email;
    private final String phone;

    // Private constructor → Yalnızca Builder erişebilir
    private User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    @Override
    public String toString() {
        return "User { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                " }";
    }

    // Static nested Builder class
    public static class UserBuilder {
        // Zorunlu
        private final int id;
        private final String name;

        // Opsiyonel
        private String email;
        private String phone;

        public UserBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
