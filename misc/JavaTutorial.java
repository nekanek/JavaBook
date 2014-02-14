Interfaces
---------------
public interface SomeInterface extends Interface1, Interface2 {
    (implicitly public)
    default constants declaration  (implicitly public static final)
    (abstract) methods
        ; no {} (does not contain implementation)
    default methods
    static methods

}


class extends C1, then implements I1, I2

public interface Relatable {
    public int isLargerThan(Relatable other);
}

public class RectanglePlus implements Relatable {
    // defaults vars..
    // constructors...
    // methods..
    
    // method, required to implement Relatable interface
    public int isLargerThan(Relatable other) {
        RectanglePlus otherRect = (RectanglePlus)other // casts other to RectanglePlus
        if (this.getArea() > otherRect.getArea() )
            return -1;
        else if (this.getArea() > otherRect.getArea() )
            return 1;
        else
            return 0;
    }
}

Inheritance
---------------
subclass-derived-extended-child
super-base-parent

subclass inherits all members of base class(fields, methods, nested classes), but not constructors which are ot members.

public class MBike extends Bike {

    public int var2;
    
    public MBike (int var1, var2) {
        super(var1);
        this.var2 = var2;
    }

}

instance method in subclass which has the same signature, overrides superclass method
static method with the same signature, hides superclass method

Casting

Public MountainBike myBike = new MountainBike(); //  MountainBike, Bike, Obj
Casting – using object where object of another type (permitted by inheritance and implementations)
Object obj = new MountainBike(); // MountainBike, Obj (implicit casting)
Object obj; MountainBike myBike = obj; // compile-time error: obj is not MountainBike
MountainBike myBike = (MountainBike)obj // explicit casting into MountainBike type – saying at runtime obj will b MountainBike (otherwise exception at runtime)

check:
if (obj instanceOf MountainBike) { MountainBike myBike = (MountainBike)obj; }

Overriding
-------------
Instance method of subclass with the same signature overrides superclass's method.
Overriding method can also return a subtype of the type returned by overridden method: covariant return type.

Method invoked in case of override is the one in subclass.


Static Method in subclass with the same signature as in super class hides superclass method.

The version ofmethod invoked in case of hidden depends on where it was invoked from.

Animal
    StaticMethod
    InstanceMethod
    
Cat extends Animal
    StaticMethod
    InstanceMethod
    
    main:
    Cat myCat = new Cat();
    Animal myAnimal = myCat;
    Animal.StaticMethod(); // Animal - invoked on class
    myAnimal.InstanceMethod(); // Cat - invoked on instance

#further: section in override on Interface methods
