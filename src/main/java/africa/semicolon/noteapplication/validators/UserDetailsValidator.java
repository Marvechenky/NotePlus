package africa.semicolon.noteapplication.validators;

public class UserDetailsValidator {

        public static boolean isValidPassword(String password){
            return password.matches("[a-zA-Z0-9(@#$!_)]{8,20}");
        }

        public static boolean isValidEmailAddress(String email){
            return email.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}");
        }

        public static boolean isValidUsername(String username){
            return username.matches("[a-zA-Z0-9(@#$!_]{8,20}");
        }
    }

