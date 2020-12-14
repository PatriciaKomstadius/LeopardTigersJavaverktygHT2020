INSTRUKTIONER I IDE:
- Öppna terminalen
- Klona ner projektet från repositoryt till din dator
- I terminalen: git clone projektadress 
- Öppna projektet i din IDE (Ex IntelliJ)
- Öppna terminalen i IDEn
- Kör kommandot mvn test i IntelliJ - detta kompilerar, bygger samt kör alla test i IntelliJ.
- Kör Run i IntelliJ för att starta programmet
- När programmet är igång kommer menyn över kontaktboken upp.
- Här kan du välja att lägga till, radera, söka efter eller visa kontakter. 
- För att avsluta tryck 0.

INSTRUKTIONER FÖR PROGRAMMET UTAN IDE:
- Ladda ner och installera Maven från internet
- Unzippa mappen på din dator och flytta över innehållet till en ny mapp med valfritt namn.
- Lägg den nya mappen på C:
- Ställ in miljövariabler genom att ange sökväg till mappen med bin under "New Path" samt sökväg till mappen utan bin som MAVEN_HOME variabel. 
- Öppna sedan terminalen på datorn
- Skriv mvn --version för att säkerställa att du har en maven-version korrekt installerad. 

- Öppna terminalen
- Navigera till projektets root-mapp
- Skriv mvn package
- Kör programmet genom att ange: java -jar LeopardTigersJavaverktygHT2020/target/LeopardTigersJavaverktygHT2020-1.0.jar
- Nu körs programmet


Obs! Maven kräver att Java är installerad på datorn för att fungera.
