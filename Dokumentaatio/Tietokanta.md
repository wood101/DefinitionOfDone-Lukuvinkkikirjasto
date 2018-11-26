# Tietokanta

### Luontilauseet

Sprint 1:

Tietokannassa on tässä vaiheessa yksi taulu, jolla määritellään Lukuvinkki. Käytössä on SQLite3 tietokanta.

Tietokannan alustus terminaalissa:


```sql

sqlite3 Bookmarks.db


CREATE TABLE IF NOT EXISTS Bookmark (
	bookmark_id integer PRIMARY KEY,
	bookmark_headline varchar(100),
	bookmark_description varchar(256),
	bookmark_link varchar(200)
);
```
