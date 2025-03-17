# D287 JAVA FRAMEWORKS
<br>
Scenario - You are working for a company that licenses and customizes a software application to keep track of inventory 
in stores.Your job as a software developer is to customize this application to meet a specific customer’s needs. 
You will choose any type of customer you would like, but it must sell a product composed of parts.

For my project, 

# CHANGES MADE 
<br>
Task C. Customize the HTML user interface for your customer’s application. The user interface should include the shop 
name, the product names, and the names of the parts.
<br>
**Filename:** `mainscreen.html`

line 14: Changed title to Tommy's Electronics Store.
```
<title>Tommy's Electronics Store</title>

```

line 19: Changed h1 to Electronics Store
```
<h1>Tommy's Electronics Store</h1>

```

Task D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include 
navigation to and from the “About” page and the main screen.

**Filename:** `mainscreen.html`
Line 17: added button to About Me page

```
<a href="/about" class="btn btn-info">About Me</a>

```

**Filename:** `MainScreenControllerr`
Lines 55-58: added code to Map About me page
```
//Mapping to About Page
@GetMapping("/about")
public String about() { return "about.html"; }

```

**Filename:** `about.html`
Lines 1-30: added template similar to mainscreen.html page

```
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>About Tommy's Electronics Store</title>
</head>
<body>

<div class="container">
    <h1>About Tommy's Electronics Store</h1>
    <hr>
    <h2>Our Story</h2>
    <p>Tommy's Electronics Store was founded with the mission to provide high-quality, affordable electronics to customers in our community. We specialize in both in-house and outsourced parts for all kinds of electronic repairs and services.</p>

    <h2>Our Mission</h2>
    <p>To offer top-notch customer service while providing the best electronics and repair parts, ensuring that our customers get the best value for their money.</p>

    <h2>Our Products</h2>
    <p>We offer a wide range of electronic parts and products, including the latest gadgets, accessories, and specialized parts for repairs. We aim to be your one-stop-shop for everything electronics-related.</p>

    <hr>

    <a href="/mainscreen" class="btn btn-primary btn-sm">Back to Main Screen</a>
</div>

</body>
</html>

```
Task E. Add a sample inventory appropriate for your chosen store to the application. You should have five parts and 
five products in your sample inventory and should not overwrite existing data in the database.

**Filename:** `BootStrapData`
Changes made to this file include adding 5 products and 5 inhouse/outsourced parts. 

Added code to BootStrapData class
Lines 34-41: inhouseparts repo

```

public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository,InhousePartRepository inhousePartRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

```

Lines 45-121: Added the parts/product code

``` 

if (inhousePartRepository.count() == 0) {
            // Create an object from InhousePart class
            InhousePart ihp1 = new InhousePart();
            // Setting the values
            ihp1.setName("LED Light");
            ihp1.setInv(150);
            ihp1.setPrice(1.00);
            ihp1.setId(2);
            //Saving in inhousepartrespository
            inhousePartRepository.save(ihp1);

            // Create an object from InhousePart class
            InhousePart ihp2 = new InhousePart();
            // Setting the values
            ihp2.setName("Resistor");
            ihp2.setInv(200);
            ihp2.setPrice(0.25);
            ihp2.setId(3);
            //Saving in inhousepartrespository
            inhousePartRepository.save(ihp2);
        }

        if (outsourcedPartRepository.count() == 0) {
            //Creating an object in OutsourcedPart class
            OutsourcedPart osp1 = new OutsourcedPart();
            //Setting the values
            osp1.setCompanyName("HP");
            osp1.setName("Capacitor");
            osp1.setInv(100);
            osp1.setPrice(0.50);
            osp1.setId(1);
            //Saving in outsourcedPartRepository
            outsourcedPartRepository.save(osp1);

            //Creating an object in OutsourcedPart class
            OutsourcedPart osp2 = new OutsourcedPart();
            //Setting the values
            osp2.setCompanyName("HP");
            osp2.setName("Transistor");
            osp2.setInv(120);
            osp2.setPrice(0.75);
            osp2.setId(4);
            //Saving in outsourcedPartRepository
            outsourcedPartRepository.save(osp2);

            //Creating an object in OutsourcedPart class
            OutsourcedPart osp3 = new OutsourcedPart();
            //Setting the values
            osp3.setCompanyName("HP");
            osp3.setName("IC Chip");
            osp3.setInv(100);
            osp3.setPrice(2.50);
            osp3.setId(5);
            //Saving in outsourcedPartRepository
            outsourcedPartRepository.save(osp3);
        }


        //Products

        if (productRepository.count() == 0) {
            // Create and save Products
            Product bluetooth_Speaker = new Product("Bluetooth Speaker", 25.00, 20);
            Product smartphone_Case = new Product("Smartphone Case", 10.00, 40);
            Product hdmi_Cable = new Product("HDMI Cable", 8.00, 30);
            Product power_Bank = new Product("Power Bank", 20.00, 15);
            Product wireless_Mouse = new Product("Wireless Mouse", 12.00, 25);

            productRepository.save(bluetooth_Speaker);
            productRepository.save(smartphone_Case);
            productRepository.save(hdmi_Cable);
            productRepository.save(power_Bank);
            productRepository.save(wireless_Mouse);
        }


```

**Filename:** `applications.properties`
Line 6: changed name of DB 

```
spring.datasource.url=jdbc:h2:file:~/Ashworth-db

```

Task F: Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
• The button should decrement the inventory of that product by one. It should not affect the inventory of any of the 
associated parts.
•  Display a message that indicates the success or failure of a purchase.

Added a Buy now button to product list
**Filename:**  `mainscreen.html`

Line 86:

```
<a th:href="@{/buyProduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>

```

Added a product controller buy product
**Filename:**  `AddProductController`

This code creates a buyProduct method to check if the product is in stock. If it is in stock and the purchase is successful it will return the success confirmation page. If it is out of stock it will return a failed confirmation page. When user selects buy now on a product this code will decrement the inventory of that product by one. It does not affect the inventory of any of  the associated parts.

Lines 179-206:

```


    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") int theId, Model theModel) {
        ProductService productService = context.getBean(ProductServiceImpl.class);
        Product product =productService.findById(theId);

        int inv = product.getInv();

        if(inv == 0)
        {
            return "failure";
        }
        else
        {
            //reduce inventory value by 1
            inv -= 1;

            //Setting new value of inventory
            product.setInv(inv);

            //Saving object with new inventory value
            productService.save(product);

            return "success";
        }


    }

```

Added our 2 new files failure.html and success.html
Both of these new files returns the confirmation of either success or failure when selecting the Buy Now button.
**Filename:**  `failure.html`

```

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--    <meta charset="UTF-8">-->
    <title>Purchase Failure</title>
</head>
<body>
<h1>Your purchase was not successful</h1>

<a href="/mainscreen">Link
    to Main Screen</a>
</body>
</html>

```

**Filename:**  `success.html`

```

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--    <meta charset="UTF-8">-->
    <title>Purchase Success</title>
</head>
<body>
<h1>You successfully bought the product.</h1>

<a href="/mainscreen">Link
    to Main Screen</a>
</body>
</html>

```
Task G: Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

Modified BootStrapData.java, added setMinInv, setMaxInv to each part Inhouse & Outsourced.

**Filename:** `BootStrapData`
Lines - 53-54, 65-66, 80-81, 93-94, 106-107

```
ihp1.setMinInv(1);
ihp1.setMaxInv(100);

ihp2.setMinInv(1);
ihp2.setMaxInv(200);

osp1.setMinInv(1);
osp1.setMaxInv(100);


osp2.setMinInv(1);
osp2.setMaxInv(120);

osp3.setMinInv(1);
osp3.setMaxInv(100);

```
Added our Validator @ValidInventory to Line 23 in Part
Created our minInv and maxInv variables in our Part file
Created 4 new getter and setter methods to get and set both minInv and maxInv

**Filename:** `Part`

Line 23 -

``` 
@ValidInventory

```

Line 33- 38

```

    @Min(value = 0, message = "Min Inventory value must be positive")
    int minInv;

    @Min(value = 0, message = "Max Inventory value must be positive")
    int maxInv;

```

Line 92-107

```

    public int getMinInv() {
        return minInv;
    }

    public void setMinInv(int minInv) {
        this.minInv = minInv;
    }

    public int getMaxInv() {
        return maxInv;
    }

    public void setMaxInv(int maxInv) {
        this.maxInv = maxInv;
    }

```

Created 2 new Files

InventoryValidator and ValidInventory
Allows you to validate if the inventory value of a part is between the minimum and maximum inventory values

**Filename:** `InventoryValidator`

```
package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (context == null) return true;
        if (context != null) myContext = context;
        if (part == null) {
            return false;
        } else if (part.getInv() < part.getMinInv()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Insufficient inventory for part: " + part.getName()).addConstraintViolation();
            return false;
        } else if (part.getInv() > part.getMaxInv()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Too much inventory for part: " + part.getName()).addConstraintViolation();
            return false;
        }


        return true;
    }
}
```
**Filename:**  `ValidInventory`

```
package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {InventoryValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInventory {
    String message() default "Inventory Error.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}

```

Added two new table headers and I displayed minInv and maxinv of the tempPart object. This was to ensure that minimum
and maximum inventory values are shown on the page for each part.

**Filename:**  `mainscreen.html`

Lines 39-40

```
<th>Min Inventory</th>
<th>Max Inventory</th>

```

Lines 49-50

```

<td th:text="${tempPart.minInv}">1</td>
<td th:text="${tempPart.maxInv}">1</td>

```

Updated InhousePartForm.html and OutsourcedPartForm.html
This was for Error handling for validation errors. If I enter a inventory number higher than max inventory it will throw an error message.

**Filename:**  `InhousePartForm.html`
```
<div th:if="${#fields.hasAnyErrors()}">
        <ul>
            <li th:each="err: ${#fields.allErrors()}" th:text="${err}">

            </li>
        </ul>
    </div>

```

**Filename:**  `OutsourcedPartForm.html`

```
<div th:if="${#fields.hasAnyErrors()}">
        <ul>
            <li th:each="err: ${#fields.allErrors()}" th:text="${err}">

            </li>
        </ul>
    </div>

```

Updated applications.properties DB name and re-ran program

**Filename:**  `applications.properties`

Line 6 -

```
spring.datasource.url=jdbc:h2:file:~/TommyAshdb-130
```

Task H: Task H: H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

New validator for min inventory
Added error message for min inventory when updating parts used in products.
**filename** `ValidMin.java`
Lines 1-24

```
package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {MinValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMin {
    String message() default "Below the minimum";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}

```

**filename** `MinValidator`

Lines 1-32

```
package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class MinValidator implements ConstraintValidator<ValidMin, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidMin constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        return part.getInv() > part.getMinInv();
    }
}


```

Adding model class validator to Part.java

**filename** `Part.java`

Line 24-25 -

```
@ValidMin
@ValidMax
```

Enhanced EnufPartsValidator.java for inventory validation
Modified the isValid method in EnufPartsValidator.java to include validation logic that checks the inventory for associated parts if they fall below the min threshold when the product inventory is decremented.

Added a check to ensure that the remaining inventory of each part is sufficient to meet the min inventory requirement after adjusting for a product purchase.

Created custom error messages using ConstraintValidatorContext to provide more informative feedback when the validation fails, ensuring users are notified when there is insufficient inventory for a part.

**filename** `EnufPartsValidator`

Lines 36-44

```
    if (p.getInv()<(product.getInv()-myProduct.getInv())) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate("Insufficient inventory for part: " + p.getName()).addConstraintViolation();
                    return false;
                }
            }
            return true;
        }
        return false;
```

Created 2 new files ValidMax Annotation and MaxValidator for Inventory Validation.
Created a custom validation annotation@ValidMax to enforce the rule that part inventory should not exceed the max inventory limit.
Created the MaxValidator class, implementing the ConstraintValidator, to check if a part's inventory exceeds its max allowed value.
The isValid method in MaxValidator compares the part's inventory to the maxInv value and returns false if the inventory is greater than the max, triggering an error.
The custom error message "Count is above maximum" is provided through the ValidMax annotation.

**filename** `MaxValidator`
Lines 1-29
```
package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class MaxValidator implements ConstraintValidator<ValidMax, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidMax constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        return part.getInv() > part.getMaxInv();
    }
}

```

**filename** `ValidMax`

Lines 1-26

```
package com.example.demo.validators;

import com.example.demo.validators.MaxValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {MaxValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMax {
    String message() default "Count is above Maximum";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}


```


Task I: Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

2 unit tests for the max and min fields to the PartTest class in the test package.
getMinAndMax verifies that the getMinInv() and getMaxInv() methods return the correct values after setting them.

setMinAndMax() test verifies that the setMinInv() and setMaxInv() methods correctly store the values. 

**filename** `PartTest`

Lines 159-193:

```


    @Test
    void getMinAndMax() {
        int minValue = 1;
        int maxValue = 10;

        partIn.setMinInv(minValue);
        partIn.setMaxInv(maxValue);
        assertEquals(minValue, partIn.getMinInv());
        assertEquals(maxValue, partIn.getMaxInv());

        partOut.setMinInv(minValue);
        partOut.setMaxInv(maxValue);
        assertEquals(minValue, partOut.getMinInv());
        assertEquals(maxValue, partOut.getMaxInv());
    }

    @Test
    void setMinAndMax() {
        int minValue = 1;
        int maxValue = 10;

        partIn.setMinInv(minValue);
        partIn.setMaxInv(maxValue);

        assertEquals(minValue, partIn.getMinInv());
        assertEquals(maxValue, partIn.getMaxInv());

        partOut.setMinInv(minValue);
        partOut.setMaxInv(maxValue);

        assertEquals(minValue, partOut.getMinInv());
        assertEquals(maxValue, partOut.getMaxInv());
    }
}

```

Task J: Remove the class files for any unused validators in order to clean your code.

Deleted Unused Validator

**filename** `DeletePartValidator.java`
**filename** `ValidDeletePart.java`









