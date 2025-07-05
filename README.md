# 🛒 E-Commerce Checkout System

This is a **Java-based console application** simulating a basic e-commerce platform. It supports product management, shopping cart operations, shipping fee calculation, and a full checkout process — all with proper validation and error handling.

---

## 📦 Features

- Define products with `name`, `price`, and `quantity`
- Support for:
  - **Expirable** products (e.g., Cheese, Biscuits)
  - **Shippable** products with weights (e.g., Cheese, TV)
  - **Non-expirable, non-shippable** products (e.g., Scratch Cards)
- Add/remove products from cart
- Cart operations respect:
  - Product availability
  - Expiration status
- Checkout includes:
  - Empty cart check
  - Product expiration check
  - Balance verification
  - Shipping fee calculation
  - Receipt + shipment notice printing
- Custom exception handling

---

## 📄 Shipping Fee Calculation

- **10 EGP** for total weight ≤ 10 kg
- +10 EGP for every additional 10 kg or part thereof

### Example Table:

| Total Weight (kg) | Shipping Fee |
|-------------------|--------------|
| 7 kg              | 10 EGP       |
| 10 kg             | 10 EGP       |
| 11 kg             | 20 EGP       |
| 15 kg             | 20 EGP       |
| 21 kg             | 30 EGP       |

> **Formula:**  
> `Shipping Fee = 10 × ceil(totalWeightInKg / 10)`

## 🚨 Exceptions Handled
- EmptyCartException – When trying to checkout with an empty cart
- ExpiredProductException – When any cart item is expired
- InsufficientBalanceException – When the customer's balance is insufficient
- InsufficientQuantityException – When requested quantity exceeds stock or cart items

## 📌Assumptions
- The shipping cost is calculated based on the total weight of all shippable items in the cart:
  - 10 EGP for total weight up to 10 kg
  - An additional 10 EGP is added for every 10 kg or part thereof
- Weight is entered in grams
- Date is entered in the following format : (day-month-year)
- Removing from cart functionality is added
- All exceptions are unchecked (runtime)
- Cart holds product references with corresponding quantity


## Examples
- All products are available, None are expired, The customer has enough balance, Cart is not empty, Including shippable and non-shippable products.
<img width="671" alt="image" src="https://github.com/user-attachments/assets/77419f16-8b5d-4b32-a6f6-4b443d260b54" />
<img width="290" alt="image" src="https://github.com/user-attachments/assets/c1c5063e-de0b-4af3-a0fa-e6cd14ed4953" />

- All products are available, None are expired, The customer has enough balance, Cart is not empty, non-shippable products.
<img width="666" alt="image" src="https://github.com/user-attachments/assets/b0547c49-4bdc-4286-a91b-fcdd33fca23e" />
<img width="290" alt="image" src="https://github.com/user-attachments/assets/6d83e216-b0e5-4359-ae7f-ea16e50be5d7" />

- Insufficient Customer balance (balance is 1000EGP, products total is 10240EGP).
<img width="665" alt="image" src="https://github.com/user-attachments/assets/5a7e23db-e46c-4deb-b1d5-dc1e7fb9d291" />
<img width="641" alt="image" src="https://github.com/user-attachments/assets/9872ebce-c7fe-40f1-899f-6d2a0a4c39d2" />

- Insufficent product quantity (6 dinaFarms are required to be added but 5 only available).
<img width="660" alt="image" src="https://github.com/user-attachments/assets/8e2011eb-acf6-438c-933d-267dc4d19fe7" />
<img width="695" alt="image" src="https://github.com/user-attachments/assets/a4ed9920-d956-4722-b745-5b8152d477af" />

- Empty cart.
<img width="662" alt="image" src="https://github.com/user-attachments/assets/8bcd145e-3ab1-4efc-a44c-4af70821cf1b" />
<img width="536" alt="image" src="https://github.com/user-attachments/assets/049590af-4fea-4f3a-a139-1e4daf925380" />

- Expired product (dina farms expiration date is 1-7-2025).
<img width="662" alt="image" src="https://github.com/user-attachments/assets/f7cd5599-4a53-481a-9d9d-23d6bd8c1ff8" />
<img width="602" alt="image" src="https://github.com/user-attachments/assets/103d03f1-dd4f-4303-a9c2-280e87fff313" />

- Removing sufficient quantity from cart.
<img width="663" alt="image" src="https://github.com/user-attachments/assets/27027596-50ff-42b1-8f63-d7a00e8ce008" />
<img width="316" alt="image" src="https://github.com/user-attachments/assets/c9853a54-978c-459a-bcd3-4c58a23210a7" />

- Removing insufficient quantity from cart.
<img width="664" alt="image" src="https://github.com/user-attachments/assets/8ae6d7b5-995b-4c04-9bb3-5f7529f9f795" />
<img width="739" alt="image" src="https://github.com/user-attachments/assets/7461b64c-703c-4751-90d7-5b44a8f4fc87" />
<img width="664" alt="image" src="https://github.com/user-attachments/assets/d6276cae-173e-4f3e-a179-e0bb17813feb" />
<img width="649" alt="image" src="https://github.com/user-attachments/assets/cc01525b-8f88-40a4-93be-39c4420dde15" />

- Removing from cart till cart is empty
<img width="661" alt="image" src="https://github.com/user-attachments/assets/3b058b2d-9848-48dd-b86b-093a737047d4" />
<img width="553" alt="image" src="https://github.com/user-attachments/assets/b30345a6-1e66-4170-9881-e0a15a45150f" />

## 🚀 How to Run
### ✅ Prerequisites
Before running the project, make sure you have:
- Java 17+
- Maven

### Running
```bash
cd E-Commerce-CLI
mvn compile
mvn exec:java -Dexec.mainClass="Main.Main"
```
### 
