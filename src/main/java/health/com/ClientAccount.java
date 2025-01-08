package health.com;

public class ClientAccount {
    private String name;
    private int age;
    private String fitnessGoal;
    private String dietaryPreferences;

    // إنشاء الملف الشخصي//
    //oo
    public String createProfile(String name, int age, String fitnessGoal, String dietaryPreferences) {
        if (name == null || name.isEmpty() || fitnessGoal.isEmpty() || dietaryPreferences.isEmpty()) {
            return "Error: Missing required fields."; // تحقق من الحقول المفقودة
        }
        if (age <= 0 || age > 120) {
            return "Error: Invalid age input."; // تحقق العمر
        }
        this.name = name;
        this.age = age;
        this.fitnessGoal = fitnessGoal;
        this.dietaryPreferences = dietaryPreferences;
        return "Profile created successfully";
    }

    // تحديث تفضيلات الغذاء
    public String updateDietaryPreferences(String newPreferences) {
        if (newPreferences == null || newPreferences.isEmpty()) {
            return "Error: Missing dietary preferences.";
        }
        this.dietaryPreferences = newPreferences;
        return "Profile updated successfully";
    }

    // عرض الملف الشخصي
    public String viewProfile() {
        return String.format("Name: %s, Age: %d, Goal: %s, Preferences: %s", name, age, fitnessGoal, dietaryPreferences);
    }
}
