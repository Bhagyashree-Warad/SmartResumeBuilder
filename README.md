# Smart Resume Builder

## Overview
Smart Resume Builder is a full-stack web app to create, customize, and download professional resumes.  
Frontend: React + Tailwind CSS | Backend: Spring Boot + MySQL

## Tech Stack
- **Frontend:** React, Tailwind CSS, React Router DOM
- **Backend:** Spring Boot, Spring Data JPA, MySQL, Lombok, PDF generation

## Project Structure
SmartResumeBuilder/
│
├── smart-resume-frontend/
│ ├── src/
│ │ ├── components/
│ │ ├── pages/
│ │ ├── App.jsx
│ │ ├── main.jsx
│ │ ├── index.css
│ │ └── App.css
│ ├── tailwind.config.js
│ ├── postcss.config.js
│ ├── package.json
│ └── vite.config.js
│
└── smart-reume-backend/
├── src/main/java/com/smartresumebuilder/
│ ├── controller/
│ ├── model/
│ ├── repository/
│ ├── service/
│ └── SmartResumeBuilderApplication.java
├── src/main/resources/
│ └── application.properties
└── pom.xml

shell
Copy code

## Run Backend
```bash
cd smart-reume-backend
mvn spring-boot:run
# Runs on http://localhost:8080
Run Frontend
bash
Copy code
cd smart-resume-frontend
npm install
npm run dev
# Runs on http://localhost:5173
Features
Dynamic resume creation

PDF export

Modern Tailwind UI

REST API integration

User management

Author
Bhagyashree Warad | GitHub
