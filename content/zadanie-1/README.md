# Zadanie 1: Akceptor pre konkrétny regulárny výraz

## Znenie zadania

Úlohou je napísať program v jednom z jazykov C, Python, Java, ktorý bude realizovať akceptor pre konkrétny regulárny výraz. Aplikácia sa bude spúšťať z konzoly, na vstupe bude textový reťazec (môže byť zadaný z klávesnice manuálne alebo zo súboru ako parameter príkazového riadku).
Program daný reťazec prečíta a na konci vypíše informáciu, či daný reťazec je alebo nie je akceptovaný.

Príklad: regex: 0|1(0|1)
    vstup: 0123, výstup: N
    vstup: 0000001, výstup: N
    vstup: 10110110, výstup: A

Pri implementácii nie je možné použiť žiadnu knižnicu daného jazyka pre regulárne výrazy. Možné je použiť len konštrukty ako *if*, *while*, príp. dekomponovať program na vlastné funkcie.

K vypracovanému programu je potrebné pripraviť stručnú dokumentáciu (*pdf* alebo *txt*), kde bude uvedený Váš regulárny výraz, stručný rozbor riešenia, prípadne opis algoritmu a príklady. Program môžete doplniť o unit testy.

**Váš regulárny výraz**: `[a]b{a|b}`

----

## Dokumentácia

Dokumentáciu je možné nájsť v súbore [<img src="/assets/pdf-icon.png" width=12> dokumentacia.pdf](#).

<!-- FIXME: V produkcii vymazať túto podkategóriu -->
### Dokumentácia

Váš regulárny výraz, stručný rozbor riešenia, prípadne opis algoritmu a príklady.

Pridať obrázok pre vytvorený stavový automat (vygenerovaný na TUKE stránke).

### Výsledný algoritmus

Celý program sa nachádza v súbore [<img src="/assets/java-icon.png" width=12> AcceptorForRegularExpression.java](#).

```java
(cely algoritmus pojde sem)
``` 

<!-- Reference: https://www.flaticon.com/free-icons/java -->
<!-- Reference: https://www.flaticon.com/free-icons/pdf -->