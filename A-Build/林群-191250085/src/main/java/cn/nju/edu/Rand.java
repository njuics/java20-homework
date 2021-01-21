package cn.nju.edu;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;



public interface Rand {
    class RandName {
        private int strLen = 7; //default length

        public RandName(){}
        public RandName(int strLen){
            this.strLen = strLen;
        }

        public String get(){
            return RandomStringUtils.randomAlphabetic(strLen).toLowerCase();
        }
    }

    class RandGender {
        public RandGender(){}

        public Gender get(){
            return RandomUtils.nextBoolean() ? Gender.MALE : Gender.FEMALE;
        }

    }
}
