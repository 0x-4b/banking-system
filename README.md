# Banking System CLI

[![Java](https://img.shields.io/badge/Java-8%2B-blue.svg)](https://www.oracle.com/java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

A simple Java command-line application for managing personal bank accounts. Create savings or checking accounts, deposit and withdraw funds, and view account details—all from your terminal.

---

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

---

## Features

- Create Savings or Checking accounts
- Deposit and withdraw funds with input validation
- Overdraft support for checking accounts
- Interest application for savings accounts
- View account details and balances
- Simple, interactive CLI

---

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/banking-system.git
   cd banking-system
   ```

2. **Compile the source code:**
   ```bash
   javac src/*.java
   ```

---

## Usage

1. **Run the application:**
   ```bash
   java -cp src Main
   ```

2. **Example session:**
   ```
   Welcome John Doe.
   1. Create account
   2. Deposit money
   3. Withdraw money
   4. View account info
   5. EXIT
   Choose: 1
   Choose account type (Savings / Checking): Savings
   Enter the interest rate: 0.03
   Successfully opened a Savings account. Account number: 1001
   ...
   ```

---

## Project Structure

```
banking-system/
├── src/
│   ├── AccountHolder.java
│   ├── BankAccount.java
│   ├── BankInterface.java
│   ├── CheckingAccount.java
│   ├── Main.java
│   └── SavingsAccount.java
├── .gitignore
├── README.md
└── LICENSE
```

---

## Roadmap

- [ ] Add support for multiple users
- [ ] Implement transaction history for accounts
- [ ] Add persistent storage (file or database)
- [ ] Enhance error and help messages
- [ ] Add unit and integration tests

---

## Contributing

Pull requests and suggestions are welcome!  
Please [open an issue](https://github.com/your-username/banking-system/issues) to discuss changes or enhancements, or submit a pull request.

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Author

**Your Name**  
GitHub: [@your-username](https://github.com/your-username)

---

<!--
Tips:
- Add a screenshot or GIF of the CLI in action for extra polish.
- If you use GitHub Actions or other CI, add a build badge.
- For real-world projects, add a SECURITY.md and a CODE_OF_CONDUCT.md.
-->