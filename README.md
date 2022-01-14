#CarsTheGame

#Abstract 

In dem Spiel "CarsTheGame" spielt ihr mit bekannten Charakteren aus der Cars Triologie. 
Man fährt Rennen in verschiedenen Teilen der Welt. Das Ziel ist es, keine Hindernisse zu treffen und einen möglichst hohen Highscore zu erreichen. 
den SCore kan man verbessern, indem man Münzen einsammelt.

#Testprotokoll
Version 1.0, 14. Januar 2022 | Projektteam: Levin Zehnder, Mattia Gisiger
##Testkonzept
Sourcecodeversion: commit: "small adjustments to the score system" (14.01.2022 9:05)
Betriebssystem: Windows 10
Java-Version: 16.0.2
##User Acceptance Testfälle
ID: T-01 <br />
Anforderungen: US-01 <br />
Vorbedingungen: Benutzer hat funktionierende Tastatur/Maus. Das Programm wurde korrekt gestartet. <br />
Ablauf: 
1. Der Benutzer startet das Spiel <br />

Erwartetes Resultat: Es erscheint der Startbildschirm von CarsTheGame (Hintergrundbild + 4 Buttons)

ID: T-02 <br />
Anforderungen: US-02 <br />
Vorbedingungen: Der Benutzer hat funktionierende Tastatur/Maus. Das Programm wurde korrekt gestartet. <br />
Ablauf:
1. Der Benutzer startet das Spiel 
2. Der Startbildschirm erscheint 
3. Der Benutzer klickt auf den "Help"-Button <br />

Erwartetes Resultat: Es erscheint eine Szene wo dem Benutzer das Spiel erklärt wird

ID: T-03 <br />
Anforderungen: US-03 <br />
Vorbedingungen: Der Benutzer hat funktionierende Tastatur/Maus. Das Programm wurde korrekt gestartet. <br />
Ablauf:
1. Der Benutzer startet das Spiel 
2. Der Startbildschirm erscheint
3. Der Benutzer klickt auf den "Game"-Button
4. Das Spiel startet
5. Mit "a", "d" oder den Pfeiltasten kann das Auto gesteuert werden <br />

Erwartetes Resultat: Der Benutzer kann den Hindernissen (Reifen) ausweichen

ID: T-04 <br />
Anforderungen: US-04 <br />
Vorbedingungen: Der Benutzer hat funktionierende Tastatur/Maus. Das Programm wurde korrekt gestartet. <br />
Ablauf:
1. Der Benutzer startet das Spiel
2. Der Startblidschirm erscheint
3. Der Benutzer klickt auf den "Game"-Button
4. Das Spiel startet
5. Mit "a", "d" oder den Pfeiltasten kann das Auto gesteuert werden <br />

Erwartetes Resultat: Wird das Auto von einem Hinderniss getroffen, gelangt der Benutzer zum GameOver-Bildschirm

ID: T-05 <br />
Anforderungen: US-05 <br />
Vorbedingungen: Der Benutzer hat funktionierende Tastatur/Maus. Das Programm wurde korrekt gestartet. <br />
Ablauf:
1. Der Benutzer startet das Spiel
2. Der Startblidschirm erscheint
3. Der Benutzer klickt auf den "Game"-Button
4. Das Spiel startet
5. Mit "a", "d" oder den Pfeiltasten kann das Auto gesteuert werden <br />

Erwartetes Resultat: Trifft das Auto eine Münze, erhöht sich der Score um 5

ID: T-06 <br />
Anforderungen: US-06 <br />
Vorbedingungen: Der Benutzer hat funktionierende Tastatur/Maus. Das Programm wurde korrekt gestartet. <br />
Ablauf:
1. Der Benutzer startet das Spiel
2. Der Startblidschirm erscheint
3. Der Benutzer klickt auf den "Game"-Button
4. Das Spiel startet
5. Mit "a", "d" oder den Pfeiltasten kann das Auto gesteuert werden
6. Am oberen rechten Bildrand wir "Score: " und der korrekte momentane Score angezeigt
7. Trifft das Auto eine Münze, erhöht sich der Score um 5
8. Kollidiert der Benutzer mit einem Hinderniss, gelangt er zu dem GameOver Screen wo der momentane Highscore angezeit wird
9. Der Benutzer klickt auf den "Menu"-Knopf und gelangt dadurch zurück zum Hauptmenu
10. Der Benutzer klickt auf den "Game"-Button und das Spiel startet erneut
11. Der Score am oberen rechten Bildrand ist zum Start des Spiels auf 0 gesetzt
12. Nach einen Kollision mit einem Hinderniss gelangt der Benutzer zurück zum GameOver-Screen <br />

Erwartetes Resultat: Im Game-Over-Screen wird der neue (je nach dem ob der Benutzer einen neuen Highscore geschafft hat) Highscore angezeigt

ID: T-07 <br />
Anforderungen: US-07 <br />
Vorbedingungen: Der Benutzer hat funktionierende Tastatur/Maus. Das Programm wurde korrekt gestartet. <br />
Ablauf:
1. Der Benutzer startet das Spiel
2. Der Startblidschirm erscheint
3. Der Benutzer klickt auf den "Choose Car"-Button
4. Es erscheint eine Szene in der sechs verschiedene Charaktere und die dazugehörigen buttons angezeigt werden
5. Im oberen rechten Bildrand sieht der benutzer den momentan ausgewählten Charakter
6. Durch einen Klick auf den Button eines Charakters wird dieser ausgewählt
7. Der momentan ausgewählte Charakter wird geupdated und entspricht dem gewählten Charakter
8. Der Benutzer klickt auf den Pfeil im oberen linken Bildrand
9. Der Benutzer gelangt zurück zum Startbildschirm
10. Der Benutzer klickt auf den "Game"-Button <br />

Erwartetes Resultat: Das Auto im Spiel ist das ausgewählte Auto

ID: T-08 <br />
Anforderungen: US-08 <br />
Vorbedingungen: Der Benutzer hat funktionierende Tastatur/Maus. Das Programm wurde korrekt gestartet. <br />
Ablauf:
1. Der Benutzer startet das Spiel
2. Der Startblidschirm erscheint
3. Der Benutzer klickt auf den Game Button <br />

Erwartets Resultat: Musik starte beim Start des Spiels und ändert wenn sich der Background ändert

###Testprotokoll
ID   |Erfolgreich|Bemerkungen
T-01 | Ja        | Funktioniert Einwandfrei 
T-01 | Ja        | Funktionierte erneut einwandfrei
T-01 | Ja        | Funktionierte erneut einwandfrei
T-02 | Ja        | Funktioniert Einwandfrei
T-02 | Ja        | Funktionierte erneut einwandfrei
T-02 | Ja        | Funktionierte erneut einwandfrei
T-03 | Ja        | Funktioniert Einwandfrei
T-03 | Ja        | Funktionierte erneut einwandfrei
T-03 | Ja        | Funktionierte erneut einwandfrei
T-04 | Ja        | Funktioniert Einwandfrei
T-04 | Ja        | Funktionierte erneut einwandfrei
T-04 | Ja        | Funktionierte erneut einwandfrei
T-05 | Ja        | Funktioniert Einwandfrei
T-05 | Ja        | Funktionierte erneut einwandfrei
T-05 | Ja        | Funktionierte erneut einwandfrei
T-06 | Ja        | Funktioniert Einwandfrei
T-06 | Ja        | Funktionierte erneut einwandfrei
T-06 | Ja        | Funktionierte erneut einwandfrei
T-07 | Ja        | Funktioniert Einwandfrei
T-07 | Ja        | Funktionierte erneut einwandfrei
T-07 | Ja        | Funktionierte erneut einwandfrei
T-08 | Ja        | Funktioniert Einwandfrei
T-08 | Ja        | Funktionierte erneut einwandfrei
T-08 | Ja        | Funktionierte erneut einwandfrei


#Fazit

Allgemein lief das Projekt sehr gut. 
beim projektantrag haben wir uns sehr gut eingeschätzt.
Die Zusammenarbeit im Team lief sehr gut.
Wir haben gelernt, dass man beim Projektantrag scheinbar einfache Features im vorhinein besser überdenken sollte.
Wir konnten alle erforderlichen und alle optionalen Features implementieren.
Es gibt noch diverse Bugs (Musik läuft nach gameOver manchmal weiter, Auto steuert alleine nach rechts/links nach Kollision mit einem Hindernis).
Beim nächsten Projekt würden wir etwas machen das weniger Grafiken erfordert. 
Mit dem Endprodukt sind wir bis auf die diversen bugs sehr zufrieden.