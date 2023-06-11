# Bootcoding's IPL Search API Project

The IPL Search API project is a RESTful API that provides information about the Indian Premier League (IPL) cricket matches. It allows users to search for specific matches, teams, players, and statistics related to the IPL.

This README file provides an overview of the IPL Search API project, including its features, installation instructions, endpoints, and usage examples.

<img src="https://github.com/bootcoding-developer/bootcoding-practice-project/blob/main/ipl-search-api/doc/bootcoding-ipl-search-api.png" align="center" width="300">

# Why Bootcoding is building search API
This project is for students/graduates who want to learn project development in Java using Spring Boot

- Java 11
- Spring Boot 2.7
- Apache Maven
- Project Lombok
- Apache Lucene
- In Memory database (Key Value Pair)

## Features

- Search for IPL matches by match ID, team names, or player names.
- Retrieve detailed information about specific matches, including match date, venue, teams, players, and statistics.
- Get statistics for individual players, such as runs scored, wickets taken, and batting/bowling averages.
- Explore team statistics, including total runs scored, total wickets taken, and win-loss records.

## Installation

To set up and run the IPL Search API project locally, follow these steps:

1. Clone the repository from GitHub: `git clone https://github.com/bootcoding-developer/bootcoding-practice-project.git`.
2. Navigate to the project directory: `cd ipl-search-api`.
3. Install the project dependencies using a maven like : `maven clean install`.
4. Start the Spring Boot Application: Run Java app `SearchApp.java`.
5. The API will be running on `http://localhost:8080/search/ipl/matches`.

## Endpoints

The IPL Search API provides the following endpoints:

- `GET /search/ipl/matches`: Retrieves a list of all IPL matches.
- `GET /search/ipl/matches/:id`: Retrieves detailed information about a specific match based on the match ID.
- `GET /search/ipl/teams`: Retrieves a list of all IPL teams.
- `GET /search/ipl/teams/:id`: Retrieves detailed information about a specific team based on the team ID.
- `GET /search/ipl/players`: Retrieves a list of all IPL players.
- `GET /search/ipl/players/:id`: Retrieves detailed information about a specific player based on the player ID.

## Usage Examples

1. Get a list of all IPL matches:
   ```
   GET /search/ipl/matches
   ```

2. Get detailed information about a specific match with match ID "123":
   ```
   GET /search/ipl/matches/123
   ```

3. Search for matches involving a specific team (e.g., "Chennai Super Kings"):
   ```
   GET /search/ipl/matches?team=Chennai Super Kings
   ```

4. Search for matches where a specific player (e.g., "Virat Kohli") participated:
   ```
   GET /search/ipl/matches?player=Virat Kohli
   ```

5. Get a list of all IPL teams:
   ```
   GET /search/ipl/teams
   ```

6. Get detailed information about a specific team with team ID "456":
   ```
   GET /search/ipl/teams/456
   ```

Note: Replace the placeholders ":id" with the actual match/team/player ID in the above examples.

## Conclusion

The IPL Search API project provides a convenient way to search for IPL matches, teams, players, and statistics. Feel free to explore the API endpoints and customize the project as per your requirements.

For detailed information about the API endpoints, request/response formats, and error handling, refer to the API documentation or Swagger UI provided with the project.

If you have any questions or need further assistance, please contact the project maintainers.

Happy exploring and analyzing IPL data with the IPL Search API!