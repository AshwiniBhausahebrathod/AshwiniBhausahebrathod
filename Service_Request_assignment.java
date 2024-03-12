import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class ServiceRequest {
    private String customerName;
    private String requestType;
    private String details;
    private String attachment;
    private Date submittedAt;
    private Date resolvedAt;
    private String status;

    // Constructors
    public ServiceRequest(String customerName, String requestType, String details, String attachment) {
        this.customerName = customerName;
        this.requestType = requestType;
        this.details = details;
        this.attachment = attachment;
        this.submittedAt = new Date();
        this.status = "Pending";
    }

    // Empty constructor for convenience
    public ServiceRequest() {
    }

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Date getSubmittedAt() {
        return submittedAt;
    }

    public Date getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(Date resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Additional methods for request tracking
    public void markAsResolved() {
        this.status = "Resolved";
        this.resolvedAt = new Date();
    }

    public void displayRequestInfo() {
        System.out.println("Customer: " + customerName);
        System.out.println("Request Type: " + requestType);
        System.out.println("Details: " + details);
        System.out.println("Attachment: " + attachment);
        System.out.println("Submitted At: " + submittedAt);
        System.out.println("Status: " + status);
        if (status.equals("Resolved")) {
            System.out.println("Resolved At: " + resolvedAt);
        }
    }
}

class CustomerAccount {
    private String customerName;
    private String email;
    private String phoneNumber;
    private String address;
    // Add other customer-related fields

    // Constructors
    public CustomerAccount(String customerName, String email, String phoneNumber, String address) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        // Initialize other fields as needed
    }

    // Empty constructor for convenience
    public CustomerAccount() {
    }

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Add getters and setters for other fields

    // Additional methods can be added as needed
}

class ServiceRequestForm {
    private String customerName;
    private String requestType;
    private String details;
    private String attachment;

    // Constructors
    public ServiceRequestForm(String customerName, String requestType, String details, String attachment) {
        this.customerName = customerName;
        this.requestType = requestType;
        this.details = details;
        this.attachment = attachment;
    }

    // Empty constructor for convenience
    public ServiceRequestForm() {
    }

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    // Implement form handling logic
    public static ServiceRequestForm getFormDataFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter request type: ");
        String requestType = scanner.nextLine();

        System.out.print("Enter details: ");
        String details = scanner.nextLine();

        System.out.print("Enter attachment (if any): ");
        String attachment = scanner.nextLine();

        return new ServiceRequestForm(customerName, requestType, details, attachment);
    }
}

public class GasUtilityApp {
    private List<ServiceRequest> serviceRequests = new ArrayList<>();

    public void submitServiceRequest(ServiceRequestForm form) {
        ServiceRequest newRequest = new ServiceRequest(
                form.getCustomerName(),
                form.getRequestType(),
                form.getDetails(),
                form.getAttachment()
        );
        serviceRequests.add(newRequest);
        System.out.println("Service request submitted successfully!");
    }

    public void trackServiceRequestStatus(String customerName) {
        System.out.println("Service Requests for Customer: " + customerName);
        for (ServiceRequest request : serviceRequests) {
            if (request.getCustomerName().equals(customerName)) {
                System.out.println("Request Type: " + request.getRequestType());
                System.out.println("Status: " + request.getStatus());
                if (request.getStatus().equals("Resolved")) {
                    System.out.println("Resolved At: " + request.getResolvedAt());
                }
                System.out.println("-------------");
            }
        }
    }

    public static void main(String[] args) {
        GasUtilityApp gasUtilityApp = new GasUtilityApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Submit Service Request");
            System.out.println("2. Track Service Request Status");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    ServiceRequestForm form = ServiceRequestForm.getFormDataFromUser();
                    gasUtilityApp.submitServiceRequest(form);
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    gasUtilityApp.trackServiceRequestStatus(customerName);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
