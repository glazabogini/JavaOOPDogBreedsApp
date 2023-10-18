# Dog Breeds Analysis Application

This application is a JavaFX project that visualizes the popularity, origins, and sizes of different dog breeds using data stored in a MySQL database.

## Requirements

- Java 11 or higher
- MySQL Server

## Setup Instructions

### Clone the repository

Clone the repository to your local machine:


### Database Setup

To set up the database, follow these steps:

1. Start your MySQL server.
2. Open a command prompt or terminal.
3. Navigate to the directory containing `dogbreeds_setup.sql`.
4. Run the following command, replacing `your_username` with your MySQL username:

		mysql -u your_username -p < dogbreeds_setup.sql

Enter your password when prompted. This script will create a new database named `dogbreedsdatabase` and set up all the necessary tables.

### Configuration

Open `config.properties` and update the database URL, username, and password to match your MySQL server's configuration. (The file is located in the project's resources!)

