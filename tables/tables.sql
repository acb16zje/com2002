PRAGMA foreign_keys = 1;

CREATE TABLE Address (
	houseNumber VARCHAR (10) NOT NULL,
	postCode VARCHAR (7) NOT NULL,
	streetName VARCHAR (20) NOT NULL,
	districtName VARCHAR (20) NOT NULL,
	cityName VARCHAR (20) NOT NULL,
	PRIMARY KEY (houseNumber, postCode)
);

CREATE TABLE Patient (
	patientID INT NOT NULL,
	title VARCHAR (15) NOT NULL,
	forename VARCHAR (20) NOT NULL,
	familyName VARCHAR (30) NOT NULL,
	dateOfBirth DATE NOT NULL,
	phone VARCHAR (12) NOT NULL,
	houseNumber VARCHAR (10) NOT NULL,
	postCode VARCHAR (7) NOT NULL,
	PRIMARY KEY (patientID),
	FOREIGN KEY (houseNumber, postCode) REFERENCES Address(houseNumber, postCode)
);

CREATE TABLE HealthCarePlan (
	planName VARCHAR (30) NOT NULL,
	monthlyPayment INT NOT NULL,
	checkUp INT NOT NULL,
	hygieneVist INT NOT NULL,
	repairWork INT NOT NULL,
	PRIMARY KEY (planName)

);
	
CREATE TABLE Subscription (
	patientID INT NOT NULL,
	planName VARCHAR (30) NOT NULL,
	startDate DATE NOT NULL,
	endDate DATE NOT NULL,
	checkUpLeft INT DEFAULT 0,
	hygieneVisitLeft INT DEFAULT 0,
	repairWorkLeft INT DEFAULT 0,
	PRIMARY KEY (patientID, planName),
	FOREIGN KEY (patientID) REFERENCES Patient(PatientID),
	FOREIGN KEY (planName) REFERENCES HealthCarePlan(planName)
);

CREATE TABLE Partner (
	partnerID INT NOT NULL,
	forename VARCHAR (20) NULL,
	familyName VARCHAR (30) NOT NULL, 
	PRIMARY KEY (partnerID)
);

CREATE TABLE Appointment (
	date DATE NOT NULL,
	startTime TIME NOT NULL,
	patientID INT NOT NULL,
	partnerID INT NOT NULL,
	PRIMARY KEY (date, startTime, partnerID),
	FOREIGN KEY (partnerID) REFERENCES Partner(PartnerID),
	FOREIGN KEY (patientID) REFERENCES Patient(PatientID)
);

CREATE TABLE Treatment (
	name VARCHAR (30) NOT NULL,
	type VARCHAR (10) NOT NULL,
	cost INT NOT NULL,
	PRIMARY KEY (name)
);

CREATE TABLE Record (
	treatmentGiven VARCHAR (30) NOT NULL,
	startTime TIME NOT NULL,
	date DATE NOT NULL,
	partnerID INT NOT NULL,
	PRIMARY KEY (treatmentGiven, date, startTime, partnerID),
	FOREIGN KEY (date, startTime, partnerID) REFERENCES Appointment(date, startTime, partnerID),
	FOREIGN KEY (treatmentGiven) REFERENCES Treatment(name)

);
	