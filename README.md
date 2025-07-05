# 🛒 E-Commerce Checkout System

A **Java-based console application** that simulates a mini e-commerce platform. It supports shopping cart operations, product expiration checks, shipping fee calculations, and a complete checkout experience with detailed receipts and proper exception handling.

---

## 📦 Features

- Create and manage products (shippable, expirable, etc.)
- Add/remove items from the shopping cart
- Validate product availability, expiration, and customer balance
- Shipping cost calculation based on total weight
- Checkout process with:
  - Shipping receipt
  - Purchase receipt
  - Balance update
- Handles all business logic exceptions


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
<img width="662" alt="image" src="https://github.com/user-attachments/assets/4563f665-143e-4caf-8df2-e3ffbcd7cfdb" />
<img width="290" alt="image" src="https://github.com/user-attachments/assets/c1c5063e-de0b-4af3-a0fa-e6cd14ed4953" />

- All products are available, None are expired, The customer has enough balance, Cart is not empty, non-shippable products.
<img width="663" alt="image" src="https://github.com/user-attachments/assets/5d9b1acb-a50f-43a6-88bd-469f203ff112" />
<img width="290" alt="image" src="https://github.com/user-attachments/assets/6d83e216-b0e5-4359-ae7f-ea16e50be5d7" />

- Insufficient Customer balance (balance is 1000EGP, products total is 10240EGP).
<img width="662" alt="image" src="https://github.com/user-attachments/assets/8012d195-0e76-4659-8119-a53041faa43f" />
<img width="636" alt="image" src="https://github.com/user-attachments/assets/abe83ec2-77c5-4601-b266-8c3d45063474" />

- Insufficent product quantity (6 dinaFarms are required to be added but 5 only available).
<img width="662" alt="image" src="https://github.com/user-attachments/assets/10f41c3f-b155-4d71-aeab-3cbd3b93e6c3" />
<img width="692" alt="image" src="https://github.com/user-attachments/assets/4926b4fb-0237-4432-8f16-2198410f2533" />

- Empty cart.
<img width="664" alt="image" src="https://github.com/user-attachments/assets/d235c1f0-4859-4eb8-b7b9-a3556139d14a" />
<img width="547" alt="image" src="https://github.com/user-attachments/assets/8e0e9260-63cb-4479-a6f8-b55bd74899a5" />

- Expired products (dinaFarms,ulker expiration dates are 1-7-2025 , 10-8-2024 respectively).
<img width="661" alt="image" src="https://github.com/user-attachments/assets/7534088e-d455-4533-abd1-4b3a2580996f" />
<img width="626" alt="image" src="https://github.com/user-attachments/assets/eb7aef13-e55b-47d3-a058-2b0958d95871" />

- Removing sufficient quantity from cart.
<img width="662" alt="image" src="https://github.com/user-attachments/assets/49a0e455-dfdd-4a17-aa0a-aa39af446caf" />
<img width="316" alt="image" src="https://github.com/user-attachments/assets/c9853a54-978c-459a-bcd3-4c58a23210a7" />

- Removing insufficient quantity from cart.
<img width="659" alt="image" src="https://github.com/user-attachments/assets/951fdcc1-2f03-417e-aae5-1a1198b39526" />
<img width="745" alt="image" src="https://github.com/user-attachments/assets/0c08b75c-fc7c-4240-8a00-778e25e55be2" />
<img width="662" alt="image" src="https://github.com/user-attachments/assets/435e7a43-3014-4157-a2d6-5aa301143419" />
<img width="641" alt="image" src="https://github.com/user-attachments/assets/1cb2d545-866e-4c96-bf49-3ab327a06134" />

- Removing from cart till cart is empty
<img width="662" alt="image" src="https://github.com/user-attachments/assets/afc082a7-5e22-4a69-a42f-4e5cfcc5360c" />
<img width="539" alt="image" src="https://github.com/user-attachments/assets/a4db5f54-5af0-4d4f-8f10-5cb793d09239" />

### UML
<img width="997" alt="image" src="https://github.com/user-attachments/assets/0d0b4bd0-aa65-4511-a27e-5c35c5bcdcaf" />

### 
