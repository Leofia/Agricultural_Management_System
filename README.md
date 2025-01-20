# Agricultural Product Management System

This project is a Java-based console application designed for managing agricultural products. The project aims to manage suppliers, stores, and various types of products (fruits and vegetables).

## Project Description

This application primarily performs the following functions:

*   **Supplier Management:** Define suppliers, manage their budgets, and the lists of products they own.
*   **Store Management:** Define stores, manage their storage capacity, and the lists of fruits they contain.
*   **Product Management:** Define fruits and vegetables, specify their properties (weight, season, price, etc.), and associate them with suppliers or stores.
*   **Product Trading:** Allow suppliers to purchase fruits from stores and sell their own fruits to stores.
*   **Product Storage:** Manage the storage of fruits in stores and track their storage capacity.
*   **Menu-Driven Usage:** Provide a console interface that allows users to interact with the application using a menu.

## Project Structure

The project consists of the following main classes:

*   **`Crop` (Abstract Class):** The base class for all products. Holds attributes like name, weight, and cultivated season. Its subclasses are `Fruit` and `Vegetable`.
*   **`Fruit`:** The product class for fruits. Inherits from the `Crop` class. Holds attributes for taste, price, and `CropKeeper` (store/supplier) information.
*   **`Vegetable`:** The product class for vegetables. Inherits from the `Crop` class. Holds attributes for the cultivation region and `CropKeeper` information.
*   **`Store`:** The class that represents stores. Holds attributes for store ID, name, maximum capacity, and the list of fruits it stores. Implements the `CropKeeper` interface.
*   **`Supplier`:** The class that represents suppliers. Holds attributes for supplier ID, name, budget, and the list of products they own. Implements the `CropKeeper` interface.
*   **`CropKeeper` (Interface):** The interface for classes that can hold products. The `Store` and `Supplier` classes implement this interface. It includes the `howToStore` method.
*   **`TestClass`:** The main application class. Displays the menu, takes input from the user, and executes the operations.
*   **`Exceptions`:** The class for custom exceptions (e.g., `CapacityNotEnoughException`, `FruitNotFoundException`, etc.).
*   **`TextFileHandler`:** A helper class for loading data from files (suppliers.txt, stores.txt, crops.txt) and creating classes at the start of the program.

## Setup

1.  **Install Java Development Environment:** Make sure that the Java Development Kit (JDK) is installed on your computer.
2.  **Create the Required Files:**
    *   Create `Suppliers.txt`, `Stores.txt`, and `Crops.txt` files and place them in your project directory.
        *   **`Suppliers.txt`:** Add supplier information (supplier name, supplier ID, budget) on each line, like this:
            ```
            ArazMeyve, 1133, 1000
            AylarTarim, 1298, 1500
            HasanBey, 1322, 200
            ZehraCiftci, 1429, 1250
            ```
        *   **`Stores.txt`:** Add store information (store name, store ID, maximum capacity, KGperSquareMeter) on each line, like this:
            ```
             Migros, 5343, 1000, 12
             File, 5967, 1200, 10
            ```
        *   **`Crops.txt`:** Add product information on each line (for fruits: name, type, kilogram, season, taste, price, cropKeeper ID, and for vegetables: name, type, kilogram, season, city, cropKeeper ID), like this:
            ```
            RedApple, fruit, 45, winter, sweet, 3, 1133
            Orange, fruit, 50, autumn, sour, 4, 5967
            Kiwi, fruit, 10, autumn, sour, 10, 1133
            Parsley, vegetable, 25, Samsun, 1429
            Mint, vegetable, 15, Adana, 1429
            GreenApple, fruit, 25, winter, sweet, 6, 1133
            Orange, fruit, 20, autumn, sour, 4, 1322
            GreenApple, fruit, 5, winter, sweet, 6, 5343
            GreenBeans, vegetable, 22, Bursa, 1322
            Banana, fruit, 63, summer, sweet, 12, 5343
            ```
3.  **Create Java Files:** Create the Java files in the project structure (`Crop.java`, `Fruit.java`, `Vegetable.java`, `Store.java`, `Supplier.java`, `CropKeeper.java`, `TestClass.java`, `Exceptions.java`, `TextFileHandler.java`) and save them in the same directory.
4.  **Compile the Project:** Open the command line (terminal or cmd), navigate to the directory where your project files are located, and compile the project using the following command:
    ```
    javac *.java
    ```
5.  **Run the Project:** After successful compilation, start the project by running the following command:
    ```
    java TestClass
    ```

## Usage

When the application starts, a menu will be displayed. You can use the following options from the menu:

1.  **Display all suppliers:** Lists all suppliers and the products they own.
2.  **Display all stores:** Lists all stores and the fruits they contain.
3.  **Buy a fruit crop for a Supplier:** Allows a supplier to purchase a fruit from a store.
4.  **Sell a fruit crop of a Supplier:** Allows a supplier to sell a fruit they own to a store.
5.  **Remove a fruit from a store:** Removes a fruit from a store.
6.  **Remove a crop from a supplier:** Removes a product from a supplier's list of owned products.
7.  **Add crop:** Adds a new product (fruit or vegetable).
8.  **Show remaining budget:** Displays the remaining budget of a supplier.
9.  **Show remaining capacity:** Displays the remaining storage capacity of a store.
10. **Quit:** Exits the application.

Enter the required information for each option to perform the corresponding operations.

## Notes

*   All IDs must be unique and in the correct format (store IDs should start with 5, supplier IDs should start with 1).
*   The program assumes that the specified data files are in the correct format.
*   When adding new products, you need to enter the correct ID of the corresponding CropKeeper.

## Contributing

This project is open source. If you would like to contribute, please follow the steps in the GitHub repository.

