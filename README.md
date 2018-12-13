# DefinitionOfGettingThere lukuvinkkikirjasto

Ryhmän DefinitionOfGettingThere OhtuMiniProjekti. Syksyn 2018 ohjelmiostotuotantokurssin projektiryhmätyö. Projektissa harjoitellaan ohjelmistotuotantoprojektien hallintaa sekä työvaiheiden ja työvälineiden perusteita. Erityinen painotus ketterissä ohjelmistotuotantomenetelmissä.

Miniprojektissa on toteutettu asiakkaan toiveiden mukainen lukuvinkkikirjasto lukuvinkkien tallennukseen ja järjestämiseen. Projektin lukuvinkkikirjastoon voi lisätä erilaisia lukuvinkkkityyppejä: kirjoja, videoita, uutisia, artikkeleita ja blogeja. Käyttäjä voi selata kaikkia lukuvinkkejä, tai haluamiaan lukuvinkkityyppejä listaamalla ne taulukkonäkymänä. Käyttäjä voi taulukkonäkymästä valita luettavaksi yksittäisen lukuvinkin kaikki tiedot. Lukuvinkkejä voi myös hakea annetulla hakusanalla ja luetun lukuvinkin voi merkata luetuksi.
 
Sovellus on toteutettu käyttäjän omalle koneelle ladattavaksi paikalliseksi ohjelmaksi. Sovellukseen on toteutettu komentoriviltä toimiva konsolipohjainen käyttöliittymä ja tietojen tallennukseen käytetään SQLlite [tietokantaa](https://github.com/wood101/DefinitionOfDone-Lukuvinkkikirjasto/blob/dev/Dokumentaatio/Tietokanta.md). Sovellus on toteutettu javalla Gradle build työkalulla. Testaamisessa on käytössä JUnit sekä Cucumber testit. Jatkuvaan integraatioon CI on käytetty Travisis-ci:tä ja testikattavuuksien tarkateluun Codecovia.

## Releases

- [Versio 0.7.1 (sprintti3)](https://github.com/wood101/DefinitionOfDone-Lukuvinkkikirjasto/releases/tag/sprintti3)
- [Versio 0.5 (sprintti2)](https://github.com/wood101/DefinitionOfDone-Lukuvinkkikirjasto/releases/tag/sprintti2)

## [Product backlog Google Docissa](https://docs.google.com/spreadsheets/d/1O1Wx9K8pMFfu_qx0O7vAwgkPlIZMfkedQ_htNHWB_vM/edit#gid=1)

## Sprint Backlogit, tuntimäärän seuranta ja Sprint burndown-käyrä
- [Sprint 1](https://docs.google.com/spreadsheets/d/1O1Wx9K8pMFfu_qx0O7vAwgkPlIZMfkedQ_htNHWB_vM/edit#gid=0)
- [Sprint 2](https://docs.google.com/spreadsheets/d/1O1Wx9K8pMFfu_qx0O7vAwgkPlIZMfkedQ_htNHWB_vM/edit#gid=8)
- [Sprint 3](https://docs.google.com/spreadsheets/d/1O1Wx9K8pMFfu_qx0O7vAwgkPlIZMfkedQ_htNHWB_vM/edit#gid=9)
- [Sprint 4](https://docs.google.com/spreadsheets/d/1O1Wx9K8pMFfu_qx0O7vAwgkPlIZMfkedQ_htNHWB_vM/edit#gid=10)

![Burndown](https://docs.google.com/spreadsheets/d/e/2PACX-1vTwiW73bz3xJJ_O7aSzIQp0EG4SxYkBAQRtRdOOR62CW1Xr14Pwmu-S_C0F0OWvfpb6QeqwDv1VbTVv/pubchart?oid=16&format=image)

## [Definition of done](https://github.com/wood101/DefinitionOfDone-Lukuvinkkikirjasto/blob/master/Dokumentaatio/DefinitionOfDone.md)

## [CI:travis](https://travis-ci.com/wood101/DefinitionOfDone-Lukuvinkkikirjasto)
[![Build Status](https://travis-ci.com/wood101/DefinitionOfDone-Lukuvinkkikirjasto.svg?branch=master)](https://travis-ci.com/wood101/DefinitionOfDone-Lukuvinkkikirjasto)

## [Testikattavuus](https://codecov.io/gh/wood101/DefinitionOfDone-Lukuvinkkikirjasto) 
[![codecov](https://codecov.io/gh/wood101/DefinitionOfDone-Lukuvinkkikirjasto/branch/master/graph/badge.svg)](https://codecov.io/gh/wood101/DefinitionOfDone-Lukuvinkkikirjasto)

## [Lisenssi](https://github.com/wood101/DefinitionOfDone-Lukuvinkkikirjasto/blob/dev/LICENSE.md)

## [Käyttöohje](https://github.com/wood101/DefinitionOfDone-Lukuvinkkikirjasto/blob/master/Dokumentaatio/kaytto-ohje.md)

### Tekijät:

  - [Harri Mehtälä](https://github.com/hajame)
  - [Heli Huhtilainen](https://github.com/apndx)
  - [Olli Bisi](https://github.com/obisi)
  - [Jesper Pettersson](https://github.com/stadibo)
  - [Virva Svala](https://github.com/vsvala)
  - [Janne Malin](https://github.com/wood101)


