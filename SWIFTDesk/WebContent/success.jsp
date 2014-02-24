<!DOCTYPE html>
<html>
   <head>
      <title>Bootstrap 101 Template</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
      
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="js/jquery-2.1.0.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files 
            as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
      
      <style>
      .dropdown-submenu{
    position:relative;
}
 
.dropdown-submenu > .dropdown-menu
{
    top:0;
    left:100%;
    margin-top:-6px;
    margin-left:-1px;
    -webkit-border-radius:0 6px 6px 6px;
    -moz-border-radius:0 6px 6px 6px;
    border-radius:0 6px 6px 6px;
}
 
.dropdown-submenu:hover > .dropdown-menu{
    display:block;
}
 
.dropdown-submenu > a:after{
    display:block;
    content:" ";
    float:right;
    width:0;
    height:0;
    border-color:transparent;
    border-style:solid;
    border-width:5px 0 5px 5px;
    border-left-color:#cccccc;
    margin-top:5px;
    margin-right:-10px;
}
 
.dropdown-submenu:hover > a:after{
    border-left-color:#ffffff;
}
 
.dropdown-submenu .pull-left{
    float:none;
}
 
.dropdown-submenu.pull-left > .dropdown-menu{
    left:-100%;
    margin-left:10px;
    -webkit-border-radius:6px 0 6px 6px;
    -moz-border-radius:6px 0 6px 6px;
    border-radius:6px 0 6px 6px;
}

      
      </style>
      
   </head>
   <body>
      <h1>Hello, world!</h1>
 <nav class="navbar navbar-default" role="navigation">
      
<div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">Brand</a>
  </div>
 
  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Link</a></li>
      <li><a href="#">Link</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Multi Level <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">Level 1</a></li>
          <li class="dropdown-submenu"> <a tabindex="-1" href="#">More options</a>
              <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="#">Level 2</a>
                  </li>
                  <li class="dropdown-submenu"> <a href="#">More..</a>
                      <ul class="dropdown-menu">
                          <li><a href="#">Level 3</a>
                          </li>
                          <li><a href="#">Level 3</a>
                          </li>
                          <li class="dropdown-submenu"> <a href="#">More..</a>
                              <ul class="dropdown-menu">
                                  <li><a href="#">Level 4</a>
                                  </li>
                                  <li><a href="#">Level 4</a>
                                  </li>
                                  <li class="dropdown-submenu"> <a href="#">More..</a>
                                      <ul class="dropdown-menu">
                                          <li><a href="#">Level 5</a>
                                          </li>
                                          <li><a href="#">Level 5</a>
                                          </li>
                                      </ul>
                                  </li>
 
                              </ul>
                          </li>
 
                      </ul>
                  </li>
                  <li><a href="#">Level 2</a>
                  </li>
                  <li><a href="#">Level 2</a>
                  </li>
              </ul>
          </li>
          <li><a href="#">Level 1</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>

	<a href="fwdToAddPayee.action">Add Payee</a>
	<br>
	<a href="fwdToTransfer.action">Fund Transfer</a>
	<br>
	<a href="fwdToMenu.action">Link adder</a>

   </body>
</html>	