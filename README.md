# Backend prosject lese API data og lagre dem i txt file og database

Dette er et backend prosjekt som leser fixer.io sitt latest rate endpoint og returnerer valuta verdier fra GBP, EUR og USD mot NOK kroner.
<br/>
## Lag table i Mysql
<br/>

CREATE TABLE Base (
<br/>
dates varchar(33),
<br/>
base varchar(33),
<br/>
amount float
);

