package markova.creature.human;

import java.util.Date;

public class Human
{
    public static HumanBuilder builder() {
        return new Human().new HumanBuilder();
    }

    String fName;
    String lName;
    Date birthDay;

    private Human(){
    }

    public class HumanBuilder {
        public Human build(){
            return Human.this;
        }

        public HumanBuilder setfName(String fName) {
            Human.this.fName = fName;
            return this;
        }

        public HumanBuilder setlName(String lName) {
            Human.this.lName = lName;
            return this;
        }

        public HumanBuilder setBirthDay(Date birthDay) {
            Human.this.birthDay = birthDay;
            return this;
        }
    }
}
