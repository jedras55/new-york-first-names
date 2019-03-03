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
 - `/queryTenMostPopularFirstNames`- 10 najpopularniejszych imion
 - `/queryMostPopularFemaleName` - najpopularniejsze imię żeńskie
 - `/queryThreeMostPopularFirstCharactersWithCount` - imiona rozpoczynające się od jakich liter są najpopularniejsze. Wyświetl 3 najpopularniejsze litery wraz z ilością imion rozpoczynających się daną literą.


# Narzędzia
- Lombok - do wygenerowania boilerplate kodu (wzorzec builder, gettery, settery, konstruktory, equals&hashcode)
- OpenCSV - wygodna biblioteka do odczytu plików CSV i mapowania ich bezpośrednio na obiekty za pomocą oznaczania pól adnotacjami
- Spock - do testowania

# Repozytoria
W aplikacji skorzystałem z interfejsu `BabyNamesRepository` z metodą `findAll()` zwracającą listę obiektów klasy `BabyNames`, następnie stworzyłem trzy repozytoria implementujące ten interfejs i metodę `findAll()`. Wszystkie repozytoria oznaczyłem adnotacją `@Repository`.
- CsvRepository - za pomocą biblioteki `OpenCSV` plik csv wczytywany jest do listy obiektów `BabyNamesCsv`, a następnie w streamie mapowany do obiektów klasy `BabyNames`.
- XmlRepository - za pomocą specyfikacji `JAXB` plik xml wczytywany jest do listy obiektów `BabyNamesXml`, a następnie w streamie mapowany do obiektów klasy `BabyNames`.
- InMemoryRepository - repozytorium zwraca listę obiektów stworzonych za pomocą wzorca `Builder` ułatwiających testy aplikacji.

# Fasada
W fasadzie korzystamy z repozytorium `BabyNamesRepository`, które wstrzykujemy przez konstruktor wygenerowany z Lomboka, dzięki implementacji możemy wstrzyknąć dowolne repozytorium implementujące `BabyNamesRepository`.

# Filtrowanie danych
- `10 najpopularniejszych imion` - imiona są  grupowane do mapy, której kluczem jest imię, a wartością ilość dzieci z tym imieniem, dzięki temu ignorowane są dane takie jak rok urodzenia czy etniczność matki, wystarczy tylko posortować po wartości czyli ilości dzieci, pobrać 10 pierwszych elementów i wyciągnąć z nich imię
- `najpopularniejsze imię żeńskie` - imiona są filtrowane po płci żeńskiej, grupowane do mapy, której kluczem jest imię, a wartością ilość dzieci z tym imieniem, dzięki temu ignorowane są dane takie jak rok urodzenia czy etniczność matki, wystarczy tylko posortować po wartości czyli ilości dzieci, pobrać pierwszy element i wyciągnąć z niego imię
- `imiona rozpoczynające się od jakich liter są najpopularniejsze. Wyświetl 3 najpopularniejsze litery wraz z ilością imion rozpoczynających się daną literą` - imiona są grupowane do mapy, której kluczem jest pierwsza litera imienia, a wartością ilość dzieci z taką pierwszą literą w imieniu, następnie trzeba było posortować mapę po ilości wystąpień pierwszej litery i zwrócić jako LinkedHashMapę

# Profile
Każde repozytorium ma dodany profil (`@Profile("name")`), dzięki czemu decydujemy, które repozytorium zostanie wstrzyknięte w fasadzie. Projekt można podać jako argument przy uruchamianiu aplikacji, ale najłatwiej skorzystać z propertiesów poprzez odkomentowanie jednej z linii z wyborem profilu. Za pomocą profili decydujemy z jakiego źródła danych chcemy skorzystać.
Istnieją następujące profile:
- csv - plik csv
- xml - plik xml
- test - lista obiektów stworzona za pomocą wzorca `Builder`

# Źródła danych
Pliki z danymi zostały dodane w katalogu `resources`
