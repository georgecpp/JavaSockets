package service;

import model.Human;
import model.Profesor;
import model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

public class ThreadHandler implements Runnable {

    private final Socket clientSocket;
    List<Human> persons;

    PrintWriter out = null;
    BufferedReader in = null;

    public ThreadHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.persons = new ArrayList<>();
    }

    @Override
    public void run() {

        try {
            out = new PrintWriter(
                    clientSocket.getOutputStream(), true);

            in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                // output the sorted collection of Human by age.
                if(message.equals("stop")) {
                    Collections.sort(persons);
                    out.println("["+persons.stream().map(Human::toString).collect(Collectors.joining(", "))+"]");
                    return;
                }
                // exceptions.
                if(!message.startsWith("Student") && !message.startsWith("Professor")) {
                    out.println("Wrong format! Must specify entity Student or Professor as first word in the message!");
                    closeStreams();
                    return;
                }
                if(Arrays.stream(message.split(" ")).count() < 6) {
                    out.println("Wrong format! Must respect the following message format: Student | Professor nume prenume facultate varsta anStudiu | materie");
                    closeStreams();
                    return;
                }
                addPerson(message);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStreams();
        }
    }
    private void addPerson(String message) {

        // now we have a valid format.
        List<String> fields = Arrays.stream(message.split(" ")).toList();
        if(fields.get(0).equals("Student")) {
            Human student = new Student(
                    fields.get(1),
                    fields.get(2),
                    fields.get(3),
                    Integer.parseInt(fields.get(4)),
                    Integer.parseInt(fields.get(5))
            );
            persons.add(student);
        }
        else {
            Human profesor = new Profesor(
                    fields.get(1),
                    fields.get(2),
                    fields.get(3),
                    Integer.parseInt(fields.get(4)),
                    fields.get(5)
            );
            persons.add(profesor);
        }
        out.println("Persons now in this connection: " + persons.size());
    }

    private void closeStreams() {
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
                clientSocket.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
