public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        DiscountApprover supervisor = new Supervisor();
        DiscountApprover manager = new Manager();
        DiscountApprover director = new Director();

        supervisor.setNextApprover(manager);
        manager.setNextApprover(director);

        supervisor.handleDiscountRequest(405, "Order 1");

    }
}

abstract class DiscountApprover {
    DiscountApprover nextApprover;

    public void setNextApprover(DiscountApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void handleDiscountRequest(double discount, String request);
}

class Supervisor extends DiscountApprover {
    @Override
    public void handleDiscountRequest(double discount, String request) {
        if (discount <= 50) {
            System.out.println("Supervisor approved discount request: " + request);
        } else if (nextApprover != null) {
            nextApprover.handleDiscountRequest(discount, request);
        } else {
            System.out.println("Discount request exceeds supervisor limit: " + request);
        }
    }
}

class Manager extends DiscountApprover {
    @Override
    public void handleDiscountRequest(double discount, String request) {
        if (discount <= 100) {
            System.out.println("Manager approved discount request: " + request);
        } else if (nextApprover != null) {
            nextApprover.handleDiscountRequest(discount, request);
        } else {
            System.out.println("Discount request exceeds manager limit: " + request);
        }
    }
}

class Director extends DiscountApprover {
    @Override
    public void handleDiscountRequest(double discount, String request) {
        System.out.println("Director approved discount request: " + request);
    }
}
