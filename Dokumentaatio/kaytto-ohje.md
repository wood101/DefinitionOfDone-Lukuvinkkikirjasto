# Käyttöohje

Projektin suorittamista varten tarkista että sinulla on käytössäsi SQLite3, Gradle asennettuna ja Javasta vähintään versio 8. (versiossa 10 ei välttämättä kaikki testit toimi)

## Koodista buildaaminen

1. Kloonaa projekti gitistä haluamaasi kansioon. 

2. Mene terminaalissa kloonaamasi kansion sisälle ja aja ohjelma komennolle `gradle run` tai `./gradlew run`. 

## Suoritettava .jar

1. Lataa suoritettava [jar](https://github.com/wood101/DefinitionOfDone-Lukuvinkkikirjasto/releases) tiedosto

2. Avaa terminaali, navigoi samaan kansioon ja suorita ohjelma komennolla `java -jar ReadMe-lukuvinkkikirjasto-*versio*.jar`

## Komennot

### Päävalikko

```
  a - lisää uusi lukuvinkki
  f - etsi lukuvinkkejä hakusanalla
  l - listaa lukuvinkit (kaikki tai tyypin mukaan)
  q - lopeta ohjelma
```

- `f` komento vertaa hakusanaa lukuvinkkien kaikkiin kenttiin

#### Listauskomento 'l'

Valittuasi `l`, voit listata lukuvinkit valitsemalla numeron:

1. kaikki lukuvinkit
2. videot
3. kirjat
4. uutiset
5. artikkelit
6. blogit
  
- `b` vie takaisin päävalikkoon

### Listanäkymä

Jos valitset jonkun listanäkymistä 1-6: avautuu seuraava näkymä:

```
+-------+-----------------------+--------------------------------------------------+------+---------+---------+
| Index |       Author          |                       Title                      | Year |  Type   | Checked |
+-------+-----------------------+--------------------------------------------------+------+---------+---------+
| 1     | Juval Noah Harari     | Sapiens                                          | 2018 | Video   | false   |
| 2     | Al Gore               | Global Warming                                   | 2000 | Video   | false   |
| 3     | Don Rosa              | Roope Ankan Elämä ja Teot                        | 2010 | Book    | false   |
| 4     | Pekka Pantsu          | Kouluruokanirsoilijoiden käytökseen halutaan...  | 2018 | Article | true    |
+-------+-----------------------+--------------------------------------------------+------+---------+---------+
```
#### Listanäkymän komennot:

```
  [index] - näytä yksittäinen lukuvinkki listalta
  r       - merkkaa lukuvinkki luetuksi
  b       - takaisin päävalikkoon
  q       - lopeta ohjelma
```
### Yksittäisen vinkin näkymä
Näkymä listaa yksittäisen lukuvinkin tiedot. Komennot ovat:
```
  r - merkkaa luetuksi
  b - takaisin edelliseen listausnäkymään
  o - avaa lukuvinkin linkki selaimeen
  q - lopeta ohjelma
```
- `o` avaa lukuvinkin selaimeen. Kirjojen tapauksessa ohjataan ISBN-numeron perusteella kirjaa vastaavaan hakuun www.isbnsearch.org -sivustolla. Linkit, joista puuttuu verkkotunnus avautuu google hakuun syötteenä.
