package ua.com.rentcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by maks on 29.01.2015.
 */
public class UserValidation {
    private Pattern patternForUsername;
    private Pattern patternForEmail;
    private Pattern patternForPassport;
    private Matcher matcher;

    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    private static final String EMAIL_PATTERN = "[a-zA-Z1-9\\-\\._]+@[a-z1-9]+(.[a-z1-9]+){1,}";
    private static final String PASSPORT_PATTERN ="[\\p{L}]{2}[0-9]{6}";

    public UserValidation(){
        patternForUsername = Pattern.compile(USERNAME_PATTERN);
        patternForEmail = Pattern.compile(EMAIL_PATTERN);
        patternForPassport = Pattern.compile(PASSPORT_PATTERN);
    }

    /**
     * Validate username with regular expression
     * @param username username for validation
     * @return true valid username, false invalid username
     */
    public boolean validateName(final String username){

        matcher = patternForUsername.matcher(username);
        return matcher.matches();

    }
    public boolean validateEmail(final String email){
        matcher = patternForEmail.matcher(email);
        return matcher.matches();
    }
    public boolean validatePassport(final String passport){
        matcher = patternForPassport.matcher(passport);
        return matcher.matches();
    }
}
