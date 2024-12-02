#include <Arduino.h>

#define LED_PIN 0  // Définir le pin de la LED (13 pour la LED intégrée)


// Fonction pour faire clignoter la LED
void blinkLED() {
  digitalWrite(LED_PIN, HIGH); // Allumer la LED
  delay(1000);                 // Attendre 500 ms
  digitalWrite(LED_PIN, LOW);  // Éteindre la LED
  // delay(500);                 // Attendre 500 ms
}

void setup() {
  pinMode(LED_PIN, OUTPUT);  // Configurer le pin de la LED en mode sortie
  Serial.begin(9600);       // Initialiser la communication série à 9600 bps
  // Serial.println("Attente d'un caractère sur le port série...");

  blinkLED();

  digitalWrite(LED_PIN, LOW); // Éteindre la LED
}

void loop() {
  // Vérifier si des données sont disponibles sur le port série
  if (Serial.available() > 0) {
    char receivedChar = Serial.read();  // Lire le caractère reçu
    // Serial.print("Caractère reçu : ");
    // Serial.println(receivedChar);

    // Vérifier si le caractère reçu est 'A'
    if (receivedChar == 'A') {
      // Serial.println("Clignotement de la LED...");
      blinkLED();
    }
  }
}

