<%@page import="java.util.ArrayList"%>
<%@page import="Models.Card"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Homepage - Not logged in">
    <meta name="author" content="160 Zaibatsu">
    <link rel="icon" href="Images/Hoardr_Icon.ico">

    <title>Hoardr</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this page go here -->
	<link href="css/custom/header_stylesheet.css" rel="stylesheet">
	<link href="css/custom/search_stylesheet.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>
  <body>
	
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="HomePage.jsp">
      	<div class="hoardr_icon">
        	<img alt="Brand" src="Images/Hoardr_Icon.png">
      	</div>
		<!-- Ebrima Bold is the font for the text on the image -->
		<form method="post" action="${pageContext.request.contextPath}/UserVerify" class="navbar-form navbar-login navbar-fixed-top" role="login" align="right">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Username" name="user_name">
				<input type="text" class="form-control" placeholder="Password" name="password">
			</div>
			<button type="login" class="custom-button btn btn-default label-success">Login</button>
		</form>
        </a>
      </div>
    </div>
  </nav>

	<div class="single-card-page">
		<div class="row">
  			<div class="hello-world">
  				<div class="single-card-image">
   				 	<a href="#" class="cardpicture">
   				 		<img src="Images/CardPictures/AjaniSteadfast.jpg" alt="AjaniSteadfast">
    				</a>
    			</div>
    			<div class="single-card-text">
    				<div class="panel panel-default">
						<!-- Default panel contents -->
						  <div class="panel-heading "><b>CARD INFORMATION</b></div>
						  <!-- List group -->
						  <ul class="list-group">
							                                    <%
                                    String set = request.getParameter("set");
                                    System.out.println(set);
                                    %>
    					<li class="list-group-item"> <b>Name:</b> ${name}</li>
    					<li class="list-group-item"> <b>Colors:</b> ${color}</li>
    					<li class="list-group-item"> <b>Cost:</b> ${cost}</li>
    					<li class="list-group-item"> <b>CMC:</b> ${cmc}</li>
    					<li class="list-group-item"> <b>SuperTypes:</b> ${super_type}</li>
    					<li class="list-group-item"> <b>Types:</b> ${types}</li>
    					<li class="list-group-item"> <b>SubTypes:</b> ${subTypes}</li>
    					<li class="list-group-item"> <b>Text:</b>  ${text}</li>
    					<li class="list-group-item"> <b>Power:</b> ${power}</li>
    					<li class="list-group-item"> <b>Toughness:</b> ${toughness}</li>
						  </ul>
						</div>
    			</div>
  			</div>
		</div>
			<!-- TODO --->
			<!-- make this only show up if they are logged in -->
			<div class="input-group add-to-coll add-to-collection-form">
				<input type="text" class="form-control" placeholder="Quantity">
				<button type="add_to_collection" class="custom-button btn btn-default label-success same-line">Add to Collection</button>
			</div>
	</div>
	
     
     
     

    </div><!-- /.container -->
  
  
  
  

  
  
  

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
