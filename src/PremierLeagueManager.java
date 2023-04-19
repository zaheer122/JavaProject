package footballmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ahdabnasir
 */
public class PremierLeagueManager implements LeagueManager {
    
    private final int numberOfClubs;
    
    private final ArrayList<FootballClub> league;
    private final Scanner scanner;
    private final ArrayList<Match> matches;
    
    public PremierLeagueManager(int numberOfClubs) {
        
        this.numberOfClubs = numberOfClubs;
        league = new ArrayList<>();
        matches = new ArrayList<>();
        scanner = new Scanner(System.in);
        displayMenu();
    }
    
    
    private void displayMenu() {
        
        while(true) {
            System.out.println("Premier League menu: ");
            System.out.println("Create new team and add it to league (press 1)");
            System.out.println("Delete existing team from league (press 2)");
            System.out.println("Display Statistics for team (press 3)");
            System.out.println("Display the Premier League Table (press 4)");
            System.out.println("Add a Played Match (press 5)");
            System.out.println("Display Calendar and Find Match (press 6)");
            String line = scanner.nextLine();
            int command = 0;
            try {
                command = Integer.parseInt(line);
            } catch (Exception e) {
        }
            
            switch(command) {
                case 1 :
                   addTeam();
            break;
                case 2 :
                    deleteTeam();
                    break;
                case 3 :
                    displayStatistics();
                  break;
                case 4 :
                    displayLeagueTable();
                  break;
                case 5:
                    addPlayedMatch();
                   break;
                case 6:
                    displayCalendar();
                   break;
            default:
            System.out.println("Wrong Command");
        }
        
    } 
   }
 private void addTeam(){
        if(league.size() == numberOfClubs) {
            System.out.println("Can't add more clubs to league");
            return;
        }
        
        FootballClub club = new FootballClub();
        System.out.println("Insert Club Name: ");
        String line = scanner.nextLine();
        club.setName(line);
        
        if(league.contains(club)){
            System.out.println("This club is already in the league");
            return;
        }
        System.out.println("Insert Club Location: ");
        line = scanner.nextLine();
        club.setLocation(line);
        league.add(club);   
    }
    
    private void deleteTeam() {
        System.out.println("Insert club name: ");
        String line = scanner.nextLine();
         for(FootballClub club : league) {
             if(club.getName().equals(line)){
                 league.remove(club);
                 System.out.println("Club "+ club.getName()+" removed");
                 return;
             }
         }
         System.out.println("No such club in league");
    }
    
    private void displayStatistics() {
        
        System.out.println("Insert club name: ");
        String line = scanner.nextLine();
         for (FootballClub club : league) {
             if(club.getName().equals(line)){
                 System.out.println("Club " + club.getName()+ " matches won: " + club.getWinCount());
                 System.out.println("Club " + club.getName()+ " matches lost: " + club.getDefeatCount());
                 System.out.println("Club " + club.getName()+ " matches draw: " + club.getDrawCount());
                 System.out.println("Club " + club.getName()+ " scored goals: " + club.getScoredGoalsCount());
                 System.out.println("Club " + club.getName()+ " recieved goals: " + club.getReceivedGoalsCount());
                 System.out.println("Club " + club.getName()+ " points: " + club.getPoints());
                 System.out.println("Club " + club.getName()+ " matches played: " + club.getMatchesPlayed());
                 return;
             }
         }
         System.out.println("No such club in league");
    } 
