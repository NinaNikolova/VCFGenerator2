import java.io.*;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fullName = getInput(scanner, "Enter Full Name: ");
        String phoneNumber = getInput(scanner, "Enter Phone Number: ");
        String email = getInput(scanner, "Enter Email Address: ");
        String company = getInput(scanner, "Enter Company Name: ");
        String jobTitle = getInput(scanner, "Enter Job Title: ");
        String address = getInput(scanner, "Enter Address: ");
        String website = getInput(scanner, "Enter Website: ");

        System.out.print("Enter Photo File Path (JPG or PNG): ");
        String photoPath = scanner.nextLine();

        String base64Photo = encodeImageToBase64(photoPath);

        String vcfContent = "BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "FN:" + fullName + "\n" +
                "ORG:" + company + "\n" +
                "TITLE:" + jobTitle + "\n" +
                "ADR:" + address + "\n" +
                "TEL;TYPE=CELL:" + phoneNumber + "\n" +
                "EMAIL:" + email + "\n" +
                "URL:" + website + "\n" +
                (base64Photo != null ? "PHOTO;ENCODING=b;TYPE=JPEG:" + base64Photo + "\n" : "") +
                "END:VCARD\n";

        String fileName = "business_card.vcf";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(vcfContent);
            System.out.println("Business card saved as " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        scanner.close();
    }

    private static String getInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("This field cannot be empty. Please enter a valid value.");
            }
        } while (input.isEmpty());
        return input;
    }

    private static String encodeImageToBase64(String imagePath) {
        try {
            File imageFile = new File(imagePath);
            byte[] fileContent = Files.readAllBytes(imageFile.toPath());
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            System.out.println("Error reading image file: " + e.getMessage());
            return null;
        }
    }
}
