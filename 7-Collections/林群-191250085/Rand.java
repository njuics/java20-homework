import java.util.SplittableRandom;
import java.util.function.Supplier;

public interface Rand {
    class RandName implements Supplier<java.lang.String> {
        SplittableRandom r = new SplittableRandom(42);
        private int strlen = 7; //default length

        public RandName(){}
        public RandName(int strlen){
            this.strlen = strlen;
        }

        @Override
        public java.lang.String get(){
            return r.ints(strlen,'a','z' + 1)
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
