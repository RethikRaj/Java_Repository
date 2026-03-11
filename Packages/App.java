package Packages;

import Packages.packageone.Dog;
import Packages.packagetwo.Teacher;

// import Packages.packageone.*; // import all classes and interfaces from a package

class App {
    void run() {

        Packages.packageone.Cat c1 = new Packages.packageone.Cat("Tom"); // Way 1 of using classes from different packages
        c1.meow();


        Dog d1 = new Dog("Labrador"); // Way 2 of using classes from different packages
        d1.fetch();

        Teacher t1 = new Teacher("Rethik", "CSE"); // Way 2 of using classes from different packages
        t1.teach();



        System.out.println("Application started");
    }
}
