# Projekt-Dokumentation

Saugy

| Datum | Version | Zusammenfassung                                              |
| ----- | ------- | ------------------------------------------------------------ |
| 12.01.2023      | 0.0.1   | Erstellen und Ausfüllen der Dokumentation bis Punkt 4.1 |
| 16.01.2023      | 0.0.2   | Überarbeiten der Punkte bis 4.1 und ausfüllen der Dokumentation bis 5 |
| 22.02.2023      | 0.0.3   | Dokumentation überarbeitet und fertigstellen der Testfälle                                                             |
| 02.03.2023      | 0.0.4   | Dokumentation überarbeitet und vollendet                                                             |

# 0 Ihr Projekt

Ein Quiz, bei welchem man ein Wort oder ein Satz erraten muss, um einen Gewinn zu erzielen.

# 1 Analyse

* Tier 1 (Presentation): Webseite (Glücksrad Eingabefelder), JSF
* Tier 2 (Webserver): Daten von den Eingabefeldern empfangen und überprüfen, JSF
* Tier 3 (Application Server): Prüfung der Buchstaben und das AdminLogin 
* Tier 4 (Dataserver): Highscore Liste, Rätsel-wörter/-phrases in mySQL

# 2 Technologie
Ich habe mich für JSF und mySQL entschieden, da wir diese im Unterricht bereits behandelt haben. Ausserdem hat unsere Lehrperson ebenfalls mit JSF und mySQL gearbeitet, dadurch kann ich mir besser Hilfe holen, falls ich diese benötige

# 3 Datenbank
Ich habe eine mySQL Datenbank verwendet. Diese habe ich mit phpMyAdmin erstell. Um die Datenbank mit dem Programm zu verknüpfen habe ich JPA verwendet.

# 4.1 User Stories

| US-№ | Verbindlichkeit | Typ  | Beschreibung                       |
| ---- | --------------- | ---- | ---------------------------------- |
| 1    | Muss                | Funktional     | Als Administrator möchte ich mich durch die Eingabe meines Benutzernamens und Passworts authentifizieren können, damit ich auf die Administrationsfunktionen zugreifen kann. |
| 2    | Muss                | Funktional     | Als Administrator möchte ich Phrasen und Rätselwörter anlegen, ändern und löschen können, damit ich das Angebot an Rätseln und Fragen ändern kann.                                   |
| 3    | Muss                | Funktional     | Als Administrator möchte ich Kategorien anlegen und jedes Wort bzw. jede Frage einer Kategorie zuordnen können, damit ich die Rätsel und Fragen verwalten kann und der Nutzer weis, um was es geht                                   |
| 4    | Muss                | Randbedingung     | Als Client dient ein Webbrowser. |
| 5    | Muss                | Funktional     | Als Kandidat möchte ich meinen Namen eingeben, damit ich auf der Highscsoreliste erscheinen kann und meine Leistungen mit anderen teilen kann.                                   |
| 6    | Muss                | Funktional     | Als Kandidat möchte ich jederzeit meinen Kontostand sehen können, damit ich den Fortschritt des Spiels verfolgen kann.                                   |
| 7    | Muss                | Funktional     | Als Kandidat möchte ich jederzeit meinen Lebenspunkte sehen können, damit ich den Fortschritt des Spiels verfolgen kann.                                   |
| 8    | Muss                | Funktional     | Als Kandidat möchte ich erfahren, ob meine Antwort richtig oder falsch war, damit ich mein Wissen verbessern kann und beim nächste Mal besser bin.                                   |
| 9    | Muss                | Funktional     | Als Kandidat möchte ich das Spiel jederzeit beenden und meinen Gewinn in die Highscore-Liste übernehmen können, damit ich meine Leistungen aufzeichnen kann.                                   |
| 10   | Muss                | Funktional     | Als Kandidat möchte ich Rang, Name des Spielers, Zeitpunkt des Spiels, Geldbetrag und Anzahl der Spielrunden sehen, damit ich mich mit anderen Kandidaten vergleichen kann.                                   |
| 11   | Muss                | Qualität     | Als Kandidat möchte ich, dass die Rangliste nach der höhe des Geldbetrags sortiert wird, damit ich eine bessere übersicht habe.                                    |
| 12   | Muss                | Funktional     | Als Kandidat (Admin?) möchte ich jedes Rätsel-Wort oder Phrase nur einmal erhalten, damit das Spiel spannend bleibt.                                    |
| 13   | Muss                | Funktional     | Als Kandidat möchte ich das Glücksrad drehen können, damit ich um einen Betrag spielen kann |
| 14   | Muss                | Qualität     | Als Administrator möchte ich, dass das Spiel mit genügend Wörter und Phrasen gefüllt ist, damit der Kandidat Spass hat                                   |
| 15   | Muss                | Funktional     | Als Kandidat möchte ich, dass die Runden gezählt werden, damit ich weis in welcher Runde ich mich befinde.                                   |
| 16   | Muss                | Funktional     | Als Kandidat möchte ich durch Raten eines Konsonanten den Betrag gewinnen, damit ich einen Gewinn erzielen kann                                   |
| 17   | Muss                | Randbedingung     | Als Template möchte ein Layout verwendet wird, damit ich nicht den gleichen Code mehrmals verwenden muss.                                   |
| 18   | Muss                | Funktional     | Als Kandidat möchte, dass beim Drehen eine Wahrscheinlichkeit besteht, bankrott zu gehen, damit das Spiel interessant bleibt.                                   |
| A   | Kann                | Funktional     | Als Kandidat möchte ich, die Schwierigkeit der Wörter/Phrasen ändern können, damit ich auf einem mir angemessenen Niveau spielen kann.                                   |
| B   | Kann                | Funktional     | Als Kandidat möchte ich eine Hilfe-Funktion haben, die mir ermöglicht, Hinweise oder Tipps zu einer Frage oder einem Rätsel zu erhalten, damit ich das Rätsel besser lösen kann. |
| C   | Kann                | Funktional     | Als Kandidat möchte ich eine Funktion haben, um ein Rätsel zu melden, falls ich denke, dass es sich um einen Schreibfehler handelt, damit ich dazu beitragen kann, die Qualität der Rätsel zu verbessern. |
| D   | Muss                | Funktional     | Als Administrator möchte ich eine Funktion haben um die Statistiken der einzelnen Rätsel anzuzeigen, damit ich erfahre welche Rätsel besonders schwer oder leicht sind und anpassen kann. |
| 19   | Muss                | Funktional     | Als Kandidat möchte ich, dass mir angezeigt wird, sobald ich alle Konsonanten erraten habe, damit ich keine unnötigen Lebenspunkte verschwende.                                   |


# 4.2 Testfälle

| TC-№ | Vorbereitung | Eingabe | Erwartete Ausgabe |
| ---- | ------------ | ------- | ----------------- |
| 1.1  | Admin Account erstellt             | Name und Paswort        | Anzeigen der Administratorfuktionen                  |
| 2.2  | Als Admin einloggen             | Neues Rätsel hinzufügen        | Rätsel wird der Tabelle "phrases" hinzugefügt                  |
| 3.3  | Als Admin einloggen             | Kategorie hinzufügen        | Kategorie wird der DB hinzugefügt                  |
| 3.4  | Kategorie erstellen             | Kategorie einem Rätsel hinzufügen        | In der DB ersichtliche Verbindung von Rätsel und Kategorie                  |
| 4.5  | Programm vorhanden             | Überpüfen um was für eine Art Programm es sich handelt        | Es handelt sich um eine Java Web Applikation                  |
| 5.6  | Seite aufrufen             | "Test" als Namen eingeben und das Spiel spielen        | Name ist hinter "Spieler:" ersichtlich                   |
| 6.7  | Seite aufrufen             | "Test" als Namen eingeben und das Spiel starten         | Oben rechts sind die Lebenspunkte ersichtlich                  |
| 7.8  | Seite aufrufen             | "Test" als Namen eingeben und das Spiel starten         | Oben rechts ist der Kontostand ersichtlich                  |
| 8.9  | Seite aufrugen und Spiel mit beliebigem Namen starten             | 1. Rätsel falsch beantowrten und das 2. richtig        | 1. Rätsel wird korrigiert                  |
| 9.10  | Seite aufrufen und Spiel mit beliebigem Namen starten             | Einen Betrag von mehr als 0 erspielen und auf "Spiel verlassen" klicken        | Kontostand wird auf die Highscoreliste übertragen                  |
| 10.11  | Seite aufrufen             | Einen Namen eingeben und Spiel starten        | Auf der rechten seite des Bildschirms ist eine Tabelle mit allen Informationen verfügbar                  |
| 11.12  | Seite auftrufen             | Einen Namen eingeben und Spiel starten        | Auf der rechten seite des Bildschirms ist eine nach dem gewonnenen Betrag sortierte Rangliste/Tabelle                  |
| 12.13  | Namen eingeben und Spiel starten             | Rätsel erraten und neu starten        | Das gesuchte Wort/Phrase ist ein anderes als zuvor                  |
| 13.14  | Namen eingeben und Spiel starten             | Auf "Spin" klicken        | Es erscheint entweder "Bankrot" oder ein Betrag                  |
| 14.15  | Datenbank befüllt             | Datensätze zählen        | Mind. 20 verschiedene Wörter/Phrasen                  |
| 15.16  | Spiel mit beliebigem Namen gestartet             | Wort/Phrase erraten        | Anzeige von "Rätsel Nr. 1" wird zu "Rätsel Nr. 2"                  |
| 16.17  | Spiel gestartet und auf "Spin" geklickt (Darf nicht Bankrott sein)             | Konsonanten eingeben, welcher im Wort vorkommt        | Der Betrag, welcher beim "Spin" herauskam wurde dem Konto zugeschrieben                  |
| 17.18  | Code vorhanden             | Überprüfen, ob ein template verwendet wurde        | Template wurde verwendet                 |
| 18.19  | Spiel gestartet oder Code vorhanden | Auf "Spin" klicken bis "Bankrot" erscheint oder im Code nach der Methode "Spin" suchen und überprüfen | Nach einigem Klicken erscheint "Bankrot" und das Spiel ist verloren oder es ist eine Wahrscheinlichkeit um zu verlieren in der Spin methode eingebaut |
| A.20  |              |         |                   |
| B.21  |              |         |                   |
| C.22  |              |         |                   |
| D.23  | Als Admin eingeloggt             | Auf "Phrasen" klicken        | Tabelle mit allen Wörter und Phrasen und wie oft sie nicht erraten wurden                |
| 19.24  | Spiel gestartet | Alle Konsonanten der Phrase erraten | Meldung escheint, um den Nutzer zu informieren.                |

# 5 Prototyp

Quiz Seite:                   
![image](https://user-images.githubusercontent.com/69577552/222378907-2a5df48a-056c-40b0-a0bd-5e85e5d25d5f.png)

Admin Interface: 
![image](https://user-images.githubusercontent.com/69577552/222378985-2671e691-f383-46f0-a8e0-4df960ffbc11.png)



# 6 Implementation

| User Story | Datum | Beschreibung |
| ---------- | ----- | ------------ |
| 2,3,4,6,7,13        | 13.02.2023      |              |
| 5,8,16              | 21.02.2023      |              |
| 9,10,11             | 22.02.2023      |              |
| 14                  | 23.20.2023      | DB befüllt               |
| 1                   | 01.03.2023      | Admin Login hinzugefügt  |
| ...        |       |              |

# 7 Projektdokumentation

| US-№ | Erledigt? | Entsprechende Code-Dateien oder Erklärung |
| ---- | --------- | ----------------------------------------- |
| 1    | ja        | "adminLogin.xhtml" ist das Formular, der Code befindet sich in der Datei "AdminBean.java"                                          |
| 2    | ja        | Befindet sich in den automatisch generierten Dateien Create.xhtml, Edit.xhtml, List,xhtml View.xhtml im Ordner "games". Dazu werden die Dateien Games.java, GamesController.java. GamesFacade.java verwendet. Diese sind ebenfalls automatisch generiert.                                         |
| 3    | ja        | Durch die Automatisch generierten Dateien: Create.xhtml, Edit.xhtml, List,xhtml View.xhtml im Ordner "phrases" und "difficulty". AUsserdem werden die Dateien Difficulty.java, DifficultyController.java, DifficultyFacade, Phrases.java, PhrasesController.java und PhrasesFacade.java verwendet |
| 4    | ja        | Java Web Applplikaiton                                          |
| 5    | ja        | Auf der Seite index.xhtml wird der Name eingegeben, dieser wird dann in der Datei "QuizBean.java" gespeichert. |
| 6    | ja        | Auf der Seite mainQuiz.xhtml auf Zeile 56 befindet sich das Label mit der Anzeige des Kontostands. |
| 7    | ja        | Auf der Seite mainQuiz.xhtml auf Zeile 57 befindet sich das Label mit der Anzeige der Lebenspunkte. |
| 8    | ja        | QuizBean.java Zeile 268 und Zeile 284                                          |
| 9    | ja        | QuizBean.java Zeile 321 Methode "saveGame" and DBConnection.java Zeile 50 Methode "saveToDB".                                          |
| 10   | ja        | mainQuiz.xhtml Zeile 59.                                          |
| 11   | ja        | DBConnection.java Zeile 87 Methode "getLeaderboard".                                          |
| 12   | nein      | Erstellt eine unendliche Schleife nach einigem benutzen QuizBean.java Zeile 310                                          |
| 13   | ja        | mainQuiz.xhtml Zeile 32 und QuizBean.java Zeile 131 Methode "Spin".                                          |
| 14   | ja        | In der Datenbank oder im Skript quizm151.sql ab der Zeile 106.                                          |
| 15   | ja        | In QuizBean.java auf Zeile 294 wird dieser erhöht, auf Zeile 295 wird dieser beim Velieren auf 1 gesetzt und auf Zeile 327 wird dieser bei einem Neustart auf 1 gesetzt.                                          |
| 16   | ja        | In QuizBean.java auf Zeile 206 in der Methode "guess".                                          |
| 17   | ja        | Alles im "Template" Ornder                                          |
| 18   | ja        | In QuizBean.java auf Zeile 135 in der Methode "spin".                                          |
| A    | nein      | Keine Zeit - Kann-Anforderung                                          |
| B    | nein      | Keine Zeit - Kann-Anforderung                                          |
| C    | nein      | Keine Zeit - Kann-Anforderung                                          |
| D    | ja        | In QuizBean.java auf Zeile 284 wird die Variable "timesFailed" beim Verlieren aktualisiert (DBConnection.java Zeile 114 Methode "updateTimesFailed")                                          |
| 19    | ja      | QuizBean.java Zeile 215                                          |

# 8 Testprotokoll

Video:           
https://www.youtube.com/watch?v=0_IqwA7d-LM

Folgende Testfälle sind im Video nicht ersichtlich: 4.4, 12.13, 14.15, 17.18, 19.24

| TC-№ | Datum | Resultat | Tester |
| ---- | ----- | -------- | ------ |
| 1.1  | 02.03.2023     | Ok         | Michael Saugy        |
| 2.2  | 02.03.2023     | Ok           | Michael Saugy        |
| 3.3  | 02.03.2023     | Ok          | Michael Saugy        |
| 3.4  | 02.03.2023     | Ok          | Michael Saugy        |
| 4.5  | 02.03.2023     | Ok          | Michael Saugy        |
| 5.6  | 02.03.2023     | Ok          | Michael Saugy        |
| 6.7  | 02.03.2023     | Ok          | Michael Saugy        |
| 7.8  | 02.03.2023     | Ok          | Michael Saugy        |
| 8.9  | 02.03.2023     | Ok          | Michael Saugy        |
| 9.10  | 02.03.2023       | Ok          | Michael Saugy        |
| 10.11  | 02.03.2023       | Ok          | Michael Saugy        |
| 11.12  | 02.03.2023       | Ok          | Michael Saugy        |
| 12.13  | 02.03.2023       | NOk         | Michael Saugy        |
| 13.14  | 02.03.2023       | Ok          | Michael Saugy        |
| 14.15  | 02.03.2023       | Ok          | Michael Saugy        |
| 15.16  | 02.03.2023       | Ok          | Michael Saugy        |
| 16.17  | 02.03.2023       | Ok          | Michael Saugy        |
| 17.18  | 02.03.2023       | Ok          | Michael Saugy        |
| 18.19  | 02.03.2023       | Ok          | Michael Saugy        |
| A.20  | 02.03.2023       | NOk          | Michael Saugy        |
| B.21  | 02.03.2023       | NOk          | Michael Saugy        |
| C.22  | 02.03.2023       | NOk          | Michael Saugy        |
| D.23  | 02.03.2023       | Ok           | Michael Saugy        |
| 19.24  | 02.03.2023       | Ok          | Michael Saugy        |


Alle bis auf 1 Muss-Anfoderungen wurden erfüllt. Das Programm kann trotz allem Problemlos genutzt werden.

# 10 Allgemeines

- [ ] Ich habe die Rechtschreibung überprüft
- [ ] Ich habe überprüft, dass die Nummerierung von Testfällen und User Stories übereinstimmen
- [ ] Ich habe alle mit ✍️ markierten Teile ersetzt
