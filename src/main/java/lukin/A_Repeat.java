package lukin;

import java.util.Objects;

public class A_Repeat {

    public static void main(String[] args) {
        Person[] persons = createPersons();

        int l = 0;
        int r = persons.length - 1;

        while (l != r) {
            if (persons[l].knows(persons[r])) {
                l++;
            } else {
                r--;
            }
        }

        boolean isFamous = true;
        if (persons[l].getFriends().length != 0) {
            for (int i = 0; i < persons.length; i++) {
                if (i != l && persons[l].knows(persons[i])) {
                    isFamous = false;
                    break;
                }
            }
        }

        if (isFamous)
            System.out.println("Celebrity is " + persons[l].getId());
        else
            System.out.println("No celebrity");

    }

    private static Person[] createPersons() {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person personFamous = new Person();

        person1.setId(1);
        person1.setFriends(new Person[]{person2, personFamous});
        person2.setId(2);
        person2.setFriends(new Person[]{person3, personFamous});
        person3.setId(3);
        person3.setFriends(new Person[]{person1, personFamous});

        Person personFamousFriend = new Person();//он не в нашей компании
        personFamousFriend.setId(5);
        personFamous.friends = new Person[]{personFamousFriend};
        personFamous.setId(4);

        return new Person[]{person1, person2, person3, personFamous};
    }

    private static class Person {
        private long id;
        private Person[] friends;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Person[] getFriends() {
            return friends;
        }

        public void setFriends(Person[] friends) {
            this.friends = friends;
        }

        @Override
        public boolean equals(Object o) {
            return Objects.equals(id, ((Person) o).getId());
        }

        public boolean knows(Person p2) {
            for (Person person : this.getFriends()) {
                if (person.equals(p2)) {
                    return true;
                }
            }
            return false;
        }


    }
}
