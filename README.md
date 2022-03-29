# GUI-Hurtownia

Projekt to graficzny interfejs użytkownika służący do obsługi bazy danych Hurtowni.<br>
Użyte w projekcie technologie to JavaFX, JDBC, Hibernate, MySQL.<br>
Aplikacja pozwala na przeglądanie wszystkich tabel, wszystkich wierszy oraz poszczególnych wierszy wybranych przez użytkownika.<br>
Pozwala on na edycję komórek, dodawanie, usuwanie, edytowanie wierszy w każdej tabeli.<br>
W programie został dodany i skonfigurowany framework Hibernate, natomiast zapytania wykonywane są za pomocą JDBC z użyciem dialektu mySQL.<br>
Dane w tabelach zostały wygenerowane losowo za pomocą strony www.mockaroo.com.

Dokumentacja oraz instrukcja obsługi bazy danych Hurtowni.<br>
[Dokumentacja Konrad Pelc PO.pdf](https://github.com/Divisorify/GUI-Hurtownia/files/8370986/Dokumentacja.Konrad.Pelc.PO.pdf)

<h2>Opis działania aplikacji + Screenshoty</h2>

W dolnym lewym rogu znajduje się konsola rezultatów która na bieżąco informuje o sukcesach, niepowodzeniach lub ewentualnych błędach ze strony użytkownika.

<b>Przejście pomiędzy poszczególnymi tabelami:</b>
Przejście pomiędzy poszczególnymi tabelami odbywa się poprzez przyciski (Klienci, Dostawcy, Produkty, Zamówienia, ElementyZamówienia) znajdujące się w lewym górnym rogu aplikacji.<br>
<br><p align="center">
  ![obraz](https://user-images.githubusercontent.com/76397174/160681915-505df6b8-4870-483b-8bee-645c32dd74fc.png)



<b>Wyszukiwanie dowolnej frazy lub znaku:</b>
Nad każdą nazwą kolumny znajduje się puste pole tekstowe służące do wyszukania dowolnej frazy w kolumnie poniżej.  Aby skorzystać z tego pola tekstowego należy najechać na nie myszką a następnie wprowadzić dowolne znaki które chcemy wyszukać np. Jeśli szukamy klienta, który w swoim nazwisku zawiera literę ‘a’ to w polu znajdującym się nad nazwą kolumny kl_nazwisko należy wpisać ‘a’, a następnie zatwierdzić enterem. Aplikacja wyświetli wszystkie nazwiska z bazy danych które zawierają podaną frazę znajdującą się na dowolnym miejscu. <br>
  <br><p align="center">
  ![obraz](https://user-images.githubusercontent.com/76397174/160681942-c282561a-ba54-4ed3-a3ad-851fd640c18c.png)

 
Konsola rezultatów w lewym dolnym rogu wyświetli informacje stosowną do wyników wyszukiwania. W tym  przypadku wyświetli informację „Nazwisko klienta zostało znalezione” informującą o sukcesie lub błędzie w wyszukiwaniu.
Aby powrócić do wszystkich wierszy w tabeli należy kliknąć przycisk „Pokaż wszystko” lub wyczyścić wpisaną frazę i zatwierdzić Enterem.

<b>Wyszukiwanie wiersza poprzez ID:</b>
Alternatywnym sposobem wyszukiwania wiersza jest wyszukiwanie przez klucz główny znajdujący się w każdej tabeli.

<b>Dodawanie wiersza:</b>
Dodawanie wiersza (klienta, dostawcy, produktu, zamówienia, elementu zamówienia) znajduje się po lewej stronie aplikacji poniżej przycisków służących do zmiany tabel. Pola tekstowe należy wypełnić zgodnie z poleceniami umieszczonymi po lewej stronie pól tekstowych.
(Przykład produkt)
Przy wypełnianiu pól należy pamiętać, że możliwe jest dodanie tylko takiego wiersza w którym klucz obcy istnieje już w innej tabeli. W tym przykładzie jest to ID Dostawcy, jeśli podamy numer ID dostawcy który nie istnieje w bazie danych, operacja dodania nowego produktu nie powiedzie się.<br>
    <br><p align="center">
![obraz](https://user-images.githubusercontent.com/76397174/160681990-71c57fa8-a99c-4958-bdd5-d1101f216711.png)

   
Gdy wypełnimy pola tekstowe poprawnymi danymi należy kliknąć przycisk „Dodaj produkt”.<br>
     <br><p align="center">
 ![obraz](https://user-images.githubusercontent.com/76397174/160682004-7e475c92-6e4a-4838-86e5-6fe88b80688d.png)

Dane zostaną wpisane do tabeli i będą znajdować się w miejscu uporządkowanym przez nadane automatycznie ID produktu. Konsola rezultatów w zależności od sukcesu lub jego braku wyświetli odpowiedni komunikat. 



<b>Usuwanie wiersza:</b>
Usuwanie wiersza następuje poprzez wpisanie numeru ID klucza głównego (np. prod_id z tabeli Produkty) w pole tekstowe obok „ID” i naciśnięcie przycisku „Usuń”. Jeśli operacja się powiedzie, konsola rezultatów wypisze informacje o pomyślnym usunięciu wiersza.<br>
<br><p align="center">
![obraz](https://user-images.githubusercontent.com/76397174/160682021-d9c3d0aa-60a7-4268-9b41-67aa91e06e74.png)

 
W przypadku próby usunięcia wiersza który jest potrzebny w innej tabeli, w konsoli zostanie wypisany błąd opisujący niepowodzenie.<br>
<br><p align="center">
![obraz](https://user-images.githubusercontent.com/76397174/160682034-a702f289-76b3-4d95-a149-a3b29c0bf896.png)

 

<b>Aktualizacja danych w komórce:</b>
- <b>Emaila w tabeli Klienci</b> następuje po wpisaniu ID Klienta którego maila chcemy zmienić w polu tekstowym „ID” oraz wpisaniu zaktualizowanego emaila w pole „Email” . Pola te znajdują się powyżej wyświetlanej tabeli bazy danych. Zmianę zatwierdza się przyciskiem „Aktualizuj”.<br>
<br><p align="center">
 ![obraz](https://user-images.githubusercontent.com/76397174/160682047-ade0cf4d-edf6-4c6c-9418-8e3046f14c39.png)

 
- <b>Emaila w tabeli Dostawcy</b> następuje po wpisaniu ID Dostawcy w polu tekstowym „ID” oraz wpisaniu zaktualizowanego emaila w pole „Email” . Pola te znajdują się powyżej wyświetlanej tabeli bazy danych. Zmianę zatwierdza się przyciskiem „Aktualizuj”.<br>
<br><p align="center">
 ![obraz](https://user-images.githubusercontent.com/76397174/160682066-fbef9779-4dc5-4a83-bc40-0bb0784720ff.png)

 

- <b>Nazwy produktu w tabeli Produkty</b> następuje po wpisaniu ID Produktu którego nazwę chcemy zmienić w polu tekstowym „ID” oraz wpisaniu zaktualizowanej daty w pole „Data zamówienia” . Pola te znajdują się powyżej wyświetlanej tabeli bazy danych. Zmianę zatwierdza się przyciskiem „Aktualizuj”. <br>
<br><p align="center">
 ![obraz](https://user-images.githubusercontent.com/76397174/160682079-d552df22-1ca2-4f08-80c7-e55070243d60.png)

- <b>Daty zamówienia w tabeli zamówienia</b> następuje po wpisaniu numeru zamówienia którego datę chcemy zmienić w polu tekstowym „Numer zamówienia” oraz wpisaniu zaktualizowanej daty w pole „Data zamówienia” . Pola te znajdują się powyżej wyświetlanej tabeli bazy danych. Zmianę zatwierdza się przyciskiem „Aktualizuj”.<br>
<br><p align="center">
 ![obraz](https://user-images.githubusercontent.com/76397174/160682093-0e4a077b-6534-4932-9999-46951b282650.png)

 
- <b>Ilości zamówień w tabeli ElementyZamówienia</b> następuje po wpisaniu ID zamówienia którego ilość chcemy zaktualizować w pole tekstowe „ID” oraz po wpisaniu zaktualizowanej ilości w pole „Ilość”. Pola te znajdują się powyżej wyświetlanej tabeli bazy danych. Zmianę zatwierdza się przyciskiem „Aktualizuj”.<br>
<br><p align="center">
 ![obraz](https://user-images.githubusercontent.com/76397174/160682107-13063d4c-7b12-499b-9aa0-39cc90f102f3.png)

 

<b>Aktualizacja wybranej komórki:</b>
Aktualizacja dowolnej komórki w aplikacji następuje po dwukrotnym kliknięciu na pole które chcemy edytować.  
Następnie wpisujemy dane zgodnie z potrzebami. Zatwierdzenie aktualizacji następuje kliknięciem przez użytkownika przycisku Enter znajdującego się na klawiaturze użytkownika.<br>
<br><p align="center">
![obraz](https://user-images.githubusercontent.com/76397174/160682130-0d46aa4f-0205-4621-ac84-d1a3f653b7d4.png)


