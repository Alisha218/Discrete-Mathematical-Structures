import java.util.*;

class Main {

    private static void medicalDiagnosis(Scanner scanner) {

        System.out.println("\n--- Medical Diagnosis ---");
        System.out.println("Enter symptoms separated by commas (e.g., fever, rash, headache, cough):");
        String symptomsInput = scanner.nextLine().toLowerCase();


        // Manually split the symptomsInput into an array
        String[] symptoms = new String[100]; // Assume max 100 symptoms for simplicity
        int symptomCount = 0;
        String currentSymptom = "";

        for (int i = 0; i < symptomsInput.length(); i++) {
            char currentChar = symptomsInput.charAt(i);

            if (currentChar == ',') {
                // Add the completed symptom to the array and reset currentSymptom
                symptoms[symptomCount] = currentSymptom.trim();
                symptomCount++;
                currentSymptom = "";
            } else {
                currentSymptom += currentChar;
            }
        }

        // Add the last symptom (if any) to the array
        if (!currentSymptom.isEmpty()) {
            symptoms[symptomCount] = currentSymptom.trim();
            symptomCount++;
        }

        // Initialize flags for each symptom
        boolean hasFever = false;
        boolean hasRash = false;
        boolean hasHeadache = false;
        boolean hasCough = false;
        boolean hasSoreThroat = false;
        boolean hasFatigue = false;
        boolean hasSneezing = false;

        // Iterate through symptoms to set flags
        for (int i = 0; i < symptomCount; i++) {
            String symptom = symptoms[i];
            if (symptom.equals("fever")) hasFever = true;
            if (symptom.equals("rash")) hasRash = true;
            if (symptom.equals("headache")) hasHeadache = true;
            if (symptom.equals("cough")) hasCough = true;
            if (symptom.equals("sore throat")) hasSoreThroat = true;
            if (symptom.equals("fatigue")) hasFatigue = true;
            if (symptom.equals("sneezing")) hasSneezing = true;
        }

        // OR Gate Logic for Diagnosis
        if (hasFever && hasCough && hasSoreThroat) {
            System.out.println("Diagnosis: Flu");
        } else if (hasRash && hasFever) {
            System.out.println("Diagnosis: Measles");
        } else if (hasRash || hasSneezing) { // OR gate for allergy conditions
            System.out.println("Diagnosis: Allergy");
        } else if (hasHeadache && hasFatigue) {
            System.out.println("Diagnosis: Migraine");
        } else if (hasSneezing && (hasCough || hasFever)) { // OR gate for cold with sneezing
            System.out.println("Diagnosis: Common Cold");
        } else if (!hasFever && !hasRash && !hasHeadache && !hasCough) {
            System.out.println("Diagnosis: Not a clear symptom");
        } else {
            System.out.println("Diagnosis: single symptoms cannot be judged. Please consult a doctor.");
        }
    }

    private static void mealPlanning(Scanner scanner) {

        System.out.println("\n--- Meal Planning---");
        System.out.println("Are you vegetarian? (yes/no):");
        String vegetarian = scanner.nextLine().toLowerCase();

        System.out.println("Do you have any dietary restrictions? (e.g., gluten-free, vegan, keto, none):");
        String dietaryRestriction = scanner.nextLine().toLowerCase();

        System.out.println("Do you prefer spicy food? (yes/no):");
        String spicyPreference = scanner.nextLine().toLowerCase();

        System.out.println("Do you have any health conditions? (e.g., diabetes, high blood pressure, none):");
        String healthCondition = scanner.nextLine().toLowerCase();

        if (vegetarian.equals("yes")) {
            if (dietaryRestriction.equals("vegan")) {
                if (spicyPreference.equals("yes")) {
                    System.out.println("Recommended Meal: Spicy Tofu Stir-fry");
                } else {
                    System.out.println("Recommended Meal: Vegan Buddha Bowl");
                }
            } else if (dietaryRestriction.equals("gluten-free")) {
                System.out.println("Recommended Meal: Gluten-Free Vegetable Pasta");
            } else {
                System.out.println("Recommended Meal: Vegetable Stir-fry");
            }
        } else { // Non-vegetarian options
            if (dietaryRestriction.equals("keto")) {
                System.out.println("Recommended Meal: Grilled Salmon with Avocado Salad");
            } else if (healthCondition.equals("diabetes")) {
                System.out.println("Recommended Meal: Grilled Chicken with Steamed Vegetables");
            } else if (healthCondition.equals("high blood pressure")) {
                System.out.println("Recommended Meal: Baked Fish with Quinoa and Spinach");
            } else {
                if (spicyPreference.equals("yes")) {
                    System.out.println("Recommended Meal: Spicy Grilled Chicken with Rice");
                } else {
                    System.out.println("Recommended Meal: Grilled Chicken with Rice");
                }
            }
        }
    }


    private static void homeRenovation(Scanner scanner) {

        System.out.println("\n--- Home Renovations ---");
        // Take the item name
        System.out.println("Enter the name of the item:");
        String itemName = scanner.nextLine();

        // Take the condition of the item
        System.out.println("Enter the condition of the item (good/average/bad):");
        String condition = scanner.nextLine().toLowerCase();

        // Take the usage level of the appliance
        System.out.println("Enter the usage of the appliance (low/mild/high):");
        String usage = scanner.nextLine().toLowerCase();

        // Ask if there is an alternate appliance
        System.out.println("Is there an alternate appliance to use? (yes/no):");
        String alternate = scanner.nextLine().toLowerCase();

        // Use valid arguments for decision making
        boolean hasAlternate = alternate.equals("yes");
        boolean isLowUsage = usage.equals("low");
        boolean isMildUsage = usage.equals("mild");
        boolean isHighUsage = usage.equals("high");

        // Decision logic
        if (!hasAlternate) {
            if (isLowUsage) {
                System.out.println("Decision: Keep the item on hold.");
            } else if (isMildUsage) {
                System.out.println("Decision: Consider repair depending on costs.");
            } else if (isHighUsage) {
                System.out.println("Decision: Replace the item.");
            }
        } else {
            if (condition.equals("good")) {
                System.out.println("Decision: Keep the item.");
            } else {
                // The appliance condition still plays a role when no alternate appliance is available
                if (condition.equals("average")) {
                    System.out.println("Decision: Consider repair.");
                } else if (condition.equals("bad")&&isHighUsage) {
                    System.out.println("Decision: Replace the item.");
                } else {
                    System.out.println("Invalid input.");
                }
            }
        }
    }


    // Main method to run the family relations
    public static void familyRelations(Scanner scanner) {
        // Immediate family set (father, mother, grandfather, grandmother)
        String[] immediateFamily = {"Father", "Mother", "Grandfather", "Grandmother"};
        String[] immediateFamilyDescriptions = {
                "Your dad",
                "Your mom",
                "Your dad's father",
                "Your mom's mother"
        };

        // Extended family set (uncle, aunt, cousin)
        String[] extendedFamily = {"Uncle", "Aunt", "Cousin"};
        String[] extendedFamilyDescriptions = {
                "Your dad's brother",
                "Your mom's sister",
                "Your uncle's or aunt's child"
        };

        while (true) {
            System.out.println("\n--- Family Relations ---");
            System.out.println("1. View Relationship");
            System.out.print("Enter your choice: ");
            int choice = validateIntegerInput(scanner);
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter family relation (e.g., Father, Cousin): ");
                    String relation = scanner.nextLine();
                    if (isImmediateFamily(relation, immediateFamily)) {
                        System.out.println("Immediate Family Relation: " + getRelationDescription(relation, immediateFamily, immediateFamilyDescriptions));
                    } else if (isExtendedFamily(relation, extendedFamily)) {
                        System.out.println("Extended Family Relation: " + getRelationDescription(relation, extendedFamily, extendedFamilyDescriptions));
                    } else {
                        System.out.println("Invalid relation. Please try again.");
                    }
                    break;

                case 2:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to check if the relation is in the immediate family set
    private static boolean isImmediateFamily(String relation, String[] immediateFamily) {
        for (String familyMember : immediateFamily) {
            if (familyMember.equalsIgnoreCase(relation)) {
                return true;
            }
        }
        return false; // Relation not found
    }

    // Method to check if the relation is in the extended family set
    private static boolean isExtendedFamily(String relation, String[] extendedFamily) {
        for (String familyMember : extendedFamily) {
            if (familyMember.equalsIgnoreCase(relation)) {
                return true;
            }
        }
        return false; // Relation not found
    }

    // Method to get the description of a relation based on its set
    private static String getRelationDescription(String relation, String[] familyMembers, String[] descriptions) {
        for (int i = 0; i < familyMembers.length; i++) {
            if (familyMembers[i].equalsIgnoreCase(relation)) {
                return descriptions[i];
            }
        }
        return "Unknown relation"; // Should not reach here if relation exists
    }

    // Helper method to validate integer input
    private static int validateIntegerInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();  // Consume the invalid input
        }
        return scanner.nextInt();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Day-to-Day Decision-Making System!");
            System.out.println("1. Medical Diagnosis");
            System.out.println("2. Meal Planning");
            System.out.println("3. Home Renovation");
            System.out.println("4. Family Relations");
            System.out.println("5. Exit");

            int choice = validateIntegerInput(scanner);
            scanner.nextLine();
            switch (choice) {
                case 1:
                    medicalDiagnosis(scanner);
                    break;
                case 2:
                    mealPlanning(scanner);
                    break;
                case 3:
                    homeRenovation(scanner);

                    break;
                case 4:
                    familyRelations(scanner);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

