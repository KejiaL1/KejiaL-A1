// File: AssignmentOne.java

import java.util.ArrayList;

// Base class for health professionals
class HealthProfessional {
    protected int id;
    protected String name;
    protected String specialty;

    // Constructor with all parameters
    public HealthProfessional(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    // Method to print all instance variables
    public void printDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Specialty: " + specialty);
    }

    public String getName() {
        return name;
    }
}

// Child class representing a General Practitioner
class GeneralPractitioner extends HealthProfessional {

    public GeneralPractitioner(int id, String name, String specialty) {
        super(id, name, specialty);
    }

    @Override
    public void printDetails() {
        System.out.println("The health professional details are:");
        System.out.println("Type: General Practitioner");
        super.printDetails();
    }
}

// Child class representing a Specialist
class Specialist extends HealthProfessional {
    private final String field;

    public Specialist(int id, String name, String specialty, String field) {
        super(id, name, specialty);
        this.field = field;
    }

    @Override
    public void printDetails() {
        System.out.println("The health professional details are:");
        System.out.println("Type: Specialist");
        System.out.println("Field: " + field);
        super.printDetails();
    }
}

// Appointment class to accommodate appointment details
class Appointment {
    private final String patientName;
    private final String mobile;
    private final String timeSlot;
    private final HealthProfessional professional;

    // Constructor with all parameters
    public Appointment(String patientName, String mobile, String timeSlot, HealthProfessional professional) {
        this.patientName = patientName;
        this.mobile = mobile;
        this.timeSlot = timeSlot;
        this.professional = professional;
    }

    public String getMobile() {
        return mobile;
    }

    // Method to print all instance variables
    public void printDetails() {
        System.out.println("Patient: " + patientName + ", Mobile: " + mobile + ", Time Slot: " + timeSlot);
        System.out.print("Professional: ");
        professional.printDetails();
    }
}


public class AssignmentOne {
    public static void main(String[] args) {
        // Part 3 – Using classes and objects
        System.out.println("// Part 3 – Using classes and objects");

        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. Alice", "General Medicine");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Bob", "Family Health");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Carol", "Primary Care");

        Specialist specialist1 = new Specialist(4, "Dr. Dave", "Cardiology", "Cardiac Surgery");
        Specialist specialist2 = new Specialist(5, "Dr. Eve", "Dermatology", "Skin Care");

        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        specialist1.printDetails();
        specialist2.printDetails();

        System.out.println("------------------------------");

        // Part 5 – Collection of appointments
        System.out.println("// Part 5 – Collection of appointments");

        ArrayList<Appointment> appointments = new ArrayList<>();

        createAppointment(appointments, "Tony Stark", "1234567890", "08:00", gp1);
        createAppointment(appointments, "Steve Rogers", "2345678901", "10:00", gp2);
        createAppointment(appointments, "Bruce Banner", "3456789012", "14:00", specialist1);
        createAppointment(appointments, "Thor Odinson", "4567890123", "16:00", specialist2);

        System.out.println("Existing appointments:");
        printExistingAppointments(appointments);

        System.out.println("\nCancelling appointment for mobile 1234567890...");
        cancelBooking(appointments, "1234567890");

        System.out.println("\nUpdated appointments:");
        printExistingAppointments(appointments);

        System.out.println("------------------------------");
    }

    // Method to create a new appointment and add it to the list
    public static void createAppointment(ArrayList<Appointment> appointments, String patientName, String mobile, String timeSlot, HealthProfessional professional) {
        if (patientName != null && mobile != null && timeSlot != null && professional != null) {
            Appointment appointment = new Appointment(patientName, mobile, timeSlot, professional);
            appointments.add(appointment);
            System.out.println("Appointment created for " + patientName + " with " + professional.getName() + " at " + timeSlot);
        } else {
            System.out.println("All appointment details must be provided.");
        }
    }

    // Method to print all existing appointments
    public static void printExistingAppointments(ArrayList<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printDetails();
            }
        }
    }

    // Method to cancel an appointment based on mobile number
    public static void cancelBooking(ArrayList<Appointment> appointments, String mobile) {
        boolean found = false;
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getMobile().equals(mobile)) {
                appointments.remove(i);
                System.out.println("Appointment canceled for mobile: " + mobile);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No appointment found with mobile: " + mobile);
        }
    }
}
