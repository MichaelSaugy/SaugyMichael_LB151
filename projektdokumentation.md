# Projekt-Dokumentation

✍️ Ihr Nachname

| Datum | Version | Zusammenfassung                                              |
| ----- | ------- | ------------------------------------------------------------ |
|       | 0.0.1   | Erstellen und Ausfüllender Dokumentation bis Punkt 4 |
|       | 0.0.2   |                                                              |
|       | 0.0.3   |                                                              |
|       | 0.0.4   |                                                              |
|       | 0.0.5   |                                                              |
|       | 0.0.6   |                                                              |
|       | 1.0.0   |                                                              |

# 0 Ihr Projekt

✍️ Beschreiben Sie Ihr Projekt in einem griffigen Satz.
Ein Quiz, bei welchem man ein Wort oder ein Satz erraten muss.

# 1 Analyse

✍️ Beschreiben Sie, auf welchem Tier Sie die dynamischen Elemente der Anwendung unterbringen möchten:

* Tier 1 (Presentation): Website (Glücksrad Eingabefelder)
* Tier 2 (Webserver): Daten überprüfen
* Tier 3 (Application Server): Prüfung der Buchstaben 
* Tier 4 (Dataserver): Adminlogin, Highscore Liste, Rätsel-wörter/-phrases

# 2 Technologie

✍️ Beschreiben Sie für dieselben Tiers, welche Programmiersprache bzw. Technologie Sie verwenden möchten.
JSF & MySql

# 3 Datenbank

✍️ Wie steuern Sie Ihre Datenbank an? Wie ist das Interface aufgebaut? 

# 4.1 User Stories

✍️ Formulieren Sie klare Anforderungen in der Form von User Stories (*„als … möchte ich … damit …“*) und zu jeder Anforderung mindestens einen dazugehörigen Testfall (in Kapitel 4.2). 

✍️ Formulieren Sie weitere, eigene Anforderungen und Testfälle, wie Sie Ihre Applikation erweitern möchten. Geben Sie diesen statt einer Nummer einen Buchstaben (`A`, `B`, etc.)

| US-№ | Verbindlichkeit | Typ  | Beschreibung                       |
| ---- | --------------- | ---- | ---------------------------------- |
| 1    |                 |      | Als Administrator möchte ich mich durch die Eingabe meines Benutzernamens und Passworts authentifizieren können, damit ich auf die Administrationsfunktionen zugreifen kann. |
| 2    |                 |      | Als Administrator möchte ich Phrasen und Rätselwörter anlegen, ändern und löschen können, damit ich das Angebot an Rätseln und Fragen ändern kann.                                   |
| 3    |                 |      | Als Administrator möchte ich Kategorien anlegen und jedes Wort bzw. jede Frage einer Kategorie zuordnen können, damit ich die Rätsel und Fragen verwalten kann und der Nutzer weis, um was es geht                                   |
| 4    |                 |      | Als Client dient ein Webbrowser. |
| 5    |                 |      | Als Kandidat möchte ich meinen Namen eingeben und auf der Highscore-Liste erscheinen können, damit ich meine Leistungen mit anderen teilen kann.                                   |
| 6    |                 |      | Als Kandidat möchte ich jederzeit meinen Kontostand und meine Lebenspunkte sehen können, damit ich den Fortschritt des Spiels verfolgen kann.                                   |
| 7    |                 |      | Als Kandidat möchte ich jederzeit meinen Lebenspunkte sehen können, damit ich den Fortschritt des Spiels verfolgen kann.                                   |
| 8    |                 |      | Als Kandidat möchte ich erfahren, ob meine Antwort richtig oder falsch war, damit ich mein Wissen verbessern kann und beim nächste Mal besser bin.                                   |
| 9    |                 |      | Als Kandidat möchte ich jederzeit das Spiel beenden und meinen Gewinn in die Highscore-Liste übernehmen können, damit ich meine Leistungen aufzeichnen kann.                                   |
| 10   |                 |      | Als Kandidat möchte ich Rang, Name des Spielers, Zeitpunkt des Spiels, Geldbetrag und Anzahl der Spielrunden sehen, damit ich mich mit anderen Kandidaten vergleichen kann.                                   |
| 11   |                 |      | Als Kandidat möchte ich, dass die Rangliste nach der höhe des Geldbetrags sortiert wird, damit ich eine bessere übersicht habe.                                    |
| 12   |                 |      | Als Kandidat (Admin?) möchte ich jedes Rätsel-Wort oder Phrase nur einmal erhalten, damit das Spiel spannend bleibt.                                    |
| 13   |                 |      | Als Kandidat möchte ich jederzeit das Spiel beenden und meinen Gewinn in die Highscore-Liste übernehmen können, damit ich meine Leistungen aufzeichnen kann.
                                   |
| 14   |                 |      | Als Administrator möchte ich das das Spiel mit genügend Wörter und Phrasen gefüllt ist, damit der Kandidat Spass hat                                   |
| 15   |                 |      | Als Kandidat möchte ich, dass die Runden gezählt werden, damit ich weis in welcher Runde ich mich befinde.                                   |

✍️ Jede User Story hat eine ganzzahlige Nummer (1, 2, 3 etc. oder Zahl), eine Verbindlichkeit (Muss oder Kann?), und einen Typ (Funktional, Qualität, Rand). 

# 4.2 Testfälle

| TC-№ | Vorbereitung | Eingabe | Erwartete Ausgabe |
| ---- | ------------ | ------- | ----------------- |
| 1.1  |              |         |                   |
| ...  |              |         |                   |

✍️ Die Nummer hat das Format `N.m`, wobei `N` die Nummer der User Story ist, die der Testfall abdeckt, und `m` von `1` an nach oben gezählt. Beispiel: Der dritte Testfall, der die zweite User Story abdeckt, hat also die Nummer `2.3`.

# 5 Prototyp

✍️ Erstellen Sie Prototypen für das GUI (Admin-Interface und Quiz-Seite).

# 6 Implementation

✍️ Halten Sie fest, wann Sie welche User Story bearbeitet haben

| User Story | Datum | Beschreibung |
| ---------- | ----- | ------------ |
| ...        |       |              |

# 7 Projektdokumentation

| US-№ | Erledigt? | Entsprechende Code-Dateien oder Erklärung |
| ---- | --------- | ----------------------------------------- |
| 1    | ja / nein |                                           |
| ...  |           |                                           |

# 8 Testprotokoll

✍️ Fügen Sie hier den Link zu dem Video ein, welches den Testdurchlauf dokumentiert.

| TC-№ | Datum | Resultat | Tester |
| ---- | ----- | -------- | ------ |
| 1.1  |       |          |        |
| ...  |       |          |        |

✍️ Vergessen Sie nicht, ein Fazit hinzuzufügen, welches das Test-Ergebnis einordnet.

# 9 `README.md`

✍️ Beschreiben Sie ausführlich in einer README.md, wie Ihre Applikation gestartet und ausgeführt wird. Legen Sie eine geeignete Möglichkeit (Skript, Export, …) bei, Ihre Datenbank wiederherzustellen.

# 10 Allgemeines

- [ ] Ich habe die Rechtschreibung überprüft
- [ ] Ich habe überprüft, dass die Nummerierung von Testfällen und User Stories übereinstimmen
- [ ] Ich habe alle mit ✍️ markierten Teile ersetzt
