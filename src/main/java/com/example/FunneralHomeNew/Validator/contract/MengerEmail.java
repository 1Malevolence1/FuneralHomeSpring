/*
package com.example.FunneralHomeNew.Validator.contract;

import com.example.FunneralHomeNew.models.email.Email;
import org.springframework.beans.factory.annotation.Autowired;

public class MengerEmail {
    private  Email email;

    @Autowired
    public MengerEmail(Email email) {
        this.email = email;
    }

    public Email splitEmail(String fullEmail){
        StringBuilder stringBuilder = new StringBuilder(fullEmail);

        int itemOne = stringBuilder.indexOf("@");
        int itemTwo = stringBuilder.indexOf(".");

        String userName = stringBuilder.substring(0, itemOne);
        String domain = stringBuilder.substring(itemOne, itemTwo);
        String extension = stringBuilder.substring(itemTwo, stringBuilder.length());

        email.setUsername(userName);
        email.setDomain(domain);
        email.setExtension(extension);
        return email;
    }
}
*/
