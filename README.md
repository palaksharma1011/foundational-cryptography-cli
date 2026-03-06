

# 🎴 Foundational Cryptography CLI Suite

> **“Explore the power of classical ciphers — encrypt, decrypt, and understand cryptography!”**

This project is a **command-line interface (CLI) suite implementing 6 classical ciphers in Java**. It provides a **hands-on playground for cryptography enthusiasts** to experiment with encryption algorithms, explore edge cases, and visualize step-by-step processes in a real coding environment.

---

## ✨ Features

* ✅ **Six classical ciphers implemented**:

  1. **Caesar Cipher** – shift-based letter substitution
  2. **Monoalphabetic Cipher** – fixed-letter mapping substitution
  3. **Playfair Cipher** – digraph encryption using a 5x5 key matrix
  4. **Hill Cipher** – matrix-based encryption (linear algebra)
  5. **Vernam Cipher** – XOR-based one-time pad
  6. **Transposition Cipher** – columnar rearrangement encryption

* 💡 **Edge-case handling:** repeated letters, odd-length plaintext, normalization (`J → I`)

* 🎮 Fully interactive **CLI workflow**, allowing users to choose ciphers, input keys, and encrypt/decrypt text

* 🛠 **Step-by-step processing:** shows encryption/decryption logic clearly

* 🔀 **Clean code architecture:** modular methods for each cipher, reusable utilities

---

## 🚀 Project Preview

<img width="521" height="943" alt="CLI Screenshot" src="https://github.com/user-attachments/assets/84b31f6d-d201-46c6-ad94-bade65fd7dc3" />

---

## 📝 How It Works

1. **Input**

   * User enters plaintext and key
   * Input normalization:

     * All letters → uppercase
     * Spaces removed
     * `J` replaced with `I` for Playfair
     * Odd-length plaintext padded with `X`

2. **Cipher Selection**

   * User selects a cipher from CLI menu
   * Program routes input to the corresponding cipher algorithm

3. **Encryption / Decryption**

   * Each cipher applies its algorithm:

     * **Caesar**: shifts letters by key
     * **Monoalphabetic**: substitutes letters based on mapping
     * **Playfair**: encrypts digraphs using a 5x5 matrix
     * **Hill**: multiplies matrices modulo 26
     * **Vernam**: performs XOR with key
     * **Transposition**: rearranges columns based on key

4. **Output**

   * Displays encrypted text
   * Restores plaintext with decryption
   * Handles edge cases smoothly

---

## 💡 Why This Project Stands Out

* Demonstrates **algorithm implementation** in Java
* Strengthens **problem-solving and debugging skills**
* Provides **practical understanding of classical cryptography**
* Shows **full CLI workflow** with interactive menus
* Ready for **future expansion** into GUI or web-based applications

---

## ⚡ Getting Started

### Requirements

* Java JDK 11+
* Terminal/command-line access

### Running the Project

1. Clone the repository:

```bash
git clone https://github.com/your-username/classical-cryptography-cli.git
```

2. Navigate to project folder:

```bash
cd classical-cryptography-cli
```

3. Compile and run:

```bash
javac main.java
java main
```

4. Follow CLI prompts to select cipher, enter plaintext/key, and see encryption/decryption in action.


---

## 🔮 Future Improvements

* Add **GUI or Web version** with live animations
* Enable **file encryption/decryption** for longer texts
* Modularize code: **each cipher as a separate class implementing a common interface**
* Add **unit tests** for correctness of all ciphers

---

## 🛡 License

MIT License

---
