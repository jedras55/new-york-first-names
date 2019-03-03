# new-york-first-names

Projekt, w którym zrealizowałem wyzwanie z newslettera strony www.javastart.pl: 

```
Wyzwanie
Pod adresem https://catalog.data.gov/dataset/most-popular-baby-names-by-sex-and-mothers-ethnic-group-new-york-city-8c742 znajdują się dane na temat imion nadawanych nowo urodzonym dzieciom w latach 2011-2016 w Nowym Jorku. Dane uwzględniają dodatkowo etniczność matki.

Napisz program, który wyświetli następujące statystyki:

10 najpopularniejszych imion,
najpopularniejsze imię żeńskie,
imiona rozpoczynające się od jakich liter są najpopularniejsze. Wyświetl 3 najpopularniejsze litery wraz z ilością imion rozpoczynających się daną literą.
We wszystkich statystykach interesuje nas pełen zakres dat, czyli lata 2011-2016 i pomijamy etniczność matki.

Zachęcam Cię do wrzucenia swojego rozwiązania np. na githuba a następnie podeślij nam link w odpowiedzi na tego maila, czyli na adres newsletter@javastart.pl. W przyszłym tygodniu omówimy losowe z nadesłanych rozwiązań, wskażemy poprawną ścieżkę rozumowania i potencjalne błędy.
```

# API
Aplikacja została zrobiona w Spring Boocie, udostępnia API z trzema endpointami wyświetlającymi wymagane statystyki:
 - `/queryTenMostPopularFirstNames`
 - `/queryMostPopularFemaleName`
 - `/queryThreeMostPopularFirstCharactersWithCount`

# Narzędzia
- Lombok
- OpenCSV
- Spock

# Repozytoria
- CsvRepository
- XmlRepository
- InMemoryRepository

# Profile
- csv
- xml
- test
