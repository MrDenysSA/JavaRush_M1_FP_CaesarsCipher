# CaesarsCipher
Що вдалося зробити:

Кінцева програма зібрана у форматі jar. 

Програму можна запустити із консолі передавши аргументи (command filePath key - саме в такому порядку.) 
command - три доступні варіанти: [ENCRYPT, DECRYPT, BRUTE_FORCE]
filepath - абсолютний(повний) шлях до файлу, який кодується.
key - ціле число, ключ для зсуву по алфавіту.

Результатом роботи програми в папці з початковим файлом повинен з'явитися файл з тим самим ім'ям, що і вхідний файл, але з поміткою [ENCRYPTED] / [DECRYPTED / BRUTE_FORCE] в залежності від виконаної операції.

Зміст файлу повинен бути закодований/декодований використовуючи шифр Цезаря.

Зсув по алфавіту має бути циклічним.
(Якщо ключ більше ніж кількість літер в алфавіті, то дойти до кінця алфавіту і почати спочатку)

Кодуються лише літери англійського алфавіту (великі та малі).

Після розшифрування текст має максимально зберегти оригінальне форматування.

Програма повинна використовувати один і той же ключ для коректного кодування та декодування файлу.

Програма має мати режим brute-force для автоматичного підпору ключа під зашифрований текст та його розшифрування.

Код програми та готовий зібраний файл jar розмістити на GitHub.

Додатково:
ДОДАТКОВО 3 - [MEDIUM] (Поціновувач зручності)
BRUTE_FORCE реалізований простим способом. (Гоняю текст 25 разів (на розмір алфавіту) зсувом на 1 ключь  і вичисляю в якому варіанті більше знайшлось слово « the ».  Таким чином знаходжу ключь шифрування. 


Не зробив :
Поліглот
Алгоритм креатор
Front end шпигун


Для Олександра ментора. 

Програма працює на шифрування, дешифрування і злом. Тестував на Гамлеті. 
Прграма страшна як чорт, але працює. 
З ООП мені слід ще попрацювати, бо важко давалося саме це. 
Вибач, що здав запізно, сів за проект лише в вівторок 16 травня. Трохи відстав від курсу занять то наздоганяв. 
Спочатку зробив програму одним списком в Main, а потім вже розкидував. Але часу замало то розкидав поганенько. Але все ж продовжу її вдосконалювати далі. 

Сподобалось працювати з проектом. Дуже добре дає змогу закріпити знання. Прийшлось передивлятися відео лекцій, щоб згадати якісь нюанси. 
Дякую тобі Олександре, дуже гарно і зрозуміло викладаєш. Після відео стає набагато зрозуміліше інформація з занять. 
