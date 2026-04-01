package main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import exception.ClinicException;
import manager.*;
import model.*;

public class HealthClinicApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PatientManager patientManager = new PatientManager();
        DoctorManager doctorManager = new DoctorManager();
        AppointmentManager appointmentManager = new AppointmentManager();
        VisitManager visitManager = new VisitManager();
        BillingManager billingManager = new BillingManager();
        AccessManager accessManager = new AccessManager();

        boolean exit = false;

        while (!exit) {
            System.out.println("""
            ==============================
            HEALTH CLINIC MANAGEMENT SYSTEM
            ==============================
            1. Patient Management
            2. Doctor Management
            3. Appointment Scheduling
            4. Visit & Medical Records
            5. Billing & Payments
            6. System Administration
            0. Exit
            ==============================
            """);

            int mainChoice = sc.nextInt();
            sc.nextLine();

            try {

                switch (mainChoice) {

                    /* ================= PATIENT MANAGEMENT ================= */
                    case 1 -> {
                        System.out.println("""
                        1. Register Patient
                        2. Update Patient
                        3. Search Patient (ID / Phone)
                        4. View Patient History
                        """);

                        int ch = sc.nextInt();
                        sc.nextLine();

                        switch (ch) {
                            case 1 -> {
                                Patient p = new Patient();
                                System.out.print("Name: ");
                                p.setPatientName(sc.nextLine());
                                System.out.print("DOB (yyyy-mm-dd): ");
                                p.setPatientDOB(LocalDate.parse(sc.nextLine()));
                                System.out.print("Contact: ");
                                p.setPatientContact(sc.nextLine());
                                System.out.print("Email: ");
                                p.setEmail(sc.nextLine());
                                System.out.print("Address: ");
                                p.setPatientAddress(sc.nextLine());
                                System.out.print("Blood Group: ");
                                p.setPatientBloodGroup(sc.nextLine());

                                int id = patientManager.registerPatient(p);
                                System.out.println("Patient registered with ID: " + id);
                            }

                            case 2 -> {
                                Patient p = new Patient();
                                System.out.print("Patient ID: ");
                                p.setPatientId(sc.nextInt());
                                sc.nextLine();
                                System.out.print("Name: ");
                                p.setPatientName(sc.nextLine());
                                System.out.print("DOB (yyyy-mm-dd): ");
                                p.setPatientDOB(LocalDate.parse(sc.nextLine()));
                                System.out.print("Contact: ");
                                p.setPatientContact(sc.nextLine());
                                System.out.print("Email: ");
                                p.setEmail(sc.nextLine());
                                System.out.print("Address: ");
                                p.setPatientAddress(sc.nextLine());
                                System.out.print("Blood Group: ");
                                p.setPatientBloodGroup(sc.nextLine());

                                patientManager.updatePatient(p);
                                System.out.println("Patient updated.");
                            }

                            case 3 -> {
                                System.out.print("Enter ID or Phone: ");
                                patientManager.searchPatientByIdOrPhone(sc.nextLine());
                            }

                            case 4 -> {
                                System.out.print("Patient ID: ");
                                patientManager.viewPatientHistory(sc.nextInt());
                            }
                        }
                    }

                    /* ================= DOCTOR MANAGEMENT ================= */
                    case 2 -> {
                        System.out.println("""
                        1. Add Doctor
                        2. Deactivate Doctor
                        """);

                        int ch = sc.nextInt();

                        switch (ch) {
                            case 1 -> {
                                Doctor d = new Doctor();
                                sc.nextLine();
                                System.out.print("Doctor Name: ");
                                d.setDoctorName(sc.nextLine());
                                System.out.print("Specialty ID: ");
                                d.setSpecialityId(sc.nextInt());
                                sc.nextLine();
                                System.out.print("Contact: ");
                                d.setDoctorContact(sc.nextLine());
                                System.out.print("Fee: ");
                                d.setFee(sc.nextDouble());

                                int id = doctorManager.addDoctor(d);
                                System.out.println("Doctor added with ID: " + id);
                            }

                            case 2 -> {
                                System.out.print("Doctor ID: ");
                                doctorManager.deactivateDoctor(sc.nextInt());
                                System.out.println("Doctor deactivated.");
                            }
                        }
                    }

                    /* ================= APPOINTMENTS ================= */
                    case 3 -> {
                        System.out.println("""
                        1. Book Appointment
                        2. Cancel Appointment
                        3. View Daily Schedule
                        """);

                        int ch = sc.nextInt();

                        switch (ch) {
                            case 1 -> {
                                Appointment a = new Appointment();
                                System.out.print("Patient ID: ");
                                a.setPatientID(sc.nextInt());
                                System.out.print("Doctor ID: ");
                                a.setDoctorID(sc.nextInt());
                                sc.nextLine();
                                System.out.print("Date (yyyy-mm-dd): ");
                                a.setAppointmentDate(LocalDate.parse(sc.nextLine()));

                                appointmentManager.bookAppointment(a);
                                System.out.println("Appointment booked.");
                            }

                            case 2 -> {
                                System.out.print("Appointment ID: ");
                                appointmentManager.cancelAppointment(sc.nextInt());
                                System.out.println("Appointment cancelled.");
                            }

                            case 3 -> {
                                System.out.print("Date (yyyy-mm-dd): ");
                                appointmentManager.viewAppointmentSchedule(
                                        Date.valueOf(sc.next()));
                            }
                        }
                    }

                    /* ================= VISITS ================= */
                    case 4 -> {
                        System.out.println("""
                        1. Record Visit
                        2. View Patient Medical History
                        """);

                        int ch = sc.nextInt();
                        sc.nextLine();

                        if (ch == 1) {
                            Visit v = new Visit();
                            System.out.print("Appointment ID: ");
                            v.setAppointmentId(sc.nextInt());
                            sc.nextLine();
                            System.out.print("Visit Date (yyyy-mm-dd): ");
                            v.setVisitDate(LocalDate.parse(sc.nextLine()));
                            System.out.print("Diagnosis: ");
                            v.setDiagnosis(sc.nextLine());
                            System.out.print("Notes: ");
                            v.setNotes(sc.nextLine());

                            visitManager.recordVisit(v);
                            System.out.println("Visit recorded.");
                        }

                        if (ch == 2) {
                            System.out.print("Patient ID: ");
                            visitManager.viewPatientHistory(sc.nextInt());
                        }
                    }

                    /* ================= BILLING ================= */
                    case 5 -> {
                        System.out.println("""
                        1. View Outstanding Bills
                        2. Record Payment
                        3. Revenue Report
                        """);

                        int ch = sc.nextInt();

                        if (ch == 1) {
                            billingManager.viewOutstandingBills();
                        }

                        if (ch == 2) {
                            System.out.print("Bill ID: ");
                            int billId = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Payment Mode: ");
                            billingManager.recordPayment(billId, sc.nextLine());
                            System.out.println("Payment recorded.");
                        }

                        if (ch == 3) {
                            System.out.print("From Date (yyyy-mm-dd): ");
                            Date from = Date.valueOf(sc.next());
                            System.out.print("To Date (yyyy-mm-dd): ");
                            Date to = Date.valueOf(sc.next());
                            billingManager.generateRevenueReport(from, to);
                        }
                    }

                    /* ================= SYSTEM ADMIN ================= */
                    case 6 -> {
                        System.out.println("""
                        1. Add Specialty
                        2. Update Specialty
                        3. Delete Specialty
                        4. Backup Database
                        5. View Audit Logs
                        """);

                        int ch = sc.nextInt();
                        sc.nextLine();

                        switch (ch) {
                            case 1 -> {
                                Specialty s = new Specialty();
                                System.out.print("Specialty Name: ");
                                s.setSpecialtyName(sc.nextLine());
                                System.out.print("Description: ");
                                s.setDescription(sc.nextLine());
                                accessManager.addSpecialty(s);
                                System.out.println("Specialty added.");
                            }

                            case 2 -> {
                                Specialty s = new Specialty();
                                System.out.print("Specialty ID: ");
                                s.setSpecialtyId(sc.nextInt());
                                sc.nextLine();
                                System.out.print("New Name: ");
                                s.setSpecialtyName(sc.nextLine());
                                System.out.print("Description: ");
                                s.setDescription(sc.nextLine());
                                accessManager.updateSpecialty(s);
                                System.out.println("Specialty updated.");
                            }

                            case 3 -> {
                                System.out.print("Specialty ID: ");
                                accessManager.deleteSpecialty(sc.nextInt());
                                System.out.println("Specialty deleted.");
                            }

                            case 4 -> accessManager.backupDatabase();

                            case 5 -> {
                                System.out.print("User filter: ");
                                String user = sc.nextLine();
                                System.out.print("Table filter: ");
                                String table = sc.nextLine();
                                accessManager.viewAuditLogs(user, table);
                            }
                        }
                    }

                    case 0 -> {
                        exit = true;
                        System.out.println("Exiting system...");
                    }
                }

            } catch (ClinicException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        sc.close();
    }
}