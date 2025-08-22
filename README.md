# leet-code-practicing-spring-boot

ChatGPT response to give me a readme for this repo:

# 🧩 LeetCode Practice – Spring Boot Edition

Hey 👋 welcome to my little corner where I practice **LeetCode problems** using **Java + Spring Boot**.  
This repo is basically my coding gym — a place to train problem-solving muscles, try different approaches, and keep track of my progress.

---

## 🚀 What’s inside?
- Solutions to random LeetCode problems I pick up
- Written in **Java**
- Structured as a **Spring Boot project** so I can:
    - Run things easily
    - Write proper tests
    - Pretend it’s a “real project” instead of just a bunch of `.java` files

---

## 📂 Repo Structure
```bash
src/
 ├── main/java/...   # where I write the solutions
 └── test/java/...   # where I test if my brain actually works
```

## 🖥️ Environment & Java Version

This project is built using:

- **Java:** 17 (Eclipse Temurin / OpenJDK)
- **Build Tool:** Maven 3.9+
- **Framework:** Spring Boot 3.x
- **Test Framework:** JUnit 5
- **Docker:** Optional, for containerized deployment

> Note: Java 17 is a **long-term support (LTS) version**, which ensures stability and compatibility with modern libraries and Spring Boot 3.x features.

## 🛠 How to run it

If you want to play around with it yourself:

```bash
# Clone it
git clone https://github.com/<your-username>/leet-code-practicing-spring-boot.git
cd leet-code-practicing-spring-boot

# Build + run tests
mvn clean install

# Run the app (not always needed, but works)
mvn spring-boot:run
```

Or if you’re into containers:

```bash
docker build -t  leet-code-practicing-spring-boot .
docker run -p 8080:8080  leet-code-practicing-spring-boot
```

---

## 🧪 Testing
I write unit tests for most problems (because trust issues 🧐).  
Run them with:

```bash
mvn test
```

---

## 🧠 Algorithms & Approaches Implemented

Here’s a quick overview of the main algorithms and techniques implemented in this repo:

| Problem | Endpoint | Algorithm / Approach | Time Complexity | Space Complexity | LeetCode Link |
|---------|----------|--------------------|----------------|-----------------|---------------|
| Fibonacci Number | `/fibonacci/{n}` | Recursive calculation | O(2^n) | O(n) (call stack) | [🔗 Link](https://leetcode.com/problems/fibonacci-number/) |
| Palindrome Check | `/isPalindrome/{word}` | Reverse string and compare | O(n) | O(n) | [🔗 Link](https://leetcode.com/problems/palindrome-number/) |
| Two Sum | `/twoSum` | Brute-force nested loop | O(n^2) | O(1) | [🔗 Link](https://leetcode.com/problems/two-sum/) |
| Longest Substring Without Repeating Characters | `/longestSubstring/{s}` | Sliding window concept (naive nested loop implementation) | O(n^3) | O(n) | [🔗 Link](https://leetcode.com/problems/longest-substring-without-repeating-characters/) |
| Group Anagrams | `/groupAnagrams` | Sorting characters and grouping by key | O(n * k log k) | O(n * k) | [🔗 Link](https://leetcode.com/problems/group-anagrams/) |

> Notes:
> - `n` = length of input string or array, `k` = max length of a string in array.
> - Some implementations (like Fibonacci and Longest Substring) are naive and can be optimized further (recursive Fibonacci → DP/memoization, nested loops → sliding window for substring).



## 🎯 Why this repo exists

* To practice algorithms & data structures
* To keep my progress visible (and maybe motivating)
* To experiment with testing & deployment setups (like Docker + CI/CD)
* To have fun solving puzzles 🧩

## 🤝 Wanna collaborate?

This is mostly for my own practice, but if you’ve got:

* A cooler solution
* Tips for better performance
* Or just wanna geek out over algorithms

👉 Feel free to open an issue or PR!

## 📜 License

MIT — which basically means: use it, learn from it, improve it. Just don’t blame me if you copy-paste and it fails an interview 😅
