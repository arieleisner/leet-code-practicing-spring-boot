# OOP

## 1. Definition

OOP stands for Object Oriented Programming. Is a way of implement code that uses abstractions from the real
world, called objects, that model real entities. This objects have behavior that is exposed to the external
world, but the internal implementation complexities of those behaviors are hidden. Also, they can inherit
behavior from other objects.

There are 4 main concepts in OOP:

* *Encapsulation*: the internal state of the objects is hidden. Therefore, internal attributes of an object can
ony be modified through controlled methods (getters, setters or public methods).
* *Abstraction*: the internal implementation details are hidden behind public methods, and the objects
only expose the essential behaviors. The users of a class only need to know what a class does, not how it does.
* *Inheritance*: an object can inherit the properties and methods from another class. This allows code reusability.
* *Polymorphism*: allows the same method behave differently depending on the object implementation.


## 2. Why it exists

To make code more easy to understand by modeling real world entities in code, making also the code more modular.

## 3. How it works

## 4. Example

```java
class Animal {
    void speak() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Woof!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal pet = new Dog(); // Polymorphism
        pet.speak();            // Output: Woof!
    }
}
```

## 5. Interview answer (30 sec)

## 6. Common interview questions

## 7. Best practices

## 8. Related topics