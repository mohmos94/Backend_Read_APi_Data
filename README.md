# Backend prosject lese API data og lagre dem i txt file og database

Dette er et backend prosjekt som leser fixer.io sitt latest rate endpoint og returnerer valuta verdier fra GBP, EUR og USD mot NOK kroner.
<br/>

##Viktig
Man må ha en API nøkkel for Fixer.io for å kunne lage hente ut dataverdiene ifra API.
<br/>
Man må lage et Database.
<br/>
endre endelsen fra Fixerio til databse navnet: jdbc:mysql://localhost:3306/Fixerio"
<br/>
Opprett tabellen i databasen bruk gjerne insert teksten under.

### Lag table i Mysql
<br/>

CREATE TABLE Base (
<br/>
dates varchar(33),
<br/>
base varchar(33),
<br/>
amount float
);

### Driver Manager

Laste ned jar filen inn i IDE.

https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/8.0.31



## Avlesning av API
Dataen vil leses av i API og Lagres i Data.txt file.
<br/>
Deretter vil disse dataverdiene manipuleres inn i json.txt file for lettere avlesning.
