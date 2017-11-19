#Get a Patient by their ID
SELECT title, forename, surname, dateOfBirth, phone FROM Patient WHERE patientID = ?;

#Get a Patient's Address using their ID
SELECT Address.houseNumber, street, district, city, Address.postCode FROM Address
JOIN Patient
ON Address.houseNumber = Patient.houseNumber
AND Address.postCode = Patient.postCode
WHERE patientID = ?;

#Get a Partner by their ID
SELECT forname, surname FROM Partner WHERE partnerID = ?;

#Get a Healthcare Plan by its name
SELECT * FROM HealthCarePlan WHERE planName = ?;

#Get a Treatment by its name
SELECT * FROM Treatment WHERE name = ?;

#Get a Subscription by the Patient's ID
SELECT Subscription.planName, monthlyPayment, startDate, endDate, checkUpLeft, hygieneVisitLeft, repairWorkLeft FROM Subscription
JOIN Patient ON Subscription.patientID = Patient.patientID
JOIN HealthCarePlan ON Subscription.planName = HealthCarePlan.planName
WHERE Subscription.patientID = ?;

#Get appointment details for a date, time and partner
SELECT date, startTime, Patient.patientID, Patient.title, Patient.forename, Patient.surname, Partner.partnerID, Partner.forename, Partner.surname FROM Appointment
JOIN Patient ON Appointment.patientID = Patient.patientID
JOIN Partner ON Appointment.partnerID = Partner.partnerID
WHERE date = ? 
AND startTime = ? 
AND Appointment.partnerID = ?;

#Get all appointments for a particular patient
SELECT date, startTime, Patient.patientID, Patient.title, Patient.forename, Patient.surname, Partner.partnerID, Partner.forename, Partner.surname FROM Appointment
JOIN Patient ON Appointment.patientID = Patient.patientID
JOIN Partner ON Appointment.partnerID = Partner.partnerID
WHERE Appointment.patientID = ?;

#Get all appointments for a particular partner
SELECT date, startTime, Patient.patientID, Patient.title, Patient.forename, Patient.surname, Partner.partnerID, Partner.forename, Partner.surname FROM Appointment
JOIN Patient ON Appointment.patientID = Patient.patientID
JOIN Partner ON Appointment.partnerID = Partner.partnerID
WHERE Appointment.partnerID = ?;

#Get all the treatments done at a particular appointment
SELECT treatmentGiven FROM Record
WHERE Record.date = ?
AND Record.startTime = ?
AND Record.partnerID = ?;