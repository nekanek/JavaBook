
package JavaBook.clone;

class Parent {
  public Parent () {}
  public Parent (Parent other) {}

  public String Hello() {
    return "Parent.Hello()";
  }

  // Virtual copy constructor - creates copy of the appropriate type
  public Parent Clone() {
    return new Parent(this);
  }
}

class ChildA extends Parent {
  public ChildA(int value) {
    value_a_ = value;
  }

  public ChildA(ChildA other) {
    value_a_ = other.value_a_;
  }

  // Virtual copy constructor - creates copy of the child type
  public ChildA Clone() {
    return new ChildA(this);
  }

  public String Hello() {
    return "ChildA.Hello(): " + value_a_;
  }

  private int value_a_;
}

class ChildB extends Parent {
  public ChildB(int value) {
    value_b_ = value;
  }

  public ChildB(ChildB other) {
    value_b_ = other.value_b_;
  }

  // Virtual copy constructor - creates copy of the child type
  public ChildB Clone() {
    return new ChildB(this);
  }

  public String Hello() {
    return "ChildB.Hello(): " + value_b_;
  }

  private int value_b_;
}

public class ClonerDemo {
  public static void main(String[] args) {
    Parent var;
    if (args[0].equals("a")) {
      var = new ChildA(47);
    } else if (args[0].equals("b")) {
      var = new ChildB(13);
    } else {
      var = new Parent();
    }
    Parent clone = var.Clone();
    Parent copy = new Parent(var);
    System.out.print(clone.Hello() + "\n");
    System.out.print(copy.Hello() + "\n");
  }
}