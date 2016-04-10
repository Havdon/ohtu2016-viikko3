/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

/**
 *
 * @author oskar
 */
public class FileUserDao implements UserDao {
    
    String usernameFile;
    String passwordFile;
    
    List<User> users;
    
    public FileUserDao(String usernameFile, String passwordFile) {
        this.usernameFile = usernameFile;
        this.passwordFile = passwordFile;
        this.load();
    }
    
    final void load() {
        File usernames = new File(usernameFile);
        File passwords = new File(passwordFile);
        
        try {
            this.users = new ArrayList<User>();
            Scanner usernameScanner = new Scanner(usernames);
            Scanner passwordScanner = new Scanner(passwords);
            while (usernameScanner.hasNextLine() && passwordScanner.hasNextLine()) {
                this.users.add(new User(usernameScanner.nextLine(), passwordScanner.nextLine()));
            }
        } catch (FileNotFoundException ex) {
            this.users = new ArrayList<User>();
        }
    }
    
    final void save() {
        try {
            FileWriter usernames = new FileWriter(usernameFile);
            FileWriter passwords = new FileWriter(passwordFile);
            for (User user : this.users) {
                usernames.write(user.getUsername() + "\n");
                passwords.write(user.getPassword() + "\n");
            }
            usernames.close();
            passwords.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<User> listAll() {
        return this.users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        users.add(user);
        this.save();
    }
    
}
