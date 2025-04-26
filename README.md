# Contact-Management-Web-App

📇 Contact Management Web App
A Spring Boot MVC web application that allows users to sign up, log in, and manage their contacts securely and efficiently.

🚀 Technologies Used
Java 17

Spring Boot 3

Spring Web MVC

Spring Data JPA (Hibernate)

H2 / MySQL Database

Thymeleaf (Server-side Templating)

Maven

Git & GitHub

📂 Project Structure
css
Copy
Edit
src/main/java/in/ashokit/
    ├── controller/
    │     ├── UserController.java
    │     └── ContactController.java
    ├── entity/
    │     ├── User.java
    │     └── Contact.java
    ├── repo/
    │     ├── UserRepository.java
    │     └── ContactRepository.java
    ├── service/
    │     ├── UserService.java
    │     └── ContactService.java
src/main/resources/templates/
    ├── signup.html
    ├── login.html
    ├── addContact.html
    ├── contacts.html
🎯 Features
✅ User Registration (Sign Up)

✅ User Authentication (Login)

✅ Add New Contacts

✅ View All Saved Contacts

✅ Session Management

✅ Form Validation

✅ Responsive and Clean UI (Thymeleaf)

⚙️ How to Run Locally
Clone the repository:

bash
Copy
Edit
git clone https://github.com/Eshwar-B/Contact-Management-Web-App.git
Navigate to the project directory:

bash
Copy
Edit
cd Contact-Management-Web-App
Install dependencies:

bash
Copy
Edit
mvn clean install
Run the application:

bash
Copy
Edit
mvn spring-boot:run
Access the application:

bash
Copy
Edit
http://localhost:8080/signup
📜 Important Code Snippets and Explanation
1. User Registration (Signup Process)
java
Copy
Edit
@PostMapping("/signup")
public String processSignUp(@ModelAttribute User user) {
    userService.registerUser(user);
    return "redirect:/login";
}
Explanation:
When a user fills the signup form and submits it, this method saves the new User into the database and redirects to the login page.

2. User Authentication (Login Process)
java
Copy
Edit
@PostMapping("/login")
public String processLogin(@ModelAttribute User user, Model model, HttpSession session) {
    User existingUser = userService.findByEmail(user.getEmail());
    if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
        session.setAttribute("user", existingUser);
        return "redirect:/contacts";
    } else {
        model.addAttribute("error", "Invalid Credentials");
        return "login";
    }
}
Explanation:

Fetches user based on email.

Validates password.

If valid, saves user info in session and redirects to the contacts page.

If invalid, shows an error message on the login page.

3. Displaying All Contacts for a User
java
Copy
Edit
@GetMapping("/contacts")
public String showContactsPage(Model model, HttpSession session) {
    User user = (User) session.getAttribute("user");
    if (user != null) {
        model.addAttribute("contacts", contactService.getContactForUser(user));
    }
    return "contacts";
}
Explanation:

Retrieves the logged-in user's contacts from the database.

Passes the contacts list to the contacts.html page for display.

4. Adding a New Contact
java
Copy
Edit
@PostMapping("/addContact")
public String addContact(@ModelAttribute Contact contact, HttpSession session) {
    User user = (User) session.getAttribute("user");
    if (user != null) {
        contact.setUser(user);
        contactService.addContact(contact);
    }
    return "redirect:/contacts";
}
Explanation:

Captures the new contact details from the form.

Links the contact to the logged-in user.

Saves it to the database.

Redirects back to the contacts list page.

👨‍💻 Developer Profile
Name: Eshwar B

GitHub: Eshwar-B


📜 License
This project is licensed under the MIT License.
You are free to use, modify, and distribute this project with attribution.

Link to License: MIT License

🌟 Give it a ⭐ if you like it!
