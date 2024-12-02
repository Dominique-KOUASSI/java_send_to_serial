package com.example;

import com.fazecast.jSerialComm.SerialPort;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Trouver le port série COM1
        SerialPort serialPort = SerialPort.getCommPort("COM18");

        // Configurer les paramètres du port série
        serialPort.setComPortParameters(
                9600,  // Vitesse (baud rate)
                8,     // 8 bits de données
                SerialPort.ONE_STOP_BIT,  // 1 bit de stop
                SerialPort.NO_PARITY      // Pas de parité
        );

        // Ouvrir le port série
        if (serialPort.openPort()) {
            System.out.println("Port série ouvert avec succès.");
        } else {
            System.out.println("Échec de l'ouverture du port série.");
            return;
        }

        try {
            // Envoyer un caractère ASCII
            String dataToSend = "A"; // Le caractère ASCII 'A'
            byte[] dataBytes = dataToSend.getBytes();

            serialPort.getOutputStream().write(dataBytes);
            serialPort.getOutputStream().flush();

            System.out.println("Caractère envoyé : " + dataToSend);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer le port série
            if (serialPort.closePort()) {
                System.out.println("Port série fermé avec succès.");
            } else {
                System.out.println("Échec de la fermeture du port série.");
            }
        }
    }
}
