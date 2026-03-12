package p09_OOPS.p10_polymorphism;

public class FinalKeywordPolymorphism {
    
}

class C {
    final void lockedMethod() { System.out.println("Cannot override me"); }
}

class D extends C {
    // void lockedMethod() { } // COMPILE ERROR: Cannot override final method
}