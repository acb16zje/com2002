# Address for default blank patient
INSERT INTO Address VALUES ("-", "-", "-", "-", "-");

# Default blank patient
INSERT INTO Patient VALUES (0, "Mx", "Blank", "Patient", DATE "2000-01-01", "00000000000", "-", "-");

# Dentist and hygienist
INSERT INTO Partner VALUES (0);
INSERT INTO Partner VALUES (1);

# Default healthcare plan
INSERT INTO HealthCarePlan VALUES ("NHS Free Plan", 0, 2, 2, 6);
INSERT INTO HealthCarePlan VALUES ("Maintenance Plan", 15, 2, 2, 0);
INSERT INTO HealthCarePlan VALUES ("Oral Health Plan", 21, 2, 4, 0);
INSERT INTO HealthCarePlan VALUES ("Dental Repair Plan", 36, 2, 2, 2);

# Example appointments
INSERT INTO Appointment VALUES (DATE "2017-12-25", "12:00:00", "13:00:00", 0, 0);

# Default treatment
INSERT INTO Treatment VALUES ("Hygiene", 45);
INSERT INTO Treatment VALUES ("Check Up", 45);
INSERT INTO Treatment VALUES ("Silver Amalgam Filling", 90);
INSERT INTO Treatment VALUES ("White Composite Resin Filling", 150);
INSERT INTO Treatment VALUES ("Gold Crown Fitting", 500);
