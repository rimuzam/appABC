package org.example.exceptions;

import javax.swing.*;

public class ErrorException extends RuntimeException{
    public ErrorException(){}
    public ErrorException(String message){
        super(message);
        JOptionPane.showMessageDialog(null, "Error App", "Error", JOptionPane.ERROR_MESSAGE);
        throw new RuntimeException(message);
    }
}
