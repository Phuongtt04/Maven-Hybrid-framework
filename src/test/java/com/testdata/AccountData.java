package com.testdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class AccountData {
    public static AccountData getAccountData(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_PATH + "Account.json"), AccountData.class);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("webEmail")
    private String webEmail;

    static class Login{
        @JsonProperty("userName")
        String userName;

        @JsonProperty("password")
        String password;
    }

    @JsonProperty("Login")
    private Login login;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getWebEmail() {
        return webEmail;
    }

    public String getUserName() {
        return login.userName;
    }

    public String getPassword() {
        return login.password;
    }
}
