# Java Business Card Generator

## Description

This Java program allows users to generate a virtual business card in the VCF (vCard) format. It collects personal and professional details such as name, phone number, email, company, job title, address, website, and a photo, and then saves the information in a `.vcf` file.

### Features:
- Collects user's name, contact information, company details, and website.
- Allows the user to upload a photo (in JPG or PNG format) that will be embedded into the vCard as a Base64-encoded image.
- Generates a `.vcf` file containing all the entered information in the vCard format.
  
## How to Use

1. **Run the Program**:
   - Execute the `Main` class in a Java-supported IDE or terminal.
   
2. **Enter Personal and Professional Information**:
   - The program will prompt you to enter the following details:
     - Full Name
     - Phone Number
     - Email Address
     - Company Name
     - Job Title
     - Address
     - Website URL
   
3. **Upload a Photo**:
   - You will be prompted to provide the file path to a photo (JPG or PNG format).
   
4. **Save the Business Card**:
   - Once all information is entered, the program will generate a `business_card.vcf` file that contains all the details entered in the vCard format.

5. **Output**:
   - The `business_card.vcf` file will be saved in the same directory as the program.
   
## Code Explanation

1. **User Input Collection**: 
   - The program uses a `Scanner` object to gather input from the user for name, phone number, email, company, job title, address, and website.
   - A helper method `getInput()` ensures that the user cannot submit empty values.

2. **Photo Encoding**: 
   - The program requests a file path for a photo and encodes it into Base64 format using the `encodeImageToBase64()` method.

3. **vCard Creation**: 
   - The program constructs a vCard string using the provided data. If a photo is provided, it is included in the vCard as Base64-encoded content.

4. **File Writing**: 
   - The program writes the generated vCard content to a file called `business_card.vcf`.

5. **Error Handling**: 
   - If there are issues with file reading or writing, error messages will be displayed in the console.

## Requirements

- Java 8 or higher.
- A valid photo in JPG or PNG format (if you wish to include a photo in the vCard).

## Example Output (VCF File Content)

```vcard
BEGIN:VCARD
VERSION:3.0
FN:John Doe
ORG:ABC Corp
TITLE:Software Engineer
ADR:1234 Main Street, City, Country
TEL;TYPE=CELL:+1234567890
EMAIL:johndoe@example.com
URL:http://johndoe.com
PHOTO;ENCODING=b;TYPE=JPEG:BASE64_ENCODED_PHOTO_HERE
END:VCARD
