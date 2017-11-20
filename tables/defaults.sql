INSERT INTO Address VALUES ("-", "-", "-", "-", "-");
INSERT INTO Patient
VALUES (0, "Mx", "Blank", "Patient", DATE "2000-01-01", "00000000000", "-", "-");

INSERT INTO Partner VALUES (0, "dentist");
INSERT INTO Partner VALUES (1, "hygienist");

INSERT INTO HealthCarePlan VALUES ("NHS Free Plan", 0, 2, 2, 6);
INSERT INTO HealthCarePlan VALUES ("Maintenance Plan", 15, 2, 2, 0);
INSERT INTO HealthCarePlan VALUES ("Oral Health Plane", 21, 2, 4, 0);
INSERT INTO HealthCarePlan VALUES ("Dental Repair Plan", 36, 2, 2, 2);

INSERT INTO Treatment VALUES ("Hygiene", "hygiene", 45);
INSERT INTO Treatment VALUES ("Check Up", "checkup", 45);
INSERT INTO Treatment VALUES ("Silver Amalgam Filling", "repair", 90);
INSERT INTO Treatment VALUES ("White Composite Resin Filling", "repair", 150);
INSERT INTO Treatment VALUES ("Gold Crown Fitting", "repair", 500);

#Example appointments
INSERT INTO Appointment VALUES (DATE "2017-12-25", "12:00:00", 0, 0);

INSERT INTO Record VALUES ("Check UP", "12:00:00", DATE "2017-12-25", 0);