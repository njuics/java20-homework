package com.hw10;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Creature implements Comparable<Creature>{
    private String name;
    private Boolean gender;  // 1 for male, 0 for female
    private final int nameLength = 8;

    public Creature(){
        this.name = RandomStringUtils.randomAlphabetic(nameLength-2,nameLength+2);
        this.gender = RandomUtils.nextBoolean();
    }

    public Creature(String name){
        this.name = name;
        this.gender = RandomUtils.nextBoolean();
    }

    public String getName(){
        return this.name;
    }
    public Boolean getGender(){
        return this.gender;
    }

    public int compareTo(Creature h) {
        if (h.getName().compareTo(this.name)<0)
          return 1;
        else if (h.getName().compareTo(this.name)==0)
          return 0;
        else
          return -1;
    }
}
