package com.example;

import com.example.dao.UserDAO;
import com.example.entity.User;
import java.util.Scanner;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your choice:");
        System.out.println("Enter A for saveuser , Enter B for updateuser,  "
        		+ " Enter C for getting user by id  , Enter D for getting all user, Enter E for delete  ");
       String variable=sc.next();
     
       User user = new User();
       
       int con=1;
       
        do{
        switch(variable) {
        
        case "A":
        // Create user
        	String name;
        	String Email;
        System.out.printf("Enter your name");
        name=sc.next();	
        user.setName(name);
        System.out.println("Enter your email");
        Email=sc.next();
        user.setEmail(Email);
        
        userDAO.saveUser(user);
        break;
        
        case "B":
        // Update user
        System.out.printf("Enter your name for updation");	
        String upname=sc.next();
        user.setName(upname);
        userDAO.updateUser(user);
        break;
        
        case "C":
        // Get user by ID
        	System.out.printf("Enter the id for  getting user");
        	long a = sc.nextInt();
        	user.setId(a);
        User retrievedUser = userDAO.getUserById(user.getId());
        System.out.println("Retrieved User: " + retrievedUser.getName() + ", " + retrievedUser.getEmail());
        break;
        
        case "D":
        // Get all users
        	System.out.println("all users are here");
        List<User> users = userDAO.getAllUsers();
        for (User u : users) {
            System.out.println("User: " + u.getName() + ", " + u.getEmail());
        }
        break;
        
        case "E":
        // Delete user
        userDAO.deleteUser(user.getId());
        System.out.printf("user deleted sucessfully"+ user.getId());
        break;
        
        default:
        	System.out.printf("not a valid crud operation ");
        
        }
        
        System.out.printf("Enter 0 for exit or enter 1 for continue");
         con=sc.nextInt();
        
        }while(con==1);
    }
}
