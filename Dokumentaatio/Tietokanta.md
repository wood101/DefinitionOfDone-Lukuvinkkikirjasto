# Tietokanta

### Luontilauseet

Sprint 1:

Tietokannassa on tässä vaiheessa yksi taulu, jolla määritellään Lukuvinkki. Käytössä on SQLite3 tietokanta.

Tietokannan alustus terminaalissa:


```sql

sqlite3 Bookmarks.db


CREATE TABLE Bookmark (
	bookmark_id integer PRIMARY KEY,
	headline varchar(100),
	description varchar(256),
	link varchar(200)
);
```
