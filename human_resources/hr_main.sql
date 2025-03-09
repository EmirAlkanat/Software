-- HR Schema: Tablo oluşturma
CREATE TABLE Employees (
    Employee_ID NUMBER PRIMARY KEY,
    First_Name VARCHAR2(50),
    Last_Name VARCHAR2(50) NOT NULL,
    Email VARCHAR2(100) UNIQUE,
    Phone_Number VARCHAR2(20),
    Hire_Date DATE NOT NULL,
    Job_ID VARCHAR2(10) NOT NULL,
    Salary NUMBER(8,2),
    Commission_PCT NUMBER(2,2),
    Manager_ID NUMBER,
    Department_ID NUMBER
);

CREATE TABLE Departments (
    Department_ID NUMBER PRIMARY KEY,
    Department_Name VARCHAR2(50) NOT NULL,
    Manager_ID NUMBER,
    Location_ID NUMBER
);

CREATE TABLE Jobs (
    Job_ID VARCHAR2(10) PRIMARY KEY,
    Job_Title VARCHAR2(50) NOT NULL,
    Min_Salary NUMBER,
    Max_Salary NUMBER
);

CREATE TABLE Locations (
    Location_ID NUMBER PRIMARY KEY,
    Street_Address VARCHAR2(100),
    City VARCHAR2(50) NOT NULL,
    State_Province VARCHAR2(50),
    Country_ID VARCHAR2(2)
);

-- Foreign Key Bağlantıları
ALTER TABLE Employees ADD CONSTRAINT fk_dept FOREIGN KEY (Department_ID) REFERENCES Departments(Department_ID);
ALTER TABLE Employees ADD CONSTRAINT fk_job FOREIGN KEY (Job_ID) REFERENCES Jobs(Job_ID);
ALTER TABLE Departments ADD CONSTRAINT fk_manager FOREIGN KEY (Manager_ID) REFERENCES Employees(Employee_ID);

-- Örnek Veri Ekleme
INSERT INTO Jobs (Job_ID, Job_Title, Min_Salary, Max_Salary) VALUES ('IT_PROG', 'IT Programmer', 4000, 9000);
INSERT INTO Departments (Department_ID, Department_Name, Manager_ID, Location_ID) VALUES (10, 'IT', NULL, NULL);
INSERT INTO Employees (Employee_ID, First_Name, Last_Name, Email, Hire_Date, Job_ID, Salary, Department_ID) 
VALUES (100, 'Ali', 'Veli', 'ali.veli@example.com', TO_DATE('2024-02-27', 'YYYY-MM-DD'), 'IT_PROG', 5000, 10);
