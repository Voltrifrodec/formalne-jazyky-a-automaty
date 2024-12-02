# Zadanie 2: Jednoduchý riadkovo orientovaný kalkulátor

## Spustenie aplikácie

Odkaz na Github repozitár s riešením: [https://github.com/Voltrifrodec-formalne-jazyky-a-automaty](https://github.com/Voltrifrodec-formalne-jazyky-a-automaty)

Vytvorenie .jar súboru a spustenie aplikácie s ukážkovými príkladmi (môže vyžadovať
nainštalovaný `mvn` ; spúšťame v priečinku /aplikacia ):
> `mvn clean package`
> `java -jar ./target/zadanie2-1.0.jar`

Manuálne zadanie vstupu:
> `java -jar ./target/zadanie2-1.0.jar`

Spustenie testov:
> `mvn test`

## Rozbor riešenia

Pre riešenie zadania som využil nasledujúce veci:
- Diagram tried z [https://kurzy.kpi.fei.tuke.sk/fj/labs/05.html](https://kurzy.kpi.fei.tuke.sk/fj/labs/05.html) (Úloha 4)
- programovací jazyk Java a spúšťací nástroj Java

V gramatike máme: číslice `0-9`, operátory `+`, `-`, `*`, `/`, zátvorky `(`, `)` a premenné. Pri premenných musíme vyzvať používateľa, aby zadal hodnoty pre jednotlivé premenné.  

Následne som sa pokúsil vyriešiť zadanie podľa poznámok z prednášky a nasledovného postupu:
  
  1. <u>Načítanie vstupu</u>: Zistenie a vyzvanie používateľa v prípade, že zadal aj premenné. Dosadenie hodnôt premenných do reťazca.
  2. <u>Načítanie reťazca do Lexeru</u>: načítanie reťazca podľa schémy pomocou objektu *Lexer*, pre určenie obsahu reťazca.
  3. <u>Načítanie reťazca do Parseru</u>: načítanie spracovaného reťazca podľa schémy do objektu *Parser*, v ktorom určíme hodnotu reťazca podľa stanovených pravidiel.
  4. Vrátenie výsledku.

## Testovanie

<table>
    <tr>
        <th colspan=2>Akceptované vstupy</th>
        <th colspan=2>Neakceptované vstupy</th>
    </tr>
    <tr>
        <th>Vstup</th>
        <th>Výsledok</th>
        <th colspan=2>Vstup</th>
    </tr>
    <tr>
        <td align=center>3/3</td>
        <td align=center>1</td>
        <td align=center>5--1</td>
    </tr>
    <tr>
        <td align=center>5*2</td>
        <td align=center>10</td>
        <td align=center>1*/5</td>
    </tr>
    <tr>
        <td align=center>3-7/2</td>
        <td align=center>0</td>
        <td align=center>5-2++9</td>
    </tr>
    <tr>
        <td align=center>8*6</td>
        <td align=center>48</td>
        <td align=center>7**223</td>
    </tr>
    <tr>
        <td align=center>2*3+9-7</td>
        <td align=center>8</td>
        <td align=center>2--</td>
    </tr>
    <tr>
        <td align=center>3*2+1-3/2</td>
        <td align=center>6</td>
        <td align=center>(1+(3*2+1)3)/2)</td>
    </tr>
</table>

## Záver
Po pokuse o riešenie zadania sa mi nepodarilo vytvoriť funkčnú kalkulačku, ktorá by spĺňala všetky požiadavky. Premenné a základné operácie fungujú, avšak pri dvoj a viac ciferných číslach kalkulačka odmieta spolupracovať.