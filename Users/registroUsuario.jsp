<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>User Register</title>

    <!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" >


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="css/form-validation.css" rel="stylesheet">
		<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>    
        <script src="js/pass-validation.js"> 
        </script>
  </head>
  <body class="bg-light">
    <div class="container">
  <div class="py-5 text-center">
    <h2>Registro de Usuarios</h2>
    <p class="lead">Below is an example form built entirely with Bootstrap’s form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>

    <div class="py-5 text-center">
  
      <h4 class="mb-3">Complete los datos</h4>
      <form class="needs-validation"  action="#">
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="firstName">First name</label>
            <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
            <div class="invalid-feedback">
              Valid first name is required.
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="lastName">Last name</label>
            <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
            <div class="invalid-feedback">
              Valid last name is required.
            </div>
          </div>
        </div>

		
        <div class="mb-3">
          <label for="username">Username</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">@</span>
            </div>
            <input type="text" class="form-control" id="username" placeholder="Username" required>
            <div class="invalid-feedback" style="width: 100%;">
              Your username is required.
            </div>
          </div>
        </div>

      
         
     
      <div class="mb-3">
          <label for="pass1">Password <span class="text-muted"></span></label>
          <input type="password" class="form-control" id="password" placeholder="password" required>
          <div class="invalid-feedback">
            Please enter a valid password.
          </div>
        </div>
        
         <div class="mb-3">
          <label for="pass2">Repeat Password </label>
          <input type="password" class="form-control" id="password2" placeholder="password" required>
          <div class="invalid-feedback">
          </div> <span id="error2"></span>
        </div>  
        
        	  <div class="mb-3">
          <label for="email">Email <span class="text-muted"></span></label>
          <input type="email" class="form-control" id="email" placeholder="you@example.com" required>
          <div class="invalid-feedback">
            Please enter a valid email address.
          </div>
        </div>
		
        
          <div class="row">
          <div class="col-md-5 mb-3">
            <label for="country">Planeta</label>
            <select class="custom-select d-block w-100" id="country" required>
              <option value="">Choose...</option>
              <option>Earth</option>
            </select>
            <div class="invalid-feedback">
              Please select a valid planet.
            </div>
          </div>
            <div class="col-md-4 mb-3">
            <label for="state">Raza</label>
            <select class="custom-select d-block w-100" id="state" required="">
              <option value="">Choose...</option>
              <option>Humano</option>
            </select>
            <div class="invalid-feedback">
              Please provide a valid state.
            </div>
          </div>
          
          <div class="col-md-3 mb-3">
            <label for="zip">DGU</label>
            <input type="text" class="form-control" id="zip" placeholder="" required="">
            <div class="invalid-feedback">
              DGU code required.
            </div>
          </div>
        </div>
        
        <!--<div class="custom-control custom-checkbox">
          <input type="checkbox" class="custom-control-input" id="save-info">
          <label class="custom-control-label" for="save-info">Save this information for next time</label>
        </div>
        <hr class="mb-4">

        <h4 class="mb-3">Payment</h4>

        <div class="d-block my-3">
          <div class="custom-control custom-radio">
            <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked="" required="">
            <label class="custom-control-label" for="credit">Credit card</label>
          </div>
          <div class="custom-control custom-radio">
            <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required="">
            <label class="custom-control-label" for="debit">Debit card</label>
          </div>
          <div class="custom-control custom-radio">
            <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required="">
            <label class="custom-control-label" for="paypal">PayPal</label>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="cc-name">Name on card</label>
            <input type="text" class="form-control" id="cc-name" placeholder="" required="">
            <small class="text-muted">Full name as displayed on card</small>
            <div class="invalid-feedback">
              Name on card is required
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="cc-number">Credit card number</label>
            <input type="text" class="form-control" id="cc-number" placeholder="" required="">
            <div class="invalid-feedback">
              Credit card number is required
            </div>
          </div>
        </div> 
        <div class="row">
          <div class="col-md-3 mb-3">
            <label for="cc-expiration">Expiration</label>
            <input type="text" class="form-control" id="cc-expiration" placeholder="" required="">
            <div class="invalid-feedback">
              Expiration date required
            </div>
          </div>
          <div class="col-md-3 mb-3">
            <label for="cc-cvv">CVV</label>
            <input type="text" class="form-control" id="cc-cvv" placeholder="" required="">
            <div class="invalid-feedback">
              Security code required
            </div>
          </div>
        </div>-->
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
      </form>
    </div>
  </div>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">© 2017-2019 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
      <script>window.jQuery || document.write('<script src="js/jquery-slim.min.js"><\/script>')</script><script src="js/bootstrap.bundle.min.js" ></script>   
        <script src="js/form-validation.js"></script>
</body></html>