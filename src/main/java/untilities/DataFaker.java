package untilities;

import com.github.javafaker.Faker;

public class DataFaker {
    Faker faker;

    public DataFaker() {
        faker = new Faker();
    }

    public static DataFaker getDataFaker(){
        return new DataFaker();
    }

    public String getFirstName(){
       return faker.name().firstName();
    }

    public String getLastName(){
       return faker.name().lastName();
    }

    public String getFullName(){
        return faker.name().fullName();
    }

    public String getCityName(){
        return faker.address().cityName();
    }
    public String getAddress(){
        return faker.address().streetAddress();
    }

    public String getPhoneNumber(){
        return faker.phoneNumber().phoneNumber();
    }

    public String getEmailAddress(){
        return faker.internet().emailAddress();
    }

    public String getPassword(){
        return faker.internet().password();
    }
}
