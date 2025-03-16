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
*filename: mainscreen.html*

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

*filename: mainscreen.html*
Line 17: added button to About Me page

```
<a href="/about" class="btn btn-info">About Me</a>

```

*filename: MainScreenControllerr*
Lines 55-58: added code to Map About me page
```
//Mapping to About Page
@GetMapping("/about")
public String about() { return "about.html"; }

```

*filename: about.html*
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

*filename: BootStrapData*
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

*filename applications.properties*
Line 6: changed name of DB 

```
spring.datasource.url=jdbc:h2:file:~/Ashworth-db

```








