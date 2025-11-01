# ⎋ A Colorful Terminal App With:
- Age & Zodiac detector
- Word reversal (keeps punctuation in place, supports Turkish letters)
- Prime number generators (Eratosthenes, Sundaram, Atkin) with timings
- Step-by-step arithmetic expression evaluator (`+ - x : ( )`)
- Array stats (median, arithmetic/geometric/harmonic means)
- Distances between arrays (Manhattan, Euclidean, Cosine similarity)
- Connect 4 game (single-player vs AI or two players)

Press 👇🏼 To Run

[![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/<user>/<repo>?quickstart=1)

After it opens, run:
```bash
java -jar target/*.jar

```

---

## 🧭 Main Menu

After the welcome screen, the main menu is displayed with the following options:

```
[A] Primary School
[B] Secondary School
[C] High School
[D] University
[E] Terminate
```

- The application continues running until the user selects **Terminate**.  
- If an invalid option is entered, the program notifies the user and redisplays the current menu.  
- After every selection, the **screen is cleared** to ensure a clean display.  
- Upon completing an operation, users can either **repeat** it or **return** to the related submenu.

---

## 🏫 Option A — Primary School

Selecting **Primary School** clears the screen and displays the submenu:

```
1. Age and Zodiac Sign Detection
2. Reverse the Words
3. Return to Main Menu
```

### ✴️ Age and Zodiac Sign Detection
- The user enters their **date of birth** (day, month, year).  
- The program calculates and displays:
  - **Age** (in years, months, and days)  
  - **Zodiac sign**  
- This is done **without using built-in date/time functions**, using custom methods and the current date.

### 🔄 Reverse the Words
- The user provides a **text input** (supports Turkish characters).  
- The program **reverses every word** containing two or more letters, keeping punctuation and digits unchanged.  
- Implemented using a **recursive function**.

**Example:**

**Input**
```
Çılgın köylü, 3. günün öğlesinde “İğde ağacının gölgesine oturalım mı?” diye sordu.
Şaşkın Üzeyir, 7 tane üzüm yedi, sonra gülümseyip “Şimdi dönüyoruz!” dedi.
Öykü ise, 12:45’teki trene yetişmek için hızlıca yürümeye başladı!
```

**Output**
```
nıglıÇ ülyök, 3. nünüg edniselğö "edğİ nınıcağa eniseglög mılaruto ım?" eyid udros.
nıkşaŞ riyezÜ, 7 enat müzü idey, arnos piyesmülüg "idmiŞ zuroyünö!" ided.
ükyÖ esi, 12:45'iket enert kemşitey niçi acılzıh eyemürüy ıdalşab!
```

---

## 🧮 Option B — Secondary School

Selecting **Secondary School** clears the console and displays:

```
1. Prime Numbers
2. Step-by-Step Evaluation of Expression
3. Return to Main Menu
```

### 🔢 Prime Numbers
- The user enters an integer `n ≥ 12`.  
- The program generates **all prime numbers up to `n`** using:
  - **Sieve of Eratosthenes**
  - **Sieve of Sundaram**
  - **Sieve of Atkin**
- It then shows:
  - The **first three** and **last two** primes from each method.
  - Their **execution times** for comparison.

### ➗ Step-by-Step Evaluation of Expression
- The user inputs a mathematical expression containing digits and symbols:
  ```
  +, −, ×, :, (, )
  ```
- Invalid characters or mismatched parentheses trigger a re-entry prompt.  
- The program **recursively evaluates** the expression **step by step**, following operator precedence, and prints each stage until the final result.

**Example Input:**
```
((4-5)×-3)
```

---

## 📊 Option C — High School

Selecting **High School** clears the console and presents:

```
1. Statistical Information about an Array
2. Distance between Two Arrays
3. Return to Main Menu
```

### 📈 Statistical Information about an Array
- The user enters:
  - Array size
  - Array elements (double values)
- The program computes and displays:
  - **Median**
  - **Arithmetic mean**
  - **Geometric mean**
  - **Harmonic mean** (computed recursively)
- For even-sized arrays, the appropriate **median method** is used.

### 📏 Distance between Two Arrays
- The user enters:
  - Array dimension
  - Elements of both arrays (integers within `[0–9]`)
- Invalid entries trigger a warning and retry.
- The program calculates:
  - **Manhattan Distance**
  - **Euclidean Distance**
  - **Cosine Similarity**

---

## 🎮 Option D — University (Connect Four Game)

Selecting **University** starts a **Connect Four** game.

### ⚙️ Game Setup
- Choose board size:
  ```
  5×4, 6×5, or 7×6
  ```
- Choose game mode:
  - **Single-player (vs. Computer)**
  - **Two-player**

### 🕹️ Gameplay
- Players take turns dropping discs into columns.
- If a column is full, the player must select another.
- After each move, the screen refreshes with the **updated board**.

### 🏁 Game End Conditions
- A player connects **four discs** (win)
- The board fills completely (draw)
- A player quits (forfeit)

In single-player mode, the computer’s moves can be:
- **Randomly generated**
- Or based on **AI algorithms** such as:
  - **Minimax**
  - **Alpha-Beta Pruning**
  - Optionally supported by a **heuristic evaluation function**

---

## 🧹 Notes
- Every menu and submenu is **cleared** before redisplay for better readability.
- Input validation is enforced throughout.
- All recursive and algorithmic operations are **custom-implemented**, without relying on built-in shortcuts.





