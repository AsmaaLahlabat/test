package health.com;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionManagement {
    private static final List<SubscriptionPlan> plans = new ArrayList<>();

    static {
        resetPlans();
    }//

    public static List<SubscriptionPlan> getPlans() {
        return plans;
    }

    public static void addSubscriptionPlan(String name, int price) {
        boolean exists = plans.stream().anyMatch(plan -> plan.getName().equalsIgnoreCase(name));
        if (!exists) {
            plans.add(new SubscriptionPlan(name, price));
            System.out.println("Subscription plan added: " + name + " with price " + price);
        } else {
            System.out.println("Subscription plan already exists: " + name);
        }
    }

    public static boolean updateSubscriptionPlan(String name, int newPrice) {
        for (SubscriptionPlan plan : plans) {
            if (plan.getName().equalsIgnoreCase(name)) {
                plan.setPrice(newPrice);
                System.out.println("Subscription plan updated: " + name + " with new price " + newPrice);
                return true;
            }
        }
        System.out.println("Subscription plan not found: " + name);
        return false;
    }

    public static boolean deleteSubscriptionPlan(String name) {
        System.out.println("Attempting to delete plan: " + name);
        boolean isDeleted = plans.removeIf(plan -> plan.getName().equalsIgnoreCase(name));
        if (!isDeleted) {
            System.out.println("The plan does not exist: " + name);
        } else {
            System.out.println("Plan deleted successfully: " + name);
        }
        return isDeleted;
    }

    public static void listPlans() {
        if (plans.isEmpty()) {
            System.out.println("No subscription plans available.");
        } else {
            System.out.println("Available Subscription Plans:");
            for (SubscriptionPlan plan : plans) {
                System.out.println(plan);
            }
        }
    }

    public static void resetPlans() {
        plans.clear();
        plans.add(new SubscriptionPlan("Basic", 50));
        plans.add(new SubscriptionPlan("Premium", 100));
    }
}
