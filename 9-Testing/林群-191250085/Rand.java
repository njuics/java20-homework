import java.util.SplittableRandom;
import java.util.function.Supplier;

public interface Rand {
    class RandName implements Supplier<String> {
        SplittableRandom r = new SplittableRandom(42);
        private int strLen = 7; //default length

        public RandName(){}
        public RandName(int strLen){
            this.strLen = strLen;
        }

        @Override
        public String get(){
            return r.ints(strLen,'a','z' + 1)
                    .collect(StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            StringBuilder::append).toString();
        }
    }

    class RandGender {
        SplittableRandom r = new SplittableRandom(42);
        public RandGender(){}

        public Gender get(){
            return r.nextBoolean() ? Gender.MALE : Gender.FEMALE;
        }

    }
}
