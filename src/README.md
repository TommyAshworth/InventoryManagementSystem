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






