package org.example.exceptions;

import javax.swing.*;

public class WarningException extends RuntimeException{
    public WarningException(){}
    public WarningException(String message){
        super(message);
        JOptionPane.showMessageDialog(null, message, "Kesalahan Input", JOptionPane.WARNING_MESSAGE);
        throw new RuntimeException(message);
    }
}
