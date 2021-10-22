package com.SAProject.SAProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
public class IdGenerator {

    public String generate(){
        return "ORD" + (int)(Math.floor(Math.random()*10000));
    }
}
