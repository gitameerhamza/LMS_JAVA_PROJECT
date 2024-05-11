package com.example.demoprojapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label labl;
    @FXML
    private Label label_2;
    @FXML
    private Label idbox;
    @FXML
    private Label namebox;
    @FXML
    private Label authbox;
    @FXML
    private Label bookname_i;
    @FXML
    private Label chk_label;
    @FXML
    private Stage stage;
    @FXML
    private TextField Memid_in;
    @FXML
    private TextField Memname_in;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private TextField bookid_in;
    @FXML
    private TextField book_in2;
    @FXML
    private TextField book_in3;
    @FXML
    private TextField idname_btn;

    @FXML
    public void switchscene3(ActionEvent event) throws IOException {
        root =FXMLLoader.load(getClass().getResource("scene3.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchscene2(ActionEvent event) throws IOException {
        root =FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchscene4(ActionEvent event) throws IOException {
        root =FXMLLoader.load(getClass().getResource("scene4.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }public void switchscene5(ActionEvent event) throws IOException {
        root =FXMLLoader.load(getClass().getResource("scene5.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchscene6(ActionEvent event) throws IOException {
        root =FXMLLoader.load(getClass().getResource("scene6.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    Library library = new Library();
    Scanner scanner = new Scanner(System.in);
    @FXML
    private  void addBook() {
        String id = bookid_in.getText();
        String title = book_in2.getText();
        String author = book_in3.getText();
        if(!(id.matches("\\d+"))){
            label_2.setText("Bro Look at the Id ");
            return;
        }
        if (!(id.isBlank() || title.isBlank() || author.isBlank())) {
            Book book = new Book(id, title, author);
            library.addBook(book);
            label_2.setText("Book added successfully.");
            return;
        }
        label_2.setText("Something Not Right!\nTry Again");
    }
    @FXML
    private void addMember() {
        if(!(Memid_in.getText().matches("\\d+"))){
            label_2.setText("Bro Look at the Id ");
            return;
        }
        if(Memname_in.getText().matches("\\d+")){
            label_2.setText("Bro Look at the Name ");
            return;
        }
        if(Memid_in.getText().isBlank()){
            label_2.setText("Bro Look at the Id ");
            return;
        }
        int id = Integer.parseInt(Memid_in.getText());
        String name = Memname_in.getText();
        if (!( name.isBlank())) {
            Member member = new Member(id, name);
            library.addMember(member);
            label_2.setText("Member added successfully.");
            return;
        }
    }

    @FXML
    private  void searchBook() {
        System.out.print("Enter Book ID: ");
        String id = idname_btn.getText();
        Book book = library.findBook(id);
        if (book != null) {

            System.out.println("ID: "+book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }

    private  void borrowBook() {
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        library.lendBook(memberId, String.valueOf(bookId));
    }

    private  void returnBook() {
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        library.returnBook(memberId, bookId);
    }

    private  void showMemberInfo() {
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        library.showMemberInfo(memberId);
    }
}