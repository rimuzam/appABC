package org.example.exceptions;

import javax.swing.*;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){}
    public NotFoundException(String message){
        super(message);
        JOptionPane.showMessageDialog(null, message, "Tidak Ditemukan", JOptionPane.ERROR_MESSAGE);
        throw new RuntimeException(message);
    }
}
