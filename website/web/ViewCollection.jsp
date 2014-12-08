<!-- <%@page import="Models.Card"%>
<%@page import="java.util.ArrayList"%> -->
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
        <title>User Home Page</title>
    </head>
    <body>	
		<!-- Start Navbar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand">
                        <div class="hoardr_icon">
                            <img alt="Brand" src="Images/Hoardr_Icon.png">
                        </div>
                        <div class="navbar-header navbar-fixed-top">
                        
                        <form method="post" action="${pageContext.request.contextPath}/UserVerify" class="navbar-form navbar-login navbar-fixed-top" role="login" align="right">
                            <p class= "username-text">Logged in as: ${currentUser}</p>
       						 <form method="post" action="${pageContext.request.contextPath}/LogOut" class="logout-button">	
            					<button type="logout" class="custom-button btn btn-default label-success">Logout</button>
        					</form>
                        </form> 	
                        </div>
                    </a>
                </div>
            </div>
        </nav>
		
		<nav class="navbar navbar-inverse navbar-fixed-top secondary-navbar" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<ul class="nav nav-tabs nav-justified">
						<li><a href="UserPage.jsp">Search</a></li>
						<li><a class="active-tab" href="ViewCollection.jsp">Collection</a></li>
						<li><a href="AccountInfo.jsp">Account</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- END Navbar -->
		
		
		<!-- Start view collection page -->
		<div class="view-collection-page">

			<div class="panel panel-default view-collection-panel">
				<!-- Statistics -->
  				<div class="panel-heading">
   					<h3 class="panel-title">Collection Statistics</h3>
  				</div>
  				<div class="panel-body">
    				<ul class="list-group">
						<li class="list-group-item"> <b>Number of Cards:</b> ${numberOfCards}</li>
    					<li class="list-group-item"> <b>Average Cost:</b> ${averageCost}</li>
    					<li class="list-group-item"> <b>Colors:</b> ${color}</li>
					</ul>
  				</div>
			</div>
			
			<div class="results">
                <ul class="list-group">

                   <%
                    ArrayList<Card> set = (ArrayList<Card>)session.getAttribute("userCards");
                        String toPage = request.getContextPath() + "/Linker";

                        for (int i = 0; i < set.size(); i++) {
                            int id = set.get(i).getId();
                            out.print("<a href=\"" + toPage + "?index=" + id + "\">" + "<li class=\"list-group-item list-group-item-success user-colection-list\">" + set.get(i).getName()); 
                        %>

        					<form method="post" action="${pageContext.request.contextPath}/LogOut" class="subtract-button">	
            					<button type="subtract" class="custom-button btn btn-default label-danger">-</button>
        					</form>
                        	 <form method="post" action="${pageContext.request.contextPath}/LogOut" class="add-button">	
            					<button type="add" class="custom-button btn btn-default label-success">+</button>
        					</form>
                                                </li></a>
                      <% 
                        }
                    %>
                </ul>
            </div>
			
		</div>
		<!-- End view collection page -->
		
		
	
		
		
		
		
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
