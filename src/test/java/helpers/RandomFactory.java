package helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomFactory {
    public static String generateEmailAddress(Integer size){
        return RandomStringUtils.randomAlphanumeric(size).toLowerCase() + "@localemailhost.com";
    }
}
