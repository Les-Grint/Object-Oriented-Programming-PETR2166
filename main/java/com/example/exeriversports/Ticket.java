package com.example.exeriversports;

// This declares the interface 'Ticket'. Interface classes cannot be instantiated but
// can be implemented by other classes or extended by other interfaces.
public interface Ticket {

    // This declares the method 'getDescription' and the string variable data type
    // but does not define the method.
    public String getDescription();

    // This declares the method 'getCost' and the double variable data type but does
    // not define the method.
    public double getCost();
}

// This declares the class 'Adult_Ticket' and uses the key word/statement 'implemments' to
// implement the interface 'Ticket', in this case meaning that this subclass must implement
// the same methods that are present in the super class.
class Adult_Ticket implements Ticket {

    // This '@Override' annotation instructs Java to overide the method in the super
    // class with this method in its place.
    @Override
    // This declares the method 'getDescription' and the string variable data type.
    public String getDescription() {
        // This is the definition of the method, assigning the value 'Adult Ticket' to
        // the string variable which will be returned.
        return "- Adult Ticket\n";
    }

    public double ePrice = 10.00;

    // This '@Override' annotation instructs Java to overide the method in the super
    // class with this method in its place.
    @Override
    // This declares the method 'getCost' and the double variable data type.
    public double getCost() {
        // This is the definition of the method assigning the value '10.00' to the double
        // variable which will be returned.
        return 10.00;
    }
}

// This declares the class 'Child_Ticket' and uses the key word/statement 'implemments' to
// implement the interface 'Ticket', in this case meaning that this subclass must implement
// the same methods that are present in the super class.
class Child_Ticket implements Ticket {

    // This '@Override' annotation instructs Java to overide the method in the super
    // class with this method in its place.
    @Override
    // This declares the method 'getDescription' and the string variable data type.
    public String getDescription() {
        // This is the definition of the method, assigning the value 'Child Ticket' to
        // the string variable which will be returned.
        return "- Child Ticket\n";
    }

    public double ePrice = 5.00;

    // This '@Override' annotation instructs Java to overide the method in the super
    // class with this method in its place.
    @Override
    // This declares the method 'getCost' and the double variable data type.
    public double getCost() {
        // This is the definition of the method assigning the value '5.00' to the double
        // variable which will be returned.
        return 5.00;
    }
}

// This declares the class 'Member_Ticket' and uses the key word/statement 'implemments' to
// implement the interface 'Ticket', in this case meaning that this subclass must implement
// the same methods that are present in the super class.
class Member_Ticket implements Ticket {

    // This '@Override' annotation instructs Java to overide the method in the super
    // class with this method in its place.
    @Override
    // This declares the method 'getDescription' and the string variable data type.
    public String getDescription() {
        // This is the definition of the method, assigning the value 'Member Ticket' to
        // the string variable which will be returned.
        return "- Member Ticket\n";
    }

    public double ePrice = 8.00;

    // This '@Override' annotation instructs Java to overide the method in the super
    // class with this method in its place.
    @Override
    // This declares the method 'getCost' and the double variable data type.
    public double getCost() {
        // This is the definition of the method assigning the value '8.00' to the double
        // variable which will be returned.
        return 8.00;
    }
}

// This declares the Abstract class 'Ticket_Decorator'. Abstract classes cannot be instantiated
// but can be extended by another class creating a subclass. Here the 'Ticket_Decorator' class
// uses the key word/statement 'implemments' to implement the interface 'Ticket'. In this case
// meaning that this subclass must implement the same methods that are present in the super class.
// This is an aggregation relationship or a "Has-A" relationship.
abstract class Ticket_Decorator implements Ticket {

    // This sets the access modifier to protected then creates a new object
    // 'Ticket_Ob' from the class 'Ticket'. The Protected access level means access
    // to the created object is only enabled for the class, the package and the
    // subclasses.
    protected Ticket Ticket_Ob;

    // This is the constructor that will create the object 'New_Ticket'.
    public Ticket_Decorator(Ticket New_Ticket) {
        // This declares that the object 'Ticket_Ob' is equal to the object 'New_Ticket'.
        Ticket_Ob = New_Ticket;
    }

    // This declares the method 'getDescription' and the string variable data type.
    public String getDescription() {
        // This is the definition of the method, it calls the 'getDescription' method
        // from the object 'Ticket_Ob' and returns the value.
        return Ticket_Ob.getDescription();
    }

    // This declares the method 'getCost' and the double variable data type.
    public double getCost() {
        // This is the definition of the method, it calls the 'getCost' method from the
        // object 'Ticket_Ob' and returns the value.
        return Ticket_Ob.getCost();
    }
}

// This declares the class 'Front_Row_Section' and uses the key word/statement 'extends' to
// extend the class 'Ticket_Decorator', meaning that this is a subclass that inherits
// all of the properties and methods from the super class 'Ticket_Decorator'.
class Front_Row_Section extends Ticket_Decorator {

    // This is the constructor that will create the object 'New_Ticket'.
    public Front_Row_Section(Ticket New_Ticket) {
        // This uses the 'super' keyword/statement to initialise the constructor by
        // calling the super class Ticket_Decorator.
        super(New_Ticket);
        // This outputs the text 'Added Front Row Section   £'
        System.out.println("Added Front Row Section   £" + price);
    }

    private double price = 5.00;

    // This declares the method 'getDescription' and the string variable data type.
    public String getDescription() {
        // This is the definition of the method, it calls the 'getDescription' method
        // from the object 'Ticket_Ob' and adds the string value '", Front Row Section"' to
        // the accumulating value, then returns the value.
        return Ticket_Ob.getDescription() + "- Front Row Section\n";
    }

    // This declares the method 'getCost' and the double variable data type.
    public double getCost() {
        // This is the definition of the method, it calls the 'getCost' method
        // from the object 'Ticket_Ob' and adds the double value '5.00' to the
        // accumulating value, then returns the value.
        return Ticket_Ob.getCost() + price;
    }
}

// This declares the class 'Middle_Row_Section' and uses the key word/statement 'extends' to
// extend the class 'Ticket_Decorator', meaning that this is a subclass that inherits
// all of the properties and methods from the super class 'Ticket_Decorator'.
class Middle_Row_Section extends Ticket_Decorator {

    // This is the constructor that will create the object 'New_Ticket'.
    public Middle_Row_Section(Ticket New_Ticket) {
        // This uses the 'super' keyword/statement to initialise the constructor by
        // calling the super class Ticket_Decorator.
        super(New_Ticket);
        // This outputs the text 'Added Middle Row Section   £'
        System.out.println("Added Middle Row Section   £" + price);
    }

    private double price = 3.00;

    // This declares the method 'getDescription' and the string variable data type.
    public String getDescription() {
        // This is the definition of the method, it calls the 'getDescription' method
        // from the object 'Ticket_Ob' and adds the string value '", Middle Row Section"' to
        // the accumulating value, then returns the value.
        return Ticket_Ob.getDescription() + "- Middle Row Section\n";
    }

    // This declares the method 'getCost' and the double variable data type.
    public double getCost() {
        // This is the definition of the method, it calls the 'getCost' method
        // from the object 'Ticket_Ob' and adds the double value '3.00' to the
        // accumulating value, then returns the value.
        return Ticket_Ob.getCost() + price;
    }
}

// This declares the class 'Back_Row_Section' and uses the key word/statement 'extends' to
// extend the class 'Ticket_Decorator', meaning that this is a subclass that inherits
// all of the properties and methods from the super class 'Ticket_Decorator'.
class Back_Row_Section extends Ticket_Decorator {

    // This is the constructor that will create the object 'New_Ticket'.
    public Back_Row_Section(Ticket New_Ticket) {
        // This uses the 'super' keyword/statement to initialise the constructor by
        // calling the super class Ticket_Decorator.
        super(New_Ticket);
        // This outputs the text 'Added Back Row Section   £'
        System.out.println("Added Back Row Section   £" + price);
    }

    private double price = 0.00;

    // This declares the method 'getDescription' and the string variable data type.
    public String getDescription() {
        // This is the definition of the method, it calls the 'getDescription' method
        // from the object 'Ticket_Ob' and adds the string value '", Back Row Section"' to
        // the accumulating value, then returns the value.
        return Ticket_Ob.getDescription() + "- Back Row Section\n";
    }

    // This declares the method 'getCost' and the double variable data type.
    public double getCost() {
        // This is the definition of the method, it calls the 'getCost' method
        // from the object 'Ticket_Ob' and adds the double value '0.00' to the
        // accumulating value, then returns the value.
        return Ticket_Ob.getCost() + price;
    }
}

// This declares the class 'Meal_Deal' and uses the key word/statement 'extends' to
// extend the class 'Ticket_Decorator', meaning that this is a subclass that inherits
// all of the properties and methods from the super class 'Ticket_Decorator'.
class Meal_Deal extends Ticket_Decorator {

    // This is the constructor that will create the object 'New_Ticket'.
    public Meal_Deal(Ticket New_Ticket) {
        // This uses the 'super' keyword/statement to initialise the constructor by
        // calling the super class Ticket_Decorator.
        super(New_Ticket);
        // This outputs the text 'Added Meal Deal. Any Food/Side/Snack/Drink Combo From Any Vendor On Site   £'
        System.out.println("Added Meal Deal. Any Food/Side/Snack/Drink Combo From Any Vendor On Site   £" + price);
    }

    private double price = 7.00;

    // This declares the method 'getDescription' and the string variable data type.
    public String getDescription() {
        // This is the definition of the method, it calls the 'getDescription' method
        // from the object 'Ticket_Ob' and adds the string value '", Meal Deal. Any Food/Side/Snack/Drink Combo From Any Vendor On Site"' to
        // the accumulating value, then returns the value.
        return Ticket_Ob.getDescription() + "- Meal Deal (Any Food/Drink Combo On Site)\n";
    }

    // This declares the method 'getCost' and the double variable data type.
    public double getCost() {
        // This is the definition of the method, it calls the 'getCost' method
        // from the object 'Ticket_Ob' and adds the double value '4.00' to the
        // accumulating value, then returns the value.
        return Ticket_Ob.getCost() + price;
    }
}

// This declares the class 'VIP_Access' and uses the key word/statement 'extends' to
// extend the class 'Ticket_Decorator', meaning that this is a subclass that inherits
// all of the properties and methods from the super class 'Ticket_Decorator'.
class VIP_Access extends Ticket_Decorator {

    // This is the constructor that will create the object 'New_Ticket'.
    public VIP_Access(Ticket New_Ticket) {
        // This uses the 'super' keyword/statement to initialise the constructor by
        // calling the super class Ticket_Decorator.
        super(New_Ticket);
        // This outputs the text 'Added VIP Access to Private Loung and Bar + Valet Parking, Que Jump and Early Entry   £'
        System.out.println("Added VIP Access to Private Lounge and Bar + Valet Parking, Que Jump and Early Entry   £" + price);
    }

    private double price = 4.00;

    // This declares the method 'getDescription' and the string variable data type.
    public String getDescription() {
        // This is the definition of the method, it calls the 'getDescription' method
        // from the object 'Ticket_Ob' and adds the string value '", VIP Access to Private Loung and Bar + Valet Parking, Que Jump and Early Entry"' to
        // the accumulating value, then returns the value.
        return Ticket_Ob.getDescription() + "VIP Access\n--- Access to Private Lounge\n--- Access to Private Bar\n--- Valet Parking\n--- Que Jump\n--- Early Entry\n";
    }

    // This declares the method 'getCost' and the double variable data type.
    public double getCost() {
        // This is the definition of the method, it calls the 'getCost' method
        // from the object 'Ticket_Ob' and adds the double value '4.00' to the
        // accumulating value, then returns the value.
        return Ticket_Ob.getCost() + price;
    }
}

// This declares the class 'Grounds_Tour' and uses the key word/statement 'extends' to
// extend the class 'Ticket_Decorator', meaning that this is a subclass that inherits
// all of the properties and methods from the super class 'Ticket_Decorator'.
class Grounds_Tour extends Ticket_Decorator {

    // This is the constructor that will create the object 'New_Ticket'.
    public Grounds_Tour(Ticket New_Ticket) {
        // This uses the 'super' keyword/statement to initialise the constructor by
        // calling the super class Ticket_Decorator.
        super(New_Ticket);
        // This outputs the text 'Added Guided Tour of the Grounds   £'
        System.out.println("Added Guided Tour of the Grounds   £" + price);
    }

    private double price = 4.00;

    // This declares the method 'getDescription' and the string variable data type.
    public String getDescription() {
        // This is the definition of the method, it calls the 'getDescription' method
        // from the object 'Ticket_Ob' and adds the string value '", Guided Tour of the Grounds"' to
        // the accumulating value, then returns the value.
        return Ticket_Ob.getDescription() + "- Guided Tour of the Grounds\n";
    }

    // This declares the method 'getCost' and the double variable data type.
    public double getCost() {
        // This is the definition of the method, it calls the 'getCost' method
        // from the object 'Ticket_Ob' and adds the double value '4.00' to the
        // accumulating value, then returns the value.
        return Ticket_Ob.getCost() + price;
    }
}

// This declares the class 'Ticket_Selection'.
class Ticket_Selection {

    // This is the entry point of the program and the main method itself.
    // Potentially every other aspect of the program may need to access it meaning
    // the access modifier must be public.
    // The static method enables the calling of the main method without the need to
    // create an object first, while void means the method has no return value.
    public static void main(String[] args) {

        // Here the Decorator Design Pattern creates an entire Coffee by creating a new
        // object 'Custom_Ticket' from the class 'Coffee' and setting it as equal to
        // the following chain of events.
        // First the Espresso object is sent to the SteamedMilk constructor, then to
        // the CaramelSyrup constructor, and finally to the HazelnutSyrup constructor
        // effectively creating a Coffee with Steamed Milk, Caramel Syrup and Hazelnut
        // Syrup.
        // Realistically however creating the object 'Custom_Ticket' which is wrapped in
        // the decorator classes 'SteamedMilk', 'CaramelSyrup' and 'HazelnutSyrup'.
        Ticket Custom_Ticket = new VIP_Access(new Meal_Deal(new Front_Row_Section(new Adult_Ticket())));

        // This outputs the text 'Custom Ticket ' then calls the 'getDescription' method
        // from the object 'Custom_Ticket' and returns and outputs the accumulated value.
        // System.out.println("\nCustom Ticket\n" + Custom_Ticket.getDescription());

        // This outputs the text 'Price: £' then calls the 'getCost' method
        // from the object 'Custom_Ticket' and returns and outputs the accumulated value.
        //System.out.println("Total Price: £" + Custom_Ticket.getCost());
        //System.out.println("\n");
    }
}