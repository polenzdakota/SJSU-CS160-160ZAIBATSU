
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
      <a class="navbar-brand" href="#">
      	<div class="hoardr_icon">
        	<img alt="Brand" src="Images/Hoardr_Icon.png">
      	</div>
		<!-- Ebrima Bold is the font for the text on the image -->
		<form action="${pageContext.request.contextPath}/UserVerify" class="navbar-form navbar-login navbar-fixed-top" role="login" align="right">
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
   				 		<img src="${image}" alt="AjaniSteadfast">
    				</a>
    			</div>
    			<div class="single-card-text">
    				<ul>
                                    <%
                                    String set = request.getParameter("set");
                                    System.out.println(set);
                                    %>
    					<li class:"card-info"> Name: ${Name}</li>
    					<li class:"card-info"> Colors: ${card_id}</li>
    					<li class:"card-info"> Cost: ${cost}</li>
    					<li class:"card-info"> CMC: ${cmc}</li>
    					<li class:"card-info"> SuperTypes: ${super_type}</li>
    					<li class:"card-info"> Types: ${types}</li>
    					<li class:"card-info"> SubTypes: ${subTypes}</li>
    					<li class:"card-info"> Text:  ${text}</li>
    					<li class:"card-info"> Power: ${power}</li>
    					<li class:"card-info"> Toughness: ${set.get(index).getCardtoughness()}</li>
    				</ul>
    			</div>
  			</div>
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
